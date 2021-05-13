package QueueControl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

public class ClientGenerator implements Runnable {
	private Scheduler scheduler;
	private ArrayList<Client> clients;
	private FileOutWritter writter;
	private Random random;
	private int timeLimit, numberOfClients, numberOfQueues, minServiceTime, maxServiceTime; 
	public float averageTime = 0;
	public static int isRunning = 1;
	public int minArrivalTime, maxArrivalTime, totalServiceTime = 0;
	
	public ClientGenerator(String input, String output) throws IOException {
		File inputFile = new File(input);
    	Scanner s = new Scanner(inputFile);
    	numberOfClients = s.nextInt();
    	numberOfQueues = s.nextInt();
    	timeLimit = s.nextInt();
    	String[] buf = s.next().toString().split(",");
    	String[] buff = s.next().toString().split(",");
    	
    	minArrivalTime = Integer.parseInt(buf[0]);
    	maxArrivalTime = Integer.parseInt(buf[1]);
    	minServiceTime = Integer.parseInt(buff[0]);
    	maxServiceTime = Integer.parseInt(buff[1]);
    	s.close();
    	
    	this.random = new Random();
    	this.scheduler = new Scheduler(numberOfQueues);
    	this.clients = generateClients(numberOfClients, minArrivalTime, maxArrivalTime, minServiceTime, maxServiceTime);
		this.writter = new FileOutWritter(this, output);	
	}
	
	public ArrayList<Client> generateClients(int numberOfClients, int minArrivalTime, int maxArrivalTime, int minServiceTime, int maxServiceTime) {
		
		ArrayList<Client> clientsList = new ArrayList<Client>();
		for(int i = 0; i < numberOfClients; i++) {
			int newServiceTime = this.random.nextInt((maxServiceTime - minServiceTime) + 1) + minServiceTime;
			Client c = new Client(i, this.random.nextInt((maxArrivalTime - minArrivalTime) + 1) + minArrivalTime, newServiceTime);
			totalServiceTime += newServiceTime;
			clientsList.add(c);			
		}
		averageTime = (float)totalServiceTime / numberOfClients;
		Collections.sort(clientsList, Client.ArrivalComparator);
		return clientsList;
	}
	
	public void run() {
		int time = 0;
		ConcreteStrategy dispatch = new ConcreteStrategy();
		while(time < this.timeLimit){	
			if(this.clients.size() != 0 || (FileOutWritter.c1 == 1) || (FileOutWritter.c1 == 2)) {
			Iterator<Client> iter = clients.iterator();
			ArrayList<Client> removableList = new ArrayList<Client>();	
			while(iter.hasNext() == true){
				Client c = iter.next();
				if(c.getArrival() <= time){
					dispatch.addClientStrategy(scheduler.getQueues(), c);
					removableList.add(c);
				}
			}
			
			this.clients.removeAll(removableList);
			try {
				writter.writeState(time);
			} catch (IOException e1) {
				System.out.println("Write error!");
			}
			time++;	
			try {
				Thread.sleep(1000); 
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			} 
			} 
			if(this.clients.size() == 0 && (FileOutWritter.c1 == 1)) { 
				try {
					writter.writeAvg();
				} catch (IOException e) {
					e.printStackTrace();
				}
				System.exit(0);
			}
		}
		try {
			writter.writeAvg();
		} catch (IOException e) {
			e.printStackTrace();
		}
		isRunning = 0;
		try {
			this.writter.fileWriter.close();
		} catch (IOException e) {
			System.out.println("Close error!");
		}
	}	
	public ArrayList<Client> getClients(){
		return this.clients;
	}
	
	public Scheduler getScheduler(){
		return this.scheduler;
	}
}