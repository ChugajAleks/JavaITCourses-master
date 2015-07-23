import java.io.ObjectInputStream;
import java.io.IOException;
import java.lang.ClassNotFoundException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.net.InetAddress;

public class MainClient {


    public static void main(String[] args) throws IOException{
        System.out.println("Starting DNSClient!");
        InetAddress host;
        Socket socket;
        ObjectOutputStream oos;
        ObjectInputStream ois;
        try{
            host = InetAddress.getLocalHost();
            System.out.print(host);
            socket = new Socket(host.getHostName(), 7777);
            oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject("Test message Igor");
            ois = new ObjectInputStream(socket.getInputStream());

            String responseMsg = (String)ois.readObject();
            System.out.println(responseMsg);
            oos.close();
            ois.close();
        } catch (UnknownHostException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

    }
}
