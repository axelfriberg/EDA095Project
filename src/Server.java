import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 * Created by axel on 2016-05-06.
 */
public class Server {
    private DatagramSocket socket;

    public Server(){
        try {
            InetAddress address = InetAddress.getLocalHost();
            socket = new DatagramSocket(8080, address);

        } catch (SocketException | UnknownHostException e) {
            System.out.println("Could not create socket.");
            System.exit(1);
        }
    }


}
