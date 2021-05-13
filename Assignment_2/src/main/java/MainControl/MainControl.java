package MainControl;

import java.io.IOException;
import QueueControl.ClientGenerator;

public class MainControl {

	public static void main(String[] args) throws IOException{
    	
    	ClientGenerator gen = new ClientGenerator(args[0], args[1]);
    	Thread thread = new Thread(gen);
    	thread.start();
    }
}