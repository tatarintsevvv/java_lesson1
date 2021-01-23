package info.tatarintsev;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.SocketException;
import java.net.Socket;
import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

class Server {
    static final Logger rootLogger = LogManager.getRootLogger();
    static final Logger userLogger = LogManager.getLogger(Server.class);

    // хэшмап для хранения
    HashMap<String, LocalDateTime> clientHashes;
    List<ClientHandler> clients = new ArrayList<>();
    List<Message> messages = new LinkedList<>();
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
            userLogger.fatal("fatal error: " + e.getMessage());
        } catch (IOException e) {
            userLogger.fatal("fatal error: " + e.getMessage());
        } finally {
            executorService.shutdown();
        }
    }

    synchronized void sendServiceMessage(String text) {
        messages.add(new ServiceMessage(text));
    }

    void sendServicePrivateMessage(String recipient, String text) {
        messages.add(new ServicePrivateMessage(recipient, text));
    }


    synchronized void sendPrivateMessage(String senderLogin, String recipientLogin, String text) {
        messages.add(new PrivateMessage(senderLogin, recipientLogin, text));
    }

    synchronized void onNewClient(ClientHandler clientHandler) {
        clients.add(clientHandler);
        sendServiceMessage(clientHandler.client.getName() + " вошел в чат");
    }

    synchronized void onClientDisconnected(ClientHandler clientHandler) {
        clients.remove(clientHandler);
        sendServiceMessage( clientHandler.client.getName() + " покинул чат");
    }

    public static void main(String[] args) {
        rootLogger.info("Сервер начал работу");
        new Server();
        rootLogger.info("Сервер завершил работу");
    }
}
