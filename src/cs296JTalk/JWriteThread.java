package cs296JTalk;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class JWriteThread extends Thread{

	String x;
	Socket socket;

	JChatComm chatComm;
	JPacket packet;
	private volatile boolean isRunning = true;
	String origin;
	
	public JWriteThread(Socket socket, JChatComm chatComm, JPacket packet, String origin){
		this.socket = socket;
		this.chatComm = chatComm;
		this.packet = packet;
		this.origin = origin;
		
	}
	
	public void run(){
		try{
			while(isRunning){
				BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
				x = stdIn.readLine();
				if(x.equals("End Chat")){
					kill();
					socket.close();
				}
				packet = new JPacket(x, new java.sql.Timestamp((new java.util.Date()).getTime()), origin);
				chatComm.sendMessage(packet, socket);
			}
		}
		catch(Exception e){
		}
	}
	
	public void kill(){
		isRunning = false;
	}

}
