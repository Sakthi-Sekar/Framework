package com.atmecs.Project.utils;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;

public class PageActions {
	protected static WebDriver driver;
	Actions builder = new Actions(driver);

	public static void clickOnElement(WebDriver driver, String xpath) {
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.findElement(By.xpath(xpath)).click();

	}

	public static void scrollDownToBottom(WebDriver driver) {

		JavascriptExecutor javaScriptExecutor = (JavascriptExecutor) driver;
		javaScriptExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}

	public static void ClickElement(WebDriver driver, final String xpath) {
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver).pollingEvery(1, TimeUnit.SECONDS)
				.withTimeout(30, TimeUnit.SECONDS).ignoring(ElementNotInteractableException.class);
		wait.until(new Function<WebDriver, Boolean>() {
			public Boolean apply(WebDriver driver) {
				driver.findElement(By.xpath(xpath));
				return true;
			}
		});
	}

	public static void clickElement(final String xpath) {
		FluentWait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
				.ignoring(ElementClickInterceptedException.class).pollingEvery(Duration.ofSeconds(1))
				.withTimeout(Duration.ofSeconds(30));
		fluentWait.until(new Function<WebDriver, Boolean>() {
			public Boolean apply(WebDriver driver) {
				WebElement element = driver.findElement(By.xpath(xpath));
				element.click();
				return true;
			}

		});
	}

	public static void selectDropdown(final String xpath, int timeOut, final String text) {
		FluentWait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver).pollingEvery(Duration.ofSeconds(1))
				.withTimeout(Duration.ofSeconds(30));
		fluentWait.until(new Function<WebDriver, Boolean>() {
			public Boolean apply(WebDriver driver) {
				WebElement element = driver.findElement(By.xpath(xpath));
				Select select = new Select(element);

				select.selectByVisibleText(text);
				return true;
			}

		});
	}

	public static void clickAndSendText(final String xpath, int timeOutInSeconds, final String text) {
		FluentWait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
				.ignoring(ElementClickInterceptedException.class).pollingEvery(Duration.ofSeconds(1))
				.withTimeout(Duration.ofSeconds(30));

		fluentWait.until(new Function<WebDriver, Boolean>() {
			public Boolean apply(WebDriver driver) {
				WebElement element = driver.findElement(By.xpath(xpath));
				element.sendKeys(text);
				;
				return true;
			}
		});
	}

	public static WebElement getElement(String xpath) {

		WebElement element = driver.findElement(By.xpath(xpath));
		return element;
	}

//	public static void slider() {
//		int x = 10;
//		WebElement slider = driver
//				.findElement(By.xpath("(//span[@class='ui-slider-handle ui-corner-all ui-state-default'])[1]"));
//		int width = slider.getSize().getWidth();
//		Actions move = new Actions(driver);
//		move.moveToElement(slider, ((width * x) / 10), 0).click();
//		move.build().perform();
//		System.out.println("Slider moved");
//	}

	public static void elementEnabled(WebDriver driver, final String id) {
		boolean Field = driver.findElement(By.id(id)).isEnabled();
		System.out.print(Field);
	}

	public static void validateSearch(WebDriver driver, final String id) {
		driver.findElement(By.linkText(id)).click();
	}

	public static void dropDownHandle(WebDriver driver, final String id) {

		Select oSelect = new Select(driver.findElement(By.id(id)));
		// Get the size of the Select element
		List<WebElement> elementCount = oSelect.getOptions();
		int iSize = elementCount.size();
		System.out.println(elementCount.size());

		// Setting up the loop to print all the options
		for (int i = 0; i < iSize; i++) {
			// Storing the value of the option
			String sValue = elementCount.get(i).getText();
			// Printing the stored value
			System.out.println(sValue);
		}

	}

}