package com.hemebiotech.analytics.mainLoop;

import java.util.TreeMap;

/**
 * 
 * Main loop class. Initialize the input file and implements the main loop
 *
 */
public interface IMainLoop {
	void InitializeFile (String inputFile);
	TreeMap<String, Integer> MainLoop();
}
