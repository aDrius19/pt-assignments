package HW5.Assignment5;
/**
 * Class used for the creating the Object that has fields
 * for monitoring the data
 * @author Loga Darius
 */
public class MonitoredData 
{
	private String startTime, endTime, activity;
	
	public MonitoredData(String startTime, String endTime, String activity) 
	{
		this.startTime = startTime;
		this.endTime = endTime;
		this.activity = activity;
	}
	
	/**
	 * Method used for getting the day
	 * @return returned the day of the recorded data as a integer
	 */
	public int getDay() {
		String date = this.startTime.split(" ")[0];
		String day = date.split("-")[2];
		return Integer.parseInt(day);
	}
	
	/**
	 * Method used for computing the time period of the activities
	 * @return returned the time difference in seconds as integer type
	 */
	public int computePeriod() { 
		String date = this.startTime.split(" ")[0];
		String date1 = this.endTime.split(" ")[0];
		String time = this.startTime.split(" ")[1];
		String time1 = this.endTime.split(" ")[1];
		String hour = time.split(":")[0];
		String minute = time.split(":")[1];
		String sec = time.split(":")[2];
		String hour1 = time1.split(":")[0];
		String minute1 = time1.split(":")[1];
		String sec1 = time1.split(":")[2];
		
		int h = Integer.parseInt(hour);
		int m = Integer.parseInt(minute);
		int s = Integer.parseInt(sec);
		int h1 = Integer.parseInt(hour1);
		int m1 = Integer.parseInt(minute1);
		int s1 = Integer.parseInt(sec1);
		int computedTime = 0;
		if(date.equals(date1))
		{
			computedTime = ((h1 - h - 1) * 3600) + ((59 - m + m1) * 60) + (59 - s + s1) + 1;
		}
		else if(date.equals(date1) == false) 
		{
			computedTime = ((23 - h + h1) * 3600) + ((59 - m + m1) * 60) + (59 - s + s1) + 1;
		}
		return computedTime;
	  }
	 
	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getActivity() {
		return activity;
	}

	public void setActivity(String activity) {
		this.activity = activity;
	}
	
	public String toString() {
		return startTime + "\t\t" + endTime + "\t\t" + activity;
	}
}