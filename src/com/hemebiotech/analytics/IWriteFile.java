package com.hemebiotech.analytics;

import java.util.HashMap;

public interface IWriteFile {
	void InitializeFile (String filepath);
	void WriteFile(HashMap<String, Integer> result);
}
