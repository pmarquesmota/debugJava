package com.hemebiotech.analytics;

import java.util.TreeMap;

public interface IWriteFile {
	void InitializeFile (String filepath);
	void WriteFile(TreeMap<String, Integer> result);
}
