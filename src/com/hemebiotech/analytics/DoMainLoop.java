package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;

public class DoMainLoop implements IMainLoop {
	private static String filepath;
	private static BufferedReader reader;
	private static HashSet<String> symptomData;
	private static HashMap<String, Integer> result = new HashMap<String, Integer>();
	
	public void InitializeFile(String filepath) {
		this.filepath = filepath;
	}

	public static HashMap<String, Integer> PutSymptom(HashMap<String, Integer> h, String s) {
		// Check if the element is present
		Integer count = h.get(s);

		if (count == null) {
			// If this is first occurrence of element
			// Insert the element
			h.put(s, 1);
		} else {
			// If elements already exists in hash map
			// Increment the count of element by 1
			h.put(s, ++count);
		}
		return h;
	}

	public static void loop() {
		String line;
		try {
			line = reader.readLine();

			while (line != null) {
				System.out.println("symptom from file: " + line);

				for (String symptom : symptomData) {
					if (line.contains(symptom)) {
						PutSymptom(result, symptom);
					}
				}

				line = reader.readLine(); // get another symptom
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public HashMap<String, Integer> MainLoop() {

		try {
			// first get input
			if(filepath == null) {
				throw new Exception("You must initialize the file with the list of symptoms.");
			}
			reader = new BufferedReader(new FileReader(filepath));

			ISymptomReader symptomReader = new ReadSymptomDataFromFile();
			symptomReader.InitializeFile("symptomData.txt");

			symptomData = symptomReader.GetSymptoms();
			loop();
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
}
