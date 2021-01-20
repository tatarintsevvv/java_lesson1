package info.tatarintsev;

class ServicePrivateMessage extends Message {
    public ServicePrivateMessage(Client toClient, String text) {
        super(toClient, null, text);
    }
}
