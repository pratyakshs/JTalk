package cs296JTalk;

import java.io.IOException;
import java.sql.Timestamp;

public class JPacket extends JMessage implements java.io.Serializable{
	

	private static final long serialVersionUID = 1L;
	String origin;
	Timestamp time_stamp;
	public JPacket(String message, Timestamp time_stamp, String origin) throws IOException {
		super(message);
		this.time_stamp = time_stamp;
		this.origin = origin;
	}
	
	public Timestamp getTime_stamp(){
		return time_stamp;
	}
	public void printPacket(){
		System.out.print(time_stamp);
		System.out.println(" " + message);
	}
	public String getOrigin(){
		return origin;
	}
	public String getMessage(){
		return message;
	}
}

