import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.*;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.io.InputStream;
import java.net.*;

public class Server extends UnicastRemoteObject implements Chat {
	
	private HashMap<String, String> messages;
	
	protected Server() throws RemoteException {
		super();
		this.messages = new HashMap<String, String>();
	}
	
	public void addMessage(String person, String msg) {
		messages.put(person, msg);

	}
	
	
	
	public static void main(String[] args) {
		
		try {
			Registry registry = LocateRegistry.createRegistry(1099);
			Chat chat = new Server();
			Naming.rebind("//localhost:1099/chat1", chat);
			System.out.println("server started");
			
			//ServerSocket server = new ServerSocket(1099);
			//Socket s = server.accept();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	

}
