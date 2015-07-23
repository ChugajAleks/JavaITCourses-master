import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MainServer {

    private ServerSocket server;
    private int port = 7777;

    public MainServer(){
        try {
            server = new ServerSocket(port);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println("Starting server!");
        MainServer main = new MainServer();
        main.handleConnection();

    }

    public void handleConnection()
    {
        System.out.println("Waiting for client message");
        while (true){
            try{
                Socket socket = server.accept();
                new ConnectHandler(socket);
            } catch (IOException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        }
    }
}

class ConnectHandler implements Runnable
{
    private Socket socket;

    public ConnectHandler(Socket socket){
        this.socket = socket;
        Thread t = new Thread(this);
        t.start();
    }

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p/>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        try {
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            String strMsg = (String)ois.readObject();
            System.out.println("Message from client = " + strMsg);
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject("Meu!");
            oos.close();
            ois.close();
            socket.close();
            System.out.println("Waiting fo rclient");
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (ClassNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
}
