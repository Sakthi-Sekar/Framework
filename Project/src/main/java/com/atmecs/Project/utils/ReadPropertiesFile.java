package com.atmecs.Project.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import com.atmecs.Project.constants.ConstantPaths;



public class ReadPropertiesFile {
	FileInputStream input;
	FileInputStream locators;
	FileInputStream validate;

	public String readPropertiesFile(String elements, String path) {
		Properties prop = new Properties();

		try {
			input = new FileInputStream(ConstantPaths.CONFIG_FILE);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			locators = new FileInputStream(ConstantPaths.LOCATORS_FILE);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			prop.load(input);

		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			prop.load(locators);

		} catch (Exception e) {
			e.printStackTrace();
		}
		String data = prop.getProperty(elements);
		return data;

	}
}
