package com.hemebiotech.analytics.write;

import java.util.TreeMap;

/**
 * 
 * Write the results in the TreeMap to an output file
 *
 */
public interface IWriteFile {
	void InitializeFile (String inputFile);
	void WriteFile(TreeMap<String, Integer> result);
}
