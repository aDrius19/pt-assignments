package QueueControl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Scheduler 
{
	public ArrayList<QueueSim> queues; 
	public SelectionPolicy selectionPolicy;
	public int numberOfQueues; 
	
	public Scheduler(int nrOfQueues){
		this.queues = new ArrayList<QueueSim>();
		this.selectionPolicy = SelectionPolicy.SHORTEST_TIME;
		this.numberOfQueues = nrOfQueues;
		this.createQueues();
	}
	  private void createQueues() 
	  {
		  int i = 0;
		  while(i < numberOfQueues) {
			  QueueSim queue = new QueueSim(i + 1);
			  this.queues.add(queue); 		
			  Thread thread = new Thread(queue);
			  thread.start();
			  i++;
		  }
	  }
	
	public int getNumberOfQueues(){
		return this.numberOfQueues;
	}
	
	public List<QueueSim> getQueues(){
		return Collections.unmodifiableList(queues);//get the queue but cannot modify them
	}
}