package ru.geekbrains;

import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.io.*;

public class EchoClient {
    public static void main(String[] args) {
        final Socket client;
        final DataOutputStream os;
        final BufferedReader is;
        try {
            client = new Socket("localhost", 8020);
            os = new DataOutputStream(client.getOutputStream());
            is = new BufferedReader(new InputStreamReader(client.getInputStream()));
            Scanner scanner = new Scanner(System.in);
            String inputLine;
            while((inputLine = scanner.nextLine()) != null) {
                System.out.println("Thread = " + Thread.currentThread());
                System.out.println("Sending to Server: " + inputLine);
                os.writeBytes(inputLine + "\n");
                os.flush();
                // keep on reading from/to the socket till we receive the "Ok" from Server,
                // once we received that we break.
                String responseLine = is.readLine();
                if (responseLine != null) {
                    System.out.println("Server Sent: " + responseLine);
                } else {
                    System.out.println("Server Sent: No Response");
                }
                if(inputLine.equalsIgnoreCase("bye"))
                    break;
            }
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host: hostname");
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
