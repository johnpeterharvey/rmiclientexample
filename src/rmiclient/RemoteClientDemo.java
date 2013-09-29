package rmiclient;

public class RemoteClientDemo {
	/**
	 * Instantiate an instance of the client, connect to the server
	 * and run test
	 * @param args
	 */
	public static void main(String args[]){
		RemoteClient rc = new RemoteClient("localhost");
		rc.test();
	}
}