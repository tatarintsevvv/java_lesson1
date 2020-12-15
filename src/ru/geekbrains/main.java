package ru.geekbrains;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

class Main {
    public static int port = 8020;
    public static void main(String args[]) {
        try  {
            ServerSocket server = new ServerSocket(port);
            System.out.println("ECHO-сервер начал работу на порте " + port);

            while(true) {
                Socket socket = server.accept();
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            OutputStream output = socket.getOutputStream();
                            PrintWriter pw = new PrintWriter(output, true);
                            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                            String inputLine;
                            while ((inputLine = br.readLine()) != null) {
                                if (inputLine.equalsIgnoreCase("bye"))
                                    break;
                                pw.print("echo: " + inputLine);
                            }
                            br.close();
                            pw.close();
                            socket.close();
                        } catch(IOException e) {
                            e.printStackTrace();
                        }
                    }
                });

            }

        } catch(IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Работа ECHO-сервера завершена");
        }
    }


}
