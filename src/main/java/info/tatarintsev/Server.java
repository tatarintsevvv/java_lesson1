package info.tatarintsev;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.SocketException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Server {

    List<ClientHandler> clients = new ArrayList<>();
    Map<String, List<Message>> messages = new HashMap<>();
    private ExecutorService executorService;

    Server() {
        try (ServerSocket serverSocket = new ServerSocket(8082);) {
            AuthService authService = new AuthService();
            executorService = Executors.newCachedThreadPool();
            // Обработчик клиентов
            while (true) {
                Socket socket = serverSocket.accept();
                ClientHandler clientHandler = new ClientHandler(authService, this, socket);
                executorService.submit(new ClientRunnable(clientHandler));
            }
        } catch (SocketException e) {
            System.out.println("Ошибка сокета");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Сервер прекратил работу с ошибкой");
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }
    }

    synchronized void sendBroadCastMessage(Client sender, String text) {
        for (int i = 0; i < clients.size(); i++) {
            String recipientLogin = clients.get(i).client.login;
            sendMessageTo(sender, recipientLogin, text);
        }
    }

    synchronized void sendMessageTo(Client sender, String recipientLogin, String text) {
        // Получаем лон получателя для поиска
        String senderLogin = sender.login;
        // Генерируем ключь чата
        String key;
        if (senderLogin.compareTo(recipientLogin) > 0) {
            key = senderLogin + recipientLogin;
        } else {
            key = recipientLogin + senderLogin;
        }
        // Проверяем создан ли чат и если нет то создаём
        if (!messages.containsKey(key)) {
            // Создаём список сообщений для чата
            messages.put(key, new ArrayList());
        }
        // Сохраняем сообщение в чат,
        messages.get(key).add(new BroadcastMessage(sender, text));
        // Ищем получателя среди клиентов
        /*
        ClientHandler recipient = null;
        for (int i = 0; i < clients.size(); i++) {
            ClientHandler client = clients.get(i);
            if (client.client.login.equals(recipientLogin)) {
                recipient = client;
            }
        }
         */
    }

    synchronized void onNewClient(ClientHandler clientHandler) {
        clients.add(clientHandler);
        sendBroadCastMessage(clientHandler.client, "Вошел в чат");
    }

    synchronized void onClientDisconnected(ClientHandler clientHandler) {
        clients.remove(clientHandler);
        sendBroadCastMessage(clientHandler.client, "Покинул чат");
    }

    public static void main(String[] args) {
        new Server();
    }
}
