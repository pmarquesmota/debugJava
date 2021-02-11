package com.hemebiotech.analytics.mainLoop;

import java.util.TreeMap;

public interface IMainLoop {
	void InitializeFile (String inputFile);
	TreeMap<String, Integer> MainLoop();
}
