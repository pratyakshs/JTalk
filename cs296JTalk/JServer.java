package cs296JTalk;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class JServer {

	private ServerSocket serverSocket;
	private Socket server;

	public JServer(int port) throws IOException {
		this.serverSocket = new ServerSocket(port);
		serverSocket.setSoTimeout(15000);
	}

	public Socket getSocket(){
		return server;
	}
	public void acceptConnection()
	{

		try
		{
			server = serverSocket.accept();

		}catch(SocketTimeoutException s)
		{
			System.out.println("Socket timed out!");

		}catch(IOException e)
		{
			e.printStackTrace();
		}

	}

}
