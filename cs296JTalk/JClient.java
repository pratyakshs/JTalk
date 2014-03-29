package cs296JTalk;

import java.io.IOException;
import java.net.Socket;



public class JClient{

	//private static final long serialVersionUID = 1L;
	Socket client;
	
	public Socket getSocket(){
		return client;
	}
	public void callServer(String serverName, int port) throws IOException, ClassNotFoundException{
		
		client = new Socket(serverName, port);
		client.setSoTimeout(10000);
		
	}

}