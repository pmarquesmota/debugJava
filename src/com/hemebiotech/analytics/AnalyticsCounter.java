package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.HashSet;

public class AnalyticsCounter {
	private static HashSet<String> symptomData;
	private static HashMap<String, Integer> result = new HashMap<String, Integer>();
	
	public static void main(String args[]) throws Exception {
		// first get input
		BufferedReader reader = new BufferedReader (new FileReader("symptoms.txt"));
		String line = reader.readLine();

		ISymptomReader symptomReader = new ReadSymptomDataFromFile();
		symptomReader.InitializeFile("symptomData.txt");
		
		symptomData = symptomReader.GetSymptoms();
		
		while (line != null) {
			System.out.println("symptom from file: " + line);
			
			for(String symptom : symptomData) {
				if(line.contains(symptom)) {
		            // Check if the element is present 
		            Integer count = result.get(symptom); 
		            
		            // If this is first occurrence of element 
		            // Insert the element 
		            if (count == null) { 
		            	result.put(symptom, 1); 
		  
		            // If elements already exists in hash map 
		            // Increment the count of element by 1 
					} else { 
		            	result.put(symptom, ++count); 
		            } 
				}
			}
			
			line = reader.readLine();	// get another symptom
		}
		reader.close();
		
		// next generate output
		FileWriter writer = new FileWriter ("result.out");

		// Loop through the result hash table to write its content to the file
		for (String i : result.keySet()) {
			writer.write(i + ": " + result.get(i) + "\n");
		}

		writer.close();
	}
}
