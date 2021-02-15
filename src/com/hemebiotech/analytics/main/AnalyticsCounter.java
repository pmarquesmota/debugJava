package com.hemebiotech.analytics.main;

import java.util.TreeMap;

import com.hemebiotech.analytics.mainLoop.DoMainLoop;
import com.hemebiotech.analytics.mainLoop.IMainLoop;
import com.hemebiotech.analytics.write.IWriteFile;
import com.hemebiotech.analytics.write.WriteToFile;

public class AnalyticsCounter {
	
	/**
	 * 
	 * Main method. Calls the main loop method then the method that writes the result to the output file
	 */
	public static void main(String args[]) throws Exception {
		TreeMap<String, Integer> result = new TreeMap<String, Integer>();
		
		IMainLoop loop = new DoMainLoop();
		loop.InitializeFile("symptoms.txt");
		result = loop.MainLoop();
		
		IWriteFile writeFile = new WriteToFile();
		writeFile.InitializeFile("result.out");
		writeFile.WriteFile(result);
	}
}
