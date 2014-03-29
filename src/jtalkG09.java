import java.io.IOException;
import java.net.Socket;

import cs296JTalk.JChatComm;
import cs296JTalk.JClient;
import cs296JTalk.JPacket;
import cs296JTalk.JReadThread;
import cs296JTalk.JServer;
import cs296JTalk.JWriteThread;

public class jtalkG09 {


	public static void main(String[] args) throws IOException, ClassNotFoundException{

		Socket mySocket;
		JPacket packet;
		
		JChatComm chatComm = new JChatComm();
		
		try{	
			if (args.length == 0) {

				try{
					JServer myServer = new JServer(5123);
					myServer.acceptConnection();
					mySocket = myServer.getSocket();

					chatComm = new JChatComm();

					packet = chatComm.receiveMessage(mySocket);
					packet.printPacket();

					String x = "Sure. Let us begin.";
					packet = new JPacket(x, new java.sql.Timestamp((new java.util.Date()).getTime()), "Server");
					chatComm.sendMessage(packet, mySocket);

					JWriteThread t1 = new JWriteThread(mySocket, chatComm, packet, "Server");
					t1.start();

					JReadThread t2 = new JReadThread(mySocket, chatComm, packet);
					t2.start();

					while(t1.isAlive() && t2.isAlive());
					chatComm.getChatSession().printLog();
					
				}
				catch(java.io.EOFException e){
					System.out.println("Client disconnected.");
				}

			}
			else {

				try{
					JClient myClient = new JClient();
					myClient.callServer(args[0], 5123);
					mySocket = myClient.getSocket();


					chatComm = new JChatComm();

					String x = "Free to chat?";
					packet = new JPacket(x, new java.sql.Timestamp((new java.util.Date()).getTime()), "Client");

					chatComm.sendMessage(packet, mySocket);

					packet = chatComm.receiveMessage(mySocket);
					packet.printPacket();

					mySocket.setSoTimeout(0);


					JWriteThread t1 = new JWriteThread(mySocket, chatComm, packet, "Client");
					t1.start();

					JReadThread t2 = new JReadThread(mySocket, chatComm, packet);
					t2.start();			
					
					while(t1.isAlive() && t2.isAlive());
					chatComm.getChatSession().printLog();
					
				}
				catch(java.net.SocketTimeoutException t){
					System.out.println("Timed out.");
				}

			}
		}
	catch(Exception e){

	}
}

}

