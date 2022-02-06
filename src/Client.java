import java.net.*;
import java.net.UnknownHostException;
import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

public class Client extends UnicastRemoteObject implements ClientInterface {
	
	private String name;
	private String uri;
	private int port;
	private static Scanner input;
	
	public Client(String n, int port) throws RemoteException, UnknownHostException{
		input = new Scanner(System.in);
		this.name = n;
		this.port = port;
		this.uri = "//" + InetAddress.getLocalHost().getHostAddress() + ":" + this.port + "/" + this.name;	
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}
	
	
	public void printNM(String m) {
		System.out.println(m);
	}


	
	
	public static void main(String[] args) {
		Client c;
		try {
			c = new Client(args[0], Integer.parseInt(args[1]));
 		
			//registery of the client
			Registry registry = LocateRegistry.createRegistry(c.getPort());
			Naming.rebind(c.getUri() , c);
			
			//getting the server stub
			Remote stub = Naming.lookup("//localhost:1099/chat1");
			Chat chat = (Chat) stub;
			chat.RegisterMember(c.getName(), c.getUri());
			System.out.println(c.getUri());
	        
	        boolean texting = true;
	        while (texting) {
	        	//System.out.println(c.getName() + " >> ");
	        	String msg = input.nextLine();
	        	if (msg != "") {
	        		chat.addMessage(args[0], msg);
	        		if (msg.toLowerCase().equals("bye")) {
	        			texting = false;
	        			System.out.println("You exited the chat.");
	        		}
	        	}
	        }		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}   
}
