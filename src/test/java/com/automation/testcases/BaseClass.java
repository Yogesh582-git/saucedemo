package com.automation.testcases;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;
	public Logger logger;
	public Properties pr;

	@BeforeClass(groups = { "master", "smoke", "sanity" })
	@Parameters({ "browser" })
	public void setup(String browser) throws IOException {
		FileReader fi = new FileReader("./data.properties");
		pr = new Properties();
		pr.load(fi);

		logger = LogManager.getLogger(this.getClass());

		switch (browser.toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;

		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
//		driver.get("https://www.saucedemo.com/");
		driver.get(pr.getProperty("url"));
	}

	@AfterClass(groups = { "master", "smoke", "sanity" })
	public void tearDown() throws InterruptedException {
		Thread.sleep(1000);
		driver.quit();
	}

	public String captureScreenShot(String tname) throws IOException {
		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File sourseFile = ts.getScreenshotAs(OutputType.FILE);

		String targetFilePath = System.getProperty("user.dir") + "\\Screenshots\\" + tname + "_" + timeStamp + ".png";
		File taretFile = new File(targetFilePath);
//		FileUtils.moveFile(sourseFile, taretFile);
		sourseFile.renameTo(taretFile);
		return targetFilePath;
	}

}
