package ru.geekbrains;

public class Message {
    User client;
    String text;

    public Message(User client, String text) {
        this.client = client;
        this.text = text;
    }
}
