package QueueControl;

import java.io.FileWriter;
import java.io.IOException;

public class FileOutWritter {
	
	public ClientGenerator generator;
	public String outputFile;
	public FileWriter fileWriter;
	public static int c1 = 0;
	
	public FileOutWritter(ClientGenerator generator, String path) throws IOException{
		this.generator = generator;
		this.outputFile = path;
		this.fileWriter = new FileWriter(path);
	}

	private String waitingClientsConvert(){
		String c = new String("");
		for(Client client : generator.getClients()){
			c += client.toClientString();
		}
		return c;
	}
	
	public void writeState(int time) throws IOException{
		String s = new String("");
		int c = 0;
		if(time == 0) s += "Time " + time + "\n";
		else s += "\n" + "Time " + time + "\n";
		s += "Waiting clients: " + this.waitingClientsConvert() + "\n";
		this.fileWriter.append(s);
		System.out.print(s);
		for(QueueSim queue : generator.getScheduler().getQueues()){
			this.fileWriter.append(queue.toQueueString());
			System.out.print(queue.toQueueString());
			if(QueueSim.ok == 1) c++;
			if(c == generator.getScheduler().getQueues().size()) c1 = 1;
			else c1 = 2;
		}
		this.fileWriter.flush();
	}
	public void writeAvg() throws IOException {
		this.fileWriter.append("\nAverage waiting time is: " + generator.averageTime);
		System.out.println("\nAverage waiting time is: " + generator.averageTime);
		this.fileWriter.flush();
	}
}