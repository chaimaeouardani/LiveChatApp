
public interface Chat extends java.rmi.Remote{

	public void addMessage(String name, String msg) throws java.rmi.RemoteException;
	public void RegisterMember(String name, String uri) throws java.rmi.RemoteException;
}
