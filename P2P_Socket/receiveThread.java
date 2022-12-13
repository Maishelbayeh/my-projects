package P2P_Socket;

import P2P_Socket.*;


public class receiveThread implements Runnable {
    client c;

    receiveThread(client currenntClient) {
        c = currenntClient;
    }

    public void start() {
        Thread thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        while (true) {
            c.receive();
            //c.user();
        }
    }
}
