package com.hemebiotech.analytics;

import java.util.TreeMap;

public class AnalyticsCounter {
	
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
