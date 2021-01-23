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
    private String sender;
    private String receiver;
    private String text;
    private LocalDateTime where;

    public Message(String receiver, String sender, String text) {
        this.receiver = receiver;
        this.sender = sender;
        this.text = text;
        where = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return where.toString() + " " +
                (sender.isEmpty() || sender == null ? "null" : sender) +
                (receiver.isEmpty() || receiver == null ? "null" : receiver) +
                text;
    }
}


