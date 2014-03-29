package cs296JTalk;

import java.io.IOException;
import java.net.Socket;

public class JReadThread extends Thread{

	String x;
	Socket socket;
	JChatComm chatComm;
	JPacket packet;
	private volatile boolean isRunning = true;
	
	public JReadThread(Socket socket, JChatComm chatComm, JPacket packet){
		this.socket = socket;
		this.chatComm = chatComm;
		this.packet = packet;
	}
	
	public void run(){
		try{
			while(isRunning){
				packet = chatComm.receiveMessage(socket);
				packet.printPacket();
				if(packet.getMessage().equals("End Chat"))
					kill();
			}
		}
		catch(Exception e){
		}
	}

	public void kill() throws IOException{
		isRunning = false;
		socket.close();
	}

}
