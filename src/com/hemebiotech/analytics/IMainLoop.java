package com.hemebiotech.analytics;

import java.util.HashMap;

public interface IMainLoop {
	void InitializeFile (String filepath);
	HashMap<String, Integer> MainLoop();
}
