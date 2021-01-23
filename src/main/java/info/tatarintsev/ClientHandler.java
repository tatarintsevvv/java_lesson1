package info.tatarintsev;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;

import static info.tatarintsev.ClientApp.userClientLogger;

class ClientHandler {
    AuthService authService;
    Server server;
    Socket socket;
    Client client;

    ClientHandler(AuthService authService, Server server, Socket socket) throws SocketException {
        this.authService = authService;
        this.server = server;
        this.socket = socket;
        /*
         выставляю таймаут для сокета в 120 секунд. если пользователь авторизуется за 120
         секунд, то таймаут выставлю в 0, если нет, пользователь вылетит по исключению
         таймаута
                this.socket.setSoTimeout(120);
        */
    }

    void sendMessage(DataOutputStream dataOutputStream, Message message) {
        try {
            dataOutputStream.writeUTF("/nm " + message.toString());
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
                    userClientLogger.info("Successfull authorization, login: {}", login);
                    break;
                } else {
                    userClientLogger.info("Неправильные логин и пароль!");
                    dataOutputStream.writeUTF("Неправильные логин и пароль!");

                }
            } else {
                userClientLogger.info("Ошибка авторизации!");
                dataOutputStream.writeUTF("Ошибка авторизации!");
            }
            if (tryCount == maxTryCount) {
                userClientLogger.info("Превышен лимит попыток!");
                dataOutputStream.writeUTF("Превышен лимит попыток!");
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
                String recipient = messageWithoutCommand.substring(0, messageIndex);
                String textMessage = messageWithoutCommand.substring(messageIndex);
                dataOutputStream.writeUTF("/w ok");
                server.messages.add(new PrivateMessage(client.getLogin(), recipient, textMessage));
            } else {
                dataOutputStream.writeUTF("/b ok");
                server.messages.add(new BroadcastMessage(client.getLogin(), newMessage));
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