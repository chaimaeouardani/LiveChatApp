import java.io.Serializable;
import java.util.HashMap;

public class Users implements Serializable {
	
	private HashMap<String, String> peopleinChat;
	private int n;
	
	public Users() {
		this.peopleinChat = new  HashMap<String, String>();
		this.n = 0;
	}
	
	public void addMember(String uri, String name) {
		this.peopleinChat.put(name, uri);
		this.n++;
	}
	
	public int getNumber() {
		return n;
	}
	
	public HashMap<String, String> getmap() {
		return this.peopleinChat;
	}
	
	
}
