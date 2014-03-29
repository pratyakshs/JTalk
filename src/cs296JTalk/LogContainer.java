package cs296JTalk;

public class LogContainer {

	String talker;
	java.sql.Timestamp time_stamp;
	String message;
	LogContainer(String a,java.sql.Timestamp b,String c){
			talker=a;
			time_stamp=b;
			message=c;
		}
	public void print(){
			System.out.print( "Time: " );
			System.out.print(time_stamp);
			System.out.println(" Sender: " + talker + " Message: " + message);
		}

}
