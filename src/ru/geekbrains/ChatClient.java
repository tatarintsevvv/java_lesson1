package ru.geekbrains;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ChatClient {
    private String server;
    private int port;
    private boolean isAuthorized;

    public void start() {
        try {
            Socket socket = new Socket(server, port);
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host: " + server);
        } catch (IOException e) {
            System.out.println("Не удалось подключиться к чату");
            e.printStackTrace();
        }
        try {
            os = new DataOutputStream(client.getOutputStream());
            is = new BufferedReader(new InputStreamReader(client.getInputStream()));
            Scanner scanner = new Scanner(System.in);
            String inputLine;

            // авторизация
            System.out.println("Введите через пробел логин и пароль");
            while((inputLine = scanner.nextLine()) != null) {
                os.writeBytes(inputLine + "\n");
                os.flush();
                if (inputLine.equalsIgnoreCase("bye"))
                    break;
                String responseLine = is.readLine();

                int countAuth = 0;
                int maxAuth = 3;
                if (responseLine != null) {
                    if(!isAuthorized) {
                        count++;
                        if(responseLine.equalsIgnoreCase("success")) {
                            System.out.println("Введите через пробел логин и пароль");
                        }
                    }
                } else {
                    System.out.println("Сервер перестал отвечать");
                }
            }
            while((inputLine = scanner.nextLine()) != null) {
                os.writeBytes(inputLine + "\n");
                os.flush();
                String responseLine = is.readLine();
                if (responseLine != null) {
                    System.out.println("Server Sent: " + responseLine);
                } else {
                    System.out.println("Server Sent: No Response");
                }
                if(inputLine.equalsIgnoreCase("bye"))
                    break;
            }

        } catch (IOException e) {

        }

    }


    public ChatClient(String server, int port) {
        this.server = server;
        this.port = port;
        isAuthorized = false;
    }

    public static void main(String[] args) {

    }
}
