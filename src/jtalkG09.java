import java.io.IOException;
import java.net.Socket;

import Jcs296JTalk.JChatComm;
import Jcs296JTalk.JClient;
import Jcs296JTalk.JPacket;
import Jcs296JTalk.JServer;

public class jtalkG09 {

	static Socket mySocket;

	public static void main(String[] args) throws IOException, ClassNotFoundException{

		if (args.length == 0) {
			JServer myServer = new JServer(5050);
			myServer.acceptConnection();
			mySocket = myServer.getSocket();
			
			System.out.println("ajshdas");

//			InputStream ix = mySocket.getInputStream();
//			DataInputStream in = new DataInputStream(ix);
//			System.out.println(in.readUTF());

//			PrintWriter out =
//					new PrintWriter(mySocket.getOutputStream(), true);
//			BufferedReader in =
//					new BufferedReader(
//							new InputStreamReader(mySocket.getInputStream()));
//			BufferedReader stdIn =
//					new BufferedReader(
//							new InputStreamReader(System.in));
//			
//			out.println("server says hello");
//			System.out.println(in.readLine());

			//			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			//			String x = reader.readLine();
			//			OutputStream ox = mySocket.getOutputStream();
			//			DataOutputStream out = new DataOutputStream(ox);
			//			out.writeUTF(x);



			JChatComm chatComm = new JChatComm();
			
			chatComm.readMessage(mySocket);
			String x = "SERVER says hello";
			JPacket packet = new JPacket(x, new java.sql.Timestamp((new java.util.Date()).getTime()));
			chatComm.sendMessage(packet, mySocket);
			while(true){}
			
		}
		else {
			JClient myClient = new JClient();
			myClient.callServer(args[0], 5050);
			
			//			mySocket = new Socket(args[0], 5050);
			//			
			//			System.out.println("ajshdas");
			//			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			//			String x = reader.readLine();
			//			OutputStream ox = mySocket.getOutputStream();
			//			DataOutputStream out = new DataOutputStream(ox);
			//			out.writeUTF(x);
			//			
			//			InputStream ix = mySocket.getInputStream();
			//			DataInputStream in = new DataInputStream(ix);
			//			System.out.println(in.readUTF());


			mySocket = myClient.getSocket();
			
//			PrintWriter out =
//					new PrintWriter(mySocket.getOutputStream(), true);
//			BufferedReader in =
//					new BufferedReader(
//							new InputStreamReader(mySocket.getInputStream()));
//			out.println("client says hello");
//			System.out.println(in.readLine());
			
			JPacket packet;
			JChatComm chatComm = new JChatComm();
			

			String x = "client says hello";
			packet = new JPacket(x, new java.sql.Timestamp((new java.util.Date()).getTime()));
			
			System.out.println(1);
			chatComm.sendMessage(packet, mySocket);

			chatComm.readMessage(mySocket);


			//			
			//			while(!x.trim().equals("")){
			//				 packet = new JPacket(x, new Timestamp((new java.util.Date()).getTime()));
			//
			//				chatComm.sendMessage(packet, mySocket);
			//				chatComm.readMessage(mySocket);
			//			}
			while(true){}
		}
	//mySocket.close();
	}

}
