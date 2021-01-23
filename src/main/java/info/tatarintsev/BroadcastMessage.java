package info.tatarintsev;

class BroadcastMessage extends Message {
    public BroadcastMessage(String sender, String text) {
        super(null, sender, text);
    }
}
