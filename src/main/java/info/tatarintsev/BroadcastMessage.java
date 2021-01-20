package info.tatarintsev;

class BroadcastMessage extends Message {
    public BroadcastMessage(Client fromClient, String text) {
        super(null, fromClient, text);
    }
}
