package com.hemebiotech.analytics;

import java.util.HashMap;

public class AnalyticsCounter {
	
	public static void main(String args[]) throws Exception {
		HashMap<String, Integer> result = new HashMap<String, Integer>();
		
		IMainLoop loop = new DoMainLoop();
		loop.InitializeFile("symptoms.txt");
		result = loop.MainLoop();
		
		IWriteFile writeFile = new WriteToFile();
		writeFile.InitializeFile("result.out");
		writeFile.WriteFile(result);
	}
}
