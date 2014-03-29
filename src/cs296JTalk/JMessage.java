package cs296JTalk;

public class JMessage implements java.io.Serializable{
	

	private static final long serialVersionUID = 1L;
	protected String message;

	public JMessage(String s) {
		if (s.length() > 140) s = s.substring(0,140);
		message=s;
	}	
	public String getMessage(){
			return message;
		}
	}
