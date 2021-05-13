package HW5.Assignment5;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

public class GenerateTasks {
	/**
	 * Method for generating the file with the correct output for the tasks
	 * @param id the number of the task
	 * @param string the output as a String to be put in the text file
	 * @throws IOException the exception if the file is not created
	 */
	public static void generateTextTasks(int id, String string) throws IOException 
	{
		String fileOut = "Task_" + id + ".txt";
		OutputStream fout = new FileOutputStream(fileOut);
	    OutputStreamWriter osw = new OutputStreamWriter(fout, StandardCharsets.UTF_8);
		osw.write(string);
	    osw.close();
	}
}