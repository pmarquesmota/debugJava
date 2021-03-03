package com.hemebiotech.analytics.mainLoop;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.TreeMap;

import com.hemebiotech.analytics.symptomReader.ISymptomReader;
import com.hemebiotech.analytics.symptomReader.ReadSymptomDataFromFile;

/**
 * 
 * Implements the main loop of the program, which reads the symptom file and
 * looks for keywords
 *
 */
public class DoMainLoop implements IMainLoop {
	private  String inputFile;
	private  BufferedReader reader;
	private  HashSet<String> symptomData;
	private  TreeMap<String, Integer> result = new TreeMap<String, Integer>();

	/**
	 * Initialize the input file.
	 */
	public void initializeFile(String inputFile) {
		this.inputFile = inputFile;
	}

	/**
	 * Put a symptom into the TreeMap and update its count
	 * 
	 * @param t the TreeMap to modify
	 * @param s the String to add to the TreeMap
	 * @return the modified TreeMap
	 */
	public static TreeMap<String, Integer> putSymptom(TreeMap<String, Integer> t, String s) {
		// Check if the element is present
		Integer count = t.get(s);

		if (count == null) {
			// If this is first occurrence of element
			// Insert the element
			t.put(s, 1);
		} else {
			// If elements already exists in hash map
			// Increment the count of element by 1
			t.put(s, ++count);
		}
		return t;
	}
	
	/**
	 * The main loop. Loop over the input file and search for the keywords from symptomData
	 */
	public void loop() {
		String line;
		try {
			line = reader.readLine();

			while (line != null) {
				System.out.println("symptom from file: " + line);

				for (String symptom : symptomData) {
					if (line.contains(symptom)) {
						putSymptom(result, symptom);
					}
				}

				line = reader.readLine(); // get another symptom
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Initialize the result TreeMap with the keywords to search for in symptomData
	 */
	private void initializeResult() {
		for (String symptom : symptomData) {
			result.put(symptom, 0);
		}
	}

	/**
	 * Main method of this class.
	 * Get the keywords to search for from the symptomData file, initialize the result TreeMap and loop over the input file
	 * 
	 * @return the resulting TreeMap to be written to the output file
	 */
	public TreeMap<String, Integer> mainLoop() {
		try {
			// first get input
			if (inputFile == null) {
				throw new Exception("You must initialize the input file.");
			}
			reader = new BufferedReader(new FileReader(inputFile));

			ISymptomReader symptomReader = new ReadSymptomDataFromFile();
			symptomReader.initializeFile("symptomData.txt");

			symptomData = symptomReader.getSymptoms();
			initializeResult();
			loop();
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
