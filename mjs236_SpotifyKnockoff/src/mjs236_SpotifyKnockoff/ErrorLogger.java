package mjs236_SpotifyKnockoff;

import java.text.*;
import java.util.*;
import java.io.*;

public class ErrorLogger {
	public static void log(String errorMessage) {
		//Save the following information to errorlog.txt
		//Date, Time, errorMessage, \n
		
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new FileWriter("errorlog.txt", true));
			DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy,HH:mm:ss,");
			Date date = new Date();
			bw.write(dateFormat.format(date));
			bw.write(errorMessage);
			bw.newLine();
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
