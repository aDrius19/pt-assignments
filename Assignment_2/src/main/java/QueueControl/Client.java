package QueueControl;

import java.util.Comparator;
import java.lang.Integer;

public class Client implements Comparable<Client>, Runnable
{
	private int id, arrival, service;
	
	public Client(int id, int arrival, int service)
	{
		this.id = id;
		this.arrival = arrival;
		this.service = service;
	}
	
	public void run() 
	{
		try {
			Thread.sleep(service);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}
	
	public int getId() {
        return this.id;  
    }
	public int getArrival() {
        return this.arrival;  
    }
	public int getService() {
        return this.service;  
    }
	public String toClientString() {
		return "(" + Integer.toString(id) + "," + Integer.toString(arrival) + "," + Integer.toString(service) + ");";
	}

	public static Comparator<Client> ArrivalComparator = new Comparator<Client>() 
	{
		public int compare(Client c1, Client c2) {
			int arrival1 = c1.getArrival();
			int arrival2 = c2.getArrival();
			return Integer.compare(arrival1, arrival2);
		}
	};

	public int compareTo(Client o) {
		// TODO Auto-generated method stub
		return 0;
	}
}