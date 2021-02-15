package com.hemebiotech.analytics.write;

import java.io.FileWriter;
import java.util.TreeMap;

public class WriteToFile implements IWriteFile {
	private String outputFile;

	public void InitializeFile(String outputFile) {
		this.outputFile = outputFile;
	}

	public void WriteFile(TreeMap<String, Integer> result) {
		// Generate output
		FileWriter writer;
		try {
			if (outputFile == null) {
				throw new Exception("You must initialize the output file.");
			}
			writer = new FileWriter(outputFile);
			// Loop through the result hash table to write its content to the file
			for (String i : result.keySet()) {
				writer.write(i + ": " + result.get(i) + "\n");
			}
			writer.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
