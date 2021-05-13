package QueueControl;

import java.util.List;

public interface Strategy {
	public void addClientStrategy(List<QueueSim> q, Client c);
}