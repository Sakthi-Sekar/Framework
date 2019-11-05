package com.org.atmecs.dynamic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.testng.TestNG;
import org.testng.annotations.Test;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

public class DynamicTestNG {
	public void createXmlFile(XmlSuite mSuite)
	 {
	  FileWriter writer;
	try {
	writer = new FileWriter(new File("myTemp.xml"));
	    writer.write(mSuite.toXml());
	    writer.flush();
	    writer.close();
	System.out.println(new File("myTemp.xml").getAbsolutePath());
	 } catch (IOException e)
	{
	e.printStackTrace();
	 }
	 }

//C:\Users\sakthi.sekar\eclipse-workspace\Atmecs\config\config.properties
	public void runTestNGTestModified() throws IOException {
	FileInputStream input=new FileInputStream("C:\\Users\\sakthi.sekar\\eclipse-workspace\\Atmecs\\config\\config.properties");
	Properties property=new Properties();
	property.load(input);
	String[] browserArray=property.getProperty("browser").replaceAll("\\s+", "").split(",");
System.out.println(Arrays.toString(browserArray));
	  //Create an instance on TestNG
	   TestNG myTestNG = new TestNG();
	 
	  //Map<String,String> testngParams

	   //Create an instance of XML Suite and assign a name for it.
	    XmlSuite mySuite = new XmlSuite();
	 
	    mySuite.setName("MySuite");
	    List<XmlTest> myTests = new ArrayList<XmlTest>();
	    mySuite.setParallel(XmlSuite.ParallelMode.TESTS);
	   // mySuite.setParallel("tests");
	    System.out.println("2");
	for(int index=0;index<browserArray.length;index++) {
	Map<String, String> browser = new HashMap<String, String>();
	browser.put("browser", browserArray[index]);
	   //Create an instance of XmlTest and assign a name for it.  
	   XmlTest myTest = new XmlTest(mySuite);
	 
	   myTest.setName(browserArray[index]);


	   //Add any parameters that you want to set to the Test.
	   myTest.setParameters(browser);
	 
	   
	  // myTest.setParameters("");
	 
	   //Create a list which can contain the classes that you want to run.
	   List<XmlClass> myClasses = new ArrayList<XmlClass>();
	  // myClasses.add(new XmlClass(InsightBlogs.class));
	 //  myClasses.add(new XmlClass(SearchProductScenario.class));

	   //Assign that to the XmlTest Object created earlier.
	   myTest.setXmlClasses(myClasses);  
	   

	   //Create a list of XmlTests and add the Xmltest you created earlier to it.
	 
	   myTests.add(myTest);  
	}

	   //add the list of tests to your Suite.
	   mySuite.setTests(myTests);  

	   //Add the suite to the list of suites.
	   List<XmlSuite> mySuites = new ArrayList<XmlSuite>();
	   mySuites.add(mySuite);  
	    
	//Set the list of Suites to the testNG object you created earlier.
	   myTestNG.setXmlSuites(mySuites);
	   
	   
	   mySuite.setFileName("myTemp.xml");
	   mySuite.setThreadCount(3);  
	   myTestNG.run();
	 

	   //Create physical XML file based on the virtual XML content
	   for(XmlSuite suite : mySuites)
	   {  
	       createXmlFile(suite);
	   }  
	   System.out.println("File generated successfully.");  

	  }

	@Test
	public void set() throws IOException {

	runTestNGTestModified();

	}
}