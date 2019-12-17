package com.logintest.base;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.logintest.constants.ConstantPath;
import com.logintest.util.FileOperations;
import com.logintest.util.SystemTimeDemo;

public class PredefinedMethods {
	
	static protected WebDriver driver;
	private static Properties prop;

		public void setText(String locator, String locatorType, String value) {
			getElement(locator, locatorType).sendKeys(value);
		}

		public void click(String locator, String locatorType) {
			getElement(locator, locatorType).click();
		}

		public String getText(String locator, String locatorType) {
			String text = getElement(locator, locatorType).getText();
			return text;
		}

		private WebElement getElement(String locator, String locatorType) {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			WebElement element = null;
			switch (locatorType) {
			case "xpath":
				element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
				break;
			case "id":
				element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locator)));
				break;
			}
			return element;
		}

		static public void start(String browser)
		{
			prop = FileOperations.LoadFile(ConstantPath.browserProperties);
			
			if(browser.equalsIgnoreCase("chrome"))
			{
				
				
				System.setProperty("webdriver.chrome.driver",prop.getProperty("chromelocation"));

				driver = new ChromeDriver();
				//JavascriptExecutor js = (JavascriptExecutor) driver;

				System.out.println("Browser lunch successfully");
				driver.manage().window().maximize();
				driver.manage().deleteAllCookies();
				driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				
				
				
				driver.get(prop.getProperty("url"));
				System.out.println("Successfully navigation to URL");
			}
			else
			{
				//System.setProperty("webdriver.gecko.driver","D:\\Downloads\\GeckoDriver.exe");
				System.setProperty("webdriver.gecko.driver",prop.getProperty("firefoxlocation"));

				driver = new FirefoxDriver();
				//JavascriptExecutor js = (JavascriptExecutor) driver;

				System.out.println("Browser lunch successfully");
				driver.manage().window().maximize();
				driver.manage().deleteAllCookies();
				driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				
				
				
				driver.get(prop.getProperty("url"));
				System.out.println("Successfully navigation to URL");
				
				
			}
			
		
	}

		static public void takeScreenShot(String fileName, String status) {
			TakesScreenshot screenshot = (TakesScreenshot) driver;
			File src = screenshot.getScreenshotAs(OutputType.FILE);
			String folderName = SystemTimeDemo.getDate();
			String timeStamp = SystemTimeDemo.getTimeStamp();

			try {
				FileUtils.copyFile(src,
						new File(".//" + folderName + "//" + fileName + "_" + timeStamp + "_" + status + ".png"));
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

		static public void close() {
			driver.close();
			System.out.println("driver has been closed");
		}
	}


