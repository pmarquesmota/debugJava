package com.hemebiotech.analytics.main;

import java.util.TreeMap;

import com.hemebiotech.analytics.mainLoop.DoMainLoop;
import com.hemebiotech.analytics.mainLoop.IMainLoop;
import com.hemebiotech.analytics.write.IWriteFile;
import com.hemebiotech.analytics.write.WriteToFile;

/**
 * 
 * The main class of the programm, extracts the symptoms and write them to file
 *
 */
public class MainClass {
	public void doMainClass() {
		TreeMap<String, Integer> result = new TreeMap<String, Integer>();
		
		IMainLoop loop = new DoMainLoop();
		loop.initializeFile("symptoms.txt");
		result = loop.extractSymptoms();
		
		IWriteFile writeFile = new WriteToFile();
		writeFile.initializeFile("result.out");
		writeFile.writeFile(result);

	}
}
