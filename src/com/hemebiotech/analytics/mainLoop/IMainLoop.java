package com.hemebiotech.analytics.mainLoop;

import java.util.TreeMap;

public interface IMainLoop {
	void InitializeFile (String filepath);
	TreeMap<String, Integer> MainLoop();
}
