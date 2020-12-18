package ru.geekbrains;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

class Server {
    List<ClientHandler> clients = new ArrayList<>();
    List<Message> messages = new ArrayList<>();

    Server() {
        try {
            ServerSocket serverSocket = new ServerSocket(8081);
            AuthService authService = new AuthService();
            // Обработчик клиентов
            while (true) {
                Socket socket = serverSocket.accept();
                new Thread(() -> {
                    new ClientHandler(authService, this, socket);
                }).start();
            }
        } catch (IOException e) {
            System.out.println("Сервер прекратил работу с ошибкой");
            e.printStackTrace();
        }
    }

    synchronized void onNewMessage(User client, String message) {
        messages.add(new Message(client, message));
        // Рассылаем сообщения всем
        // если прислано сообщение сообщение вида "/w robot1 Привет", то "Привет будет отправлено
        // только пользователю с именем robot1
        String[] arr = message.split(" ");
        String nameToHello = null;
        if(arr.length == 3 && arr[0].equalsIgnoreCase("/w") && arr[2].equalsIgnoreCase("привет")) {
            nameToHello = arr[1];
        }
        for (int i = 0; i < clients.size(); i++) {
            ClientHandler recipient = clients.get(i);
            if (!recipient.client.getLogin().equals(client.getLogin())) {
                if(nameToHello == null ||  !nameToHello.equals(recipient.client.getName()))
                    break;
                recipient.sendMessage(client, message);
            }
        }
    }

    synchronized void onNewClient(ClientHandler clientHandler) {
        clients.add(clientHandler);
        for (int i = 0; i < messages.size(); i++) {
            Message message = messages.get(i);
            clientHandler.sendMessage(message.client, message.text);
        }
        onNewMessage(clientHandler.client, "Вошел в чат");
    }

    synchronized void onClientDisconnected(ClientHandler clientHandler) {
        clients.remove(clientHandler);
        onNewMessage(clientHandler.client, "Покинул чат");
    }

    public static void main(String[] args) {
        new Server();
    }
}