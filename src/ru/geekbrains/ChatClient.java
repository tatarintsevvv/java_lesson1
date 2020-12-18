package ru.geekbrains;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {
    private String server;
    private int port;
    private boolean isAuthorized;

    public void start() {
        try {
            Socket socket = new Socket(server, port);
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            new Thread(() -> {
                try {
                    while (true) {
                        String newMessage = dataInputStream.readUTF();
                        System.out.println(newMessage);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            Scanner scanner = new Scanner(System.in);
            new Thread(() -> {
                try {
                    while (true) {
                        String newMessage = scanner.nextLine();
                        dataOutputStream.writeUTF(newMessage);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public ChatClient(String server, int port) {
        this.server = server;
        this.port = port;
        isAuthorized = false;
    }

    public static void main(String[] args) {
        ChatClient chatClient = new ChatClient("localhost", 8081);
        chatClient.start();
    }
}
