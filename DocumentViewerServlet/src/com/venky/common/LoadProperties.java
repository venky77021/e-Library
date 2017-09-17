package com.venky.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class LoadProperties {
	private static Properties prop = null;

	/**
	 * This method returns the content in the specified in the user.properties file
	 * @return
	 */
	public static Properties getProperties() {
		InputStream is = null;
		try {
			is = new FileInputStream(new File("J://e-Library/e-Library/DocumentViewerServlet/user.properties"));
			prop = new Properties();
			prop.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}
	
	/*public static void main(String[] args) {
		System.out.println(getProperties().getProperty("dcoRepository"));
	}*/
}

