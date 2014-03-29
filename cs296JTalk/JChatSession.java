package cs296JTalk;

import java.util.ArrayList;

public class JChatSession{
	public JChatSession(){
		log = new ArrayList <LogContainer>();
	}

	
	public ArrayList <LogContainer> log;

	
	public void printLog(){
			for(LogContainer temp:log)
			{
					temp.print();
			}
		}
	}

