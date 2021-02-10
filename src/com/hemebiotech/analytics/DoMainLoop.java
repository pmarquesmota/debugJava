package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;

public class DoMainLoop implements IMainLoop{
	private String filepath;

	public void InitializeFile(String filepath) {
		this.filepath = filepath;
	}

	public HashMap<String, Integer> MainLoop() {
		BufferedReader reader;
		HashSet<String> symptomData;
		HashMap<String, Integer> result = new HashMap<String, Integer>();

		try {
			// first get input
			reader = new BufferedReader(new FileReader(filepath));
			String line = reader.readLine();

			ISymptomReader symptomReader = new ReadSymptomDataFromFile();
			symptomReader.InitializeFile("symptomData.txt");

			symptomData = symptomReader.GetSymptoms();

			while (line != null) {
				System.out.println("symptom from file: " + line);

				for (String symptom : symptomData) {
					if (line.contains(symptom)) {
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

				line = reader.readLine(); // get another symptom
			}
			reader.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}
}
