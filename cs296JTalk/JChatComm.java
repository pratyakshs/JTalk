package cs296JTalk;

import java.io.*;
import java.net.*;

public class JChatComm{
	
	JChatSession chatSession;

	public JChatComm(){
		chatSession = new JChatSession();
	}
	
	public void sendMessage(JPacket packet, Socket clientSocket) throws IOException, ClassNotFoundException{
		
		OutputStream outToServer = clientSocket.getOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(outToServer);
		oos.writeObject(packet);

		logMessage(packet);
	}
	public JPacket receiveMessage(Socket clientSocket) throws IOException, ClassNotFoundException{
		InputStream inFromServer = clientSocket.getInputStream();
		ObjectInputStream ois = new ObjectInputStream(inFromServer);
		
		JPacket packet = (JPacket)ois.readObject();
		logMessage(packet);
		
		return packet;
	}
	
	public void logMessage(JPacket packet){
		chatSession.log.add(new LogContainer(packet.getOrigin(), packet.getTime_stamp(), packet.getMessage()));
	}
	
	public JChatSession getChatSession(){
		return chatSession;
	}
}