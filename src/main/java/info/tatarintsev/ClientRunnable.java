package info.tatarintsev;

public class ClientRunnable implements Runnable {
    ClientHandler clientHandler;

    public ClientRunnable(ClientHandler clientHandler) {
        this.clientHandler = clientHandler;
    }

    @Override
    public void run() {
        try {
            clientHandler.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
