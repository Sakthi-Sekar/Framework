package com.atmecs.Project.grid;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class Grid {
	static WebDriver driver;
	String nodeURL, baseURL;

	@Test
	public void setUp() throws MalformedURLException {
		baseURL = "http://www.atmecs.com/";
		nodeURL = " http://40.40.40.148:4444/wd/hub";
		DesiredCapabilities capability = DesiredCapabilities.firefox();
		capability.setBrowserName("firefox");
		capability.setPlatform(Platform.WIN10);
		driver = new RemoteWebDriver(new URL(nodeURL), capability);
		driver.get("http://www.atmecs.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

		/*DesiredCapabilities capabilities = new DesiredCapabilities();
		URL url1 = null;
		try {
			url1 = new URL("http://40.40.40.148:4444");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		capabilities.setBrowserName("firefox");
		capabilities.setPlatform(Platform.WIN10);
		driver = new RemoteWebDriver(url1, capabilities);
		driver.get("http://www.atmecs.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

	}*/
	}
}