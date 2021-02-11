package com.hemebiotech.analytics.mainLoop;

import java.util.TreeMap;

public interface IMainLoop {
	void InitializeFile (String filepath); // Initialize the input file.
	TreeMap<String, Integer> MainLoop(); // Main method of the main loop
}
