package com.ui.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.constants.Browser;

public abstract class BrowserUtility {

	private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

	private Logger logger = LoggerUtility.getLogger(this.getClass());
	private WebDriverWait wait;

	public WebDriver getDriver() {
		return driver.get();
	}

	public BrowserUtility(WebDriver driver) {
		super();
		this.driver.set(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30L));
	}

	public BrowserUtility(String browserName) {
		logger.info("Launching  the browser");
		if (browserName.equalsIgnoreCase("chrome")) {
			driver.set(new ChromeDriver());
			wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
		} else if (browserName.equalsIgnoreCase("edge")) {
			driver.set(new EdgeDriver());
			wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
		} else
			System.out.println("Invalid Browser Name Please select Chrome or Edge");
	}

	public BrowserUtility(Browser browserName, boolean isHeadless) {
		if (browserName == Browser.CHROME) {
			if (isHeadless) {
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--headless=old");
				options.addArguments("--window--size= 1920,1080");
				driver.set(new ChromeDriver(options));
				wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
			} else {
				driver.set(new ChromeDriver());
				wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
			}
		} else if (browserName == Browser.EDGE) {

			if (isHeadless) {
				EdgeOptions options = new EdgeOptions();
				options.addArguments("--headless=old");
				options.addArguments("--disable-gpu");
				driver.set(new EdgeDriver(options));
				wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
			} else {
				driver.set(new EdgeDriver());
				wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
			}

		} else if (browserName == Browser.SAFARI) {
			if (isHeadless) {
				SafariOptions options = new SafariOptions();

				driver.set(new SafariDriver(options));
				wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
			} else {
				driver.set(new SafariDriver());
				wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
			}

			driver.set(new SafariDriver());
			wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
		} else
			System.out.println("Invalid Browser Name Plesae select Chrome or Edge");
	}

	public void gotoWebsite(String url) {
		logger.info("launching the website");
		driver.get().get(url);

	}

	public void MaximizeWindow() {
		logger.info("maximizing the browsser window");
		driver.get().manage().window().maximize();
	}

	public void clickOn(By locator) {
		logger.info("Finding the element with the locator");
		// WebElement element = driver.get().findElement(locator);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
		element.click();
	}

	public void clickOn(WebElement element) {

		element.click();
	}

	public void clickOnCheckBox(By locator) {
		logger.info("Finding the element with the locator");
		// WebElement element = driver.get().findElement(locator);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		element.click();
	}

	public void EnterText(By locator, String textToEnter) {
		logger.info("element found and Entering  the text");
		// WebElement element = driver.get().findElement(locator);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		element.sendKeys(textToEnter);

	}

	public void EnterSpecialKey(By locator, Keys ENTER) {
		logger.info("element found and Entering  the key");
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		element.sendKeys(ENTER);

	}

	public void ClearText(By textBoxLocator) {
		logger.info("clearing the text");
		// WebElement element = driver.get().findElement(textBoxLocator);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(textBoxLocator));
		element.clear();

	}

	public String getVisibleText(By locator) {
		WebElement element = driver.get().findElement(locator);
		return element.getText();
	}

	public String getVisibleText(WebElement element) {
		logger.info("returning the visible text" + element.getText());
		return element.getText();
	}

	public List<String> getAllVisibleText(By locator) {
		List<WebElement> elementList = driver.get().findElements(locator);
		List<String> visibleTextList = new ArrayList<String>();

		for (WebElement element : elementList) {
			System.out.println(getVisibleText(element));
			visibleTextList.add(getVisibleText(element));
		}
		return visibleTextList;
	}

	public List<WebElement> getAllElements(By locator) {
		List<WebElement> elementList = driver.get().findElements(locator);

		logger.info("Returning all the elemnets by serach term");
		return elementList;
	}

	public void selectFromDropdown(By dropDownLocator, String optionToSelect) {
		logger.info("Finding element with locator" + dropDownLocator);
		WebElement element = driver.get().findElement(dropDownLocator);
		Select select = new Select(element);
		select.selectByValue(optionToSelect);

	}

	public String takescreenshot(String name) {
		TakesScreenshot takescreenshot = (TakesScreenshot) driver.get();
		File screenshotdata = takescreenshot.getScreenshotAs(OutputType.FILE);
		Date date = new Date();

		String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
		String path = ".//screenshots//" + name + "_" + timestamp + ".png";
		File Screenshotfile = new File(path);
		try {
			FileUtils.copyFile(screenshotdata, Screenshotfile);
		} catch (IOException e) {

			e.printStackTrace();
		}

		return path;
	}

	protected static boolean isDisplayed(By locator) {
		// TODO Auto-generated method stub
		return true;
	}

	public static void quit() {
		if (driver != null) {
			driver.get().quit();
		}
	}
}
