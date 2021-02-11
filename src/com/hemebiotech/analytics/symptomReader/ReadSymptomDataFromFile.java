package com.hemebiotech.analytics.symptomReader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;

/**
 * Simple brute force implementation
 *
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

	private String filepath;

	/**
	 * 
	 * @param filepath a full or partial path to file with symptom strings in it,
	 *                 one per line
	 * @return
	 */
	public void InitializeFile(String filepath) {
		this.filepath = filepath;
	}

	/**
	 * 
	 * Get the list of symptoms to find from the symptomData.txt file
	 * 
	 * @return a set of symptoms to find
	 */
	@Override
	public HashSet<String> GetSymptoms() {
		HashSet<String> result = new HashSet<String>();

		try {
			if (filepath == null) {
				throw new Exception("You must initialize the file with the list of symptoms.");
			}
			BufferedReader reader = new BufferedReader(new FileReader(filepath));
			String line = reader.readLine();

			while (line != null) {
				result.add(line);
				line = reader.readLine();
			}
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

}
