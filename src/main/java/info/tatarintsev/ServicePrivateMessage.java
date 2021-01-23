package info.tatarintsev;

class ServicePrivateMessage extends Message {
    public ServicePrivateMessage(String receiver, String text) {
        super(receiver, null, text);
    }
}
