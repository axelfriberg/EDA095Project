import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ClientWriterThread extends Thread{

	private Socket socket;
    private DataOutputStream os;
    private String username;
    private Client client;
    
    public ClientWriterThread(Socket socket, String username, Client client){
    	this.socket = socket;
    	this.username = username;
    	this.client = client;
    	try{
    		os = new DataOutputStream(socket.getOutputStream());
    	}catch(IOException e){
    		e.printStackTrace();
    		
    	}
    }
    public void run(){
    	Scanner scan = new Scanner(System.in);
    	while(!socket.isClosed()){
    		try{
    			String msg = scan.nextLine();
    			os.writeUTF(msg);
    		}catch(IOException e){
    			e.printStackTrace();
    		}
    	}
    }
}
