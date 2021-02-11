package com.hemebiotech.analytics.write;

import java.io.FileWriter;
import java.io.IOException;
import java.util.TreeMap;

public class WriteToFile implements IWriteFile {
	private String filepath;

	public void InitializeFile(String filepath) {
		this.filepath = filepath;
	}

	public void WriteFile(TreeMap<String, Integer> result) {
		// Generate output
		FileWriter writer;
		try {
			if (filepath == null) {
				throw new Exception("You must initialize the output file.");
			}
			writer = new FileWriter(filepath);
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
