package info.tatarintsev;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;

class ClientHandler {
    AuthService authService;
    Server server;
    Socket socket;
    Client client;

    ClientHandler(AuthService authService, Server server, Socket socket) throws SocketException {
        this.authService = authService;
        this.server = server;
        this.socket = socket;
        // выставляю таймаут для сокета в 120 секунд. если пользователь авторизуется за 120
        // секунд, то таймаут выставлю в 0, если нет, пользователь вылетит по исключению
        // таймаута
        //        this.socket.setSoTimeout(120);
    }

    void sendMessage(DataOutputStream dataOutputStream, Client client, String text) {
        try {
            dataOutputStream.writeUTF("/nm " + client.name + ": " + text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean auth(DataInputStream dataInputStream, DataOutputStream dataOutputStream) throws IOException {
        // Цикл ожидания авторизации клиентов
        int tryCount = 0;
        int maxTryCount = 5;
        while (true) {
            // Читаем комманду от клиента
            String newMessage = dataInputStream.readUTF();
            // Разбиваем сообщение на состовляющие комманды
            String[] messageData = newMessage.split("\\s");
            // Проверяем соответсует ли комманда комманде авторизации
            if (messageData.length == 3 && messageData[0].equals("/auth")) {
                tryCount++;
                String login = messageData[1];
                String password = messageData[2];
                // Зарегистрирован ли данных пользователь
                client = authService.auth(login, password);
                if (client != null) {
                    // Если получилось авторизоваться то выходим из цикла
                    dataOutputStream.writeUTF("/auth ok");
                    System.out.println("Login success");
                    break;
                } else {
                    dataOutputStream.writeUTF("Неправильные логин и пароль!");
                }
            } else {
                dataOutputStream.writeUTF("Ошибка авторизации!");
            }
            if (tryCount == maxTryCount) {
                dataOutputStream.writeUTF("Первышен лимит попыток!");
                return false;
            }
        }
        return true;
    }

    private void messageListener(DataInputStream dataInputStream, DataOutputStream dataOutputStream) throws IOException {
        while (true) {
            String newMessage = dataInputStream.readUTF();
            if (newMessage.equals("/exit")) {
                dataOutputStream.writeUTF("/exit ok");
            } else if (newMessage.startsWith("/w ")) {
                String messageWithoutCommand = newMessage.substring(3);
                int messageIndex = messageWithoutCommand.indexOf(" ");
                String nick = messageWithoutCommand.substring(0, messageIndex);
                String message = messageWithoutCommand.substring(messageIndex);
                dataOutputStream.writeUTF("/w ok");
                server.sendMessageTo(client, nick, message);
            } else {
                dataOutputStream.writeUTF("/b ok");
                server.sendBroadCastMessage(client, newMessage);
            }
        }
    }

    void execute() throws IOException {
        try (
                DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
                DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
                ) {

            if (!auth(dataInputStream, dataOutputStream)) {
                // Удаляемся из сервера
                server.onClientDisconnected(this);
            } else {
                server.onNewClient(this);
                this.socket.setSoTimeout(0);
                messageListener(dataInputStream, dataOutputStream);
            }
        } catch (SocketTimeoutException e) {
            server.onClientDisconnected(this);
        } finally {
            socket.close();
        }
    }
}