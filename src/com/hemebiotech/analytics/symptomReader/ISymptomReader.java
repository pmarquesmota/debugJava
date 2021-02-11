package com.hemebiotech.analytics.symptomReader;

import java.util.HashSet;

/**
 * Anything that will read symptom data from a source
 * The important part is, the return value from the operation, which is a list of strings,
 * 
 * The implementation does not need to order the list
 * 
 */
public interface ISymptomReader {
	
	/**
	 * Initialize the file name to read the symptoms from
	 * 
	 * @param filepath a full or partial path to file with symptom strings in it, one per line
	 * @return 
	 */
	void InitializeFile (String filepath);
	
	/**
	 * If no data is available, return an empty List
	 * 
	 * @return a raw listing of all Symptoms obtained from a data source
	 */
	HashSet<String> GetSymptoms ();
}
