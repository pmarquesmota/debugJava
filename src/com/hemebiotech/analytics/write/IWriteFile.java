package com.hemebiotech.analytics.write;

import java.util.TreeMap;

/**
 * 
 * Write the results in the TreeMap to an output file
 *
 */
public interface IWriteFile {
	void initializeFile (String outputFile);
	void writeFile(TreeMap<String, Integer> result);
}
