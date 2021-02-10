package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class WriteToFile implements IWriteFile {
	private String filepath;

	public void InitializeFile(String filepath) {
		this.filepath = filepath;
	}

	public void WriteFile(HashMap<String, Integer> result) {
		// Generate output
		FileWriter writer;
		try {
			if(filepath != null) {
				writer = new FileWriter(filepath);
				// Loop through the result hash table to write its content to the file
				for (String i : result.keySet()) {
					writer.write(i + ": " + result.get(i) + "\n");
				}

				writer.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
