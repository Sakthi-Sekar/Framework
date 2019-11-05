package com.atmecs.Project.constants;

import java.io.File;

public class ConstantPaths {

public final static String USER_HOME = System.getProperty("user.dir") + File.separator;


public final static String LOCATORS_FILE = USER_HOME + "Resources" + File.separator+"locators" + File.separator + "locators.properties";

public final static String CONFIG_FILE = USER_HOME +  File.separator +"config"+File.separator+ "config.properties";

public final static String LOG4J_FILE = USER_HOME + "Resources" + File.separator + "log4j" + File.separator+ "log4j.properties";

public final static String CHROME_FILE = USER_HOME + "lib" + File.separator+ "chromedriver.exe";

public final static String FIREFOX_FILE = USER_HOME + "lib" + File.separator+ "geckodriver.exe";

public final static String IE_FILE = USER_HOME + "lib" + File.separator+ "IEDriverServer.exe";

public final static String DATA_FILE = USER_HOME + "Resources" + File.separator+"testdata" + File.separator + "data.xlsx";

}