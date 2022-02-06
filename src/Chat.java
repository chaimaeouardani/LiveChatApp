
public interface Chat extends java.rmi.Remote{

	public void addMessage(String name, String msg) throws java.rmi.RemoteException;
}
