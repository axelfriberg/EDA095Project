import java.io.IOException;
import java.net.Socket;

public class Client {
	private Socket socket;
    private String server, username;
    private int port;
    private ClientWriterThread swt;
    private ClientListenerThread slt;

public Client (){
	port=8080;
    server="localhost";
    username="Pong Testa";
}
public void startClient(){
    try{
        socket = new Socket(server, port);
        System.out.println("Connected to server @"+ server + ":" + port);
    } catch(Exception e){
        e.printStackTrace();
    }
    swt = new ClientWriterThread(socket, username, this);
    slt = new ClientListenerThread(socket);
    swt.start();
    slt.start();
}

public void disconnect(){
    slt.interrupt();
    swt.interrupt();
    try {
        slt.join();
        swt.join();
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    try {
        socket.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
}
}

