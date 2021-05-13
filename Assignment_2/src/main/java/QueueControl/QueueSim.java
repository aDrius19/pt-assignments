package QueueControl;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class QueueSim implements Runnable{
	private int index;
	private BlockingQueue<Client> clients;
	private AtomicInteger waitingTime;
	public static int ok = 4;
	
	public QueueSim(int index){
		this.index = index;
		this.clients = new LinkedBlockingQueue<Client>();
		this.waitingTime = new AtomicInteger(0);	
	}
	
	public AtomicInteger getWaitingTime(){
		return this.waitingTime;
	}
	
    public void run() {
    	while(ClientGenerator.isRunning == 1){
			Client client = clients.peek();
			if(client != null){			
				try {
					Thread.sleep(client.getService() * 1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			this.waitingTime.addAndGet(-1 * client.getService());
			this.clients.remove();
			}
		}
    }
    
    private void addWaitTime(Client c){
		this.waitingTime.addAndGet(c.getService());
	}
    
	public void addClient(Client c){
		this.clients.add(c);
		this.addWaitTime(c);
	}
	
	public String toQueueString(){
		String output = new String("");
		output += "Queue " + Integer.toString(this.index) + ": ";
		if(this.clients.size() == 0){
			output += "closed\n";
			ok = 1;
		}
		else{
			ok = 0;
			for(Client client:this.clients){
				output += client.toClientString();
			}
			output += "\n";
		}
		return output;
	}
}