package HW5.Assignment5;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Class used for computing and generating the output of the tasks
 * using the stream processing and lambda expressions
 * @author Loga Darius
 */
public class ComputeTasks {
	 /**
	 * Method used for formating the seconds returned by another method
	 * into a more readable way
	 * @param seconds input the from another method
	 * @return return a string that contains the days, hours, minutes and seconds in a nicer format
	 */
	public static String getLocalTimeForm(int seconds) {
		String results = "";
		int days = seconds / (3600*24);
		seconds -= days * 3600*24;
		int hours = seconds / 3600;
		seconds -= hours * 3600;
		int minutes = seconds / 60;
		seconds -= minutes * 60;
		results += days + "days ";
		results += hours + "hours ";
		results += minutes + "minutes ";
		results += seconds + "seconds ";
		return results;
	}
	
	public static void main(String[] args) throws IOException {
        String fileName = "Activities.txt";

    	List<MonitoredData> md = new ArrayList<MonitoredData>();
        try (InputStream fis = new FileInputStream(fileName);
                InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);    		
                BufferedReader br = new BufferedReader(isr)) 
        {
            br.lines().forEach(line -> {
            	String[] buff = line.split("\t\t");
            	MonitoredData mon = new MonitoredData(buff[0], buff[1], buff[2]); 
            	md.add(mon);
				try {
					GenerateTasks.generateTextTasks(1, md.toString());
				} catch (IOException e) {
					e.printStackTrace();
				}
            });
        }
        
        List<MonitoredData> counts = md.stream()
        		.filter(distinctByKey(t -> t.getStartTime().split(" ")[0]))
        		.collect(Collectors.toList());
        String s = String.valueOf(counts.size()); //convert the integer value into a string
        GenerateTasks.generateTextTasks(2, s);

        Map<String, Long> activity = md.stream()
    		   .collect(Collectors.groupingBy(m -> m.getActivity(), Collectors.counting()));
        GenerateTasks.generateTextTasks(3, activity.toString());
        
        Map<Integer, Map<String, Long>> activities = md.stream()
    		   .collect(Collectors.groupingBy(d -> d.getDay(), Collectors.groupingBy(m -> m.getActivity(), Collectors.counting())));
        GenerateTasks.generateTextTasks(4, activities.toString());
        
        Map<String, Integer> duration = md.stream()
        		.collect(Collectors.groupingBy(a -> a.getActivity(), Collectors.summingInt(c -> c.computePeriod())));
        //used a hash table to output the seconds to a nicer form for each activity
        Map<String, String> durationStr = new Hashtable<>(); 
        duration.keySet().forEach(a -> durationStr.put(a, getLocalTimeForm(duration.get(a))));
        GenerateTasks.generateTextTasks(5, durationStr.toString());
        
        List<String> list = md.stream()
        		.filter(distinctByKey(MonitoredData::getActivity))
        		.filter(t -> 0.9 * duration.get(t.getActivity()) < 359)
        		.map(MonitoredData::getActivity)
        		.collect(Collectors.toList());
        GenerateTasks.generateTextTasks(6, list.toString());
    }
	
	public static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
	    Map<Object, Boolean> seen = new ConcurrentHashMap<>(); 
	    return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null; 
	}
}