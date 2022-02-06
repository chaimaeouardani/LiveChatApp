
public interface ClientInterface extends java.rmi.Remote{
	
	public String getName() throws java.rmi.RemoteException;;
	
	public String getUri() throws java.rmi.RemoteException;;

	public void setUri(String uri) throws java.rmi.RemoteException;;

	public int getPort() throws java.rmi.RemoteException;;

	public void setPort(int port) throws java.rmi.RemoteException;;
	
	
	public void printNM(String m) throws java.rmi.RemoteException; ;

}
