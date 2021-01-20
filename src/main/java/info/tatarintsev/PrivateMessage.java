package info.tatarintsev;

class PrivateMessage extends Message {
    public PrivateMessage(Client toClient, Client fromClient, String text) {
        super(toClient, fromClient, text);
    }
}
