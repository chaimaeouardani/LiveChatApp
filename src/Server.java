import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.*;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.io.InputStream;
import java.net.*;

public class Server extends UnicastRemoteObject implements Chat {
	
	private Users members; //people in the chat
	
	protected Server() throws RemoteException {
		super();
		this.members = new Users();
	}
	
	public void RegisterMember(String n, String uri) {
		this.members.addMember(uri, n);
		
	}
	
	
	public static void main(String[] args) {
		
		try {
			Registry registry = LocateRegistry.createRegistry(1099);
			Chat chat = new Server();
			Naming.rebind("//localhost:1099/chat1", chat);
			System.out.println("server started");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void addMessage(String name, String msg) throws RemoteException {
		HashMap<String, String> users = this.members.getmap();
		for (String username : users.keySet()){
			Remote stub;
			try {
				if (! username.equals(name)) {
					stub = Naming.lookup(users.get(username));
					ClientInterface user = (ClientInterface) stub;
					user.printNM(name + ">> " + msg);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}

}



	
	
	
	

