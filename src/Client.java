import java.net.MalformedURLException;
import java.rmi.*;
import java.util.Scanner;

public class Client {
	
	private static Scanner input;
	
	public Client() {
		input = new Scanner(System.in);
	}
	
	
	public static void main(String[] args) {
		Remote stub;
		try {
			stub = Naming.lookup("//localhost:1099/chat1");
			Chat chat = (Chat) stub;
	        Client c = new Client();
	        
	        boolean texting = true;
	        while (texting) {
	        	System.out.println(args[0] + " >> ");
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
