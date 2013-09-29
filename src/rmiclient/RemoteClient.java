package rmiclient;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import rmiserver.RemoteServerInterface;

public class RemoteClient {
	private int PORT = 10000;
	private static String BIND_NAME = "RemoteServer";
	private RemoteServerInterface remoteServer;

	/**
	 * Constructor that gets the registry and finds the remote server
	 * @param host
	 */
	public RemoteClient(String host) {
		try{
			Registry registry = LocateRegistry.getRegistry(host, PORT);
			remoteServer = (RemoteServerInterface) registry.lookup(BIND_NAME);
		}catch (Exception e) {
			System.err.println("Failed to bind to registry.");
			e.printStackTrace();
		}
	}

	/**
	 * Sends server test messages to verify functionality
	 * @throws RuntimeException
	 */
	public void test() throws RuntimeException{	
		try{
			remoteServer.sendMessage("This is the remote client – I’m going to ask you to add some numbers.");
			double answer = remoteServer.addNumbers(23, 36);
			remoteServer.sendMessage("23 + 36 equals " + answer);
		} catch(Exception e) {
			System.out.println("Error connecting with the server.");
			e.printStackTrace();
		}
	}
}