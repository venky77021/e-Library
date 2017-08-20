package com.venky.files;

import java.io.File;
import java.util.Properties;

import com.venky.common.LoadProperties;

public class PDFDocuments {
	public static String[] getFileNames() {
		Properties prop = LoadProperties.getProperties();
		String[] resultFileName = null;
		File file = new File(prop.getProperty("dcoRepository"));
		String fileName = "";
		if (file.isDirectory()) {
			File[] listOfFiles = file.listFiles();
			for (File f : listOfFiles) {
				fileName = fileName + "," + f.getAbsolutePath();
			}
		}
		resultFileName = fileName.substring(1).split(",");
		return resultFileName;
	}
}
