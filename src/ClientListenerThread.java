import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientListenerThread extends Thread{
	private Socket socket;
    private DataInputStream is;
	
    public ClientListenerThread(Socket socket){
    	
        this.socket=socket;
        try {
            is = new DataInputStream(socket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void run(){
        while(!socket.isClosed()){
            try {
            	System.out.println(is.readUTF());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    } 
   
}
