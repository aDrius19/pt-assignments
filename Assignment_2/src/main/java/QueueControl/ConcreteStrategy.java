package QueueControl;

import java.util.List;
/**
 * Class that implements the Strategy interface for inserting the best queue to add the clients into
 * @author Loga Darius
 */
public class ConcreteStrategy implements Strategy 
{
	public void addClientStrategy(List<QueueSim> queues, Client c) 
	{
		QueueSim minimumQ = queues.get(0);
		int time1 = minimumQ.getWaitingTime().get();
		for(QueueSim queue : queues)
		{
			int time2 = queue.getWaitingTime().get();
			if(time1 > time2)
			{
				minimumQ = queue;
				time1 = time2;
			}
		}		
		minimumQ.addClient(c);
	}
}