package info.tatarintsev;

import java.time.LocalDateTime;

/**
 * типы сообщений:
 * служебное общее - fromClient и toClient оба null
 * служебное адресное - toClient не null
 * приватное - оба не null
 * broadcast - fromClient не null
 */
class Message {
    Client fromClient;
    Client toClient;
    String text;
    LocalDateTime where;

    public Message(Client toClient, Client fromClient, String text) {
        this.toClient = toClient;
        this.fromClient = fromClient;
        this.text = text;
        where = LocalDateTime.now();
    }
}


