package com.zoopla.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {
	public static WebDriver driver;
	public static Properties prop;
	public FileInputStream file;
	
	
	
	//Loading properties file and initializing driver
	public Base() {
		try {
			prop=new Properties();	
			FileInputStream file=new FileInputStream("F:\\Java-Selenium\\SeleniumZoopla\\src\\main\\java\\com\\zoopla\\config\\config.properties");
			prop.load(file);
			}catch(IOException e) {
				e.printStackTrace();
		}
		
	}

	
	
	public static void initialization() {
		if(prop.getProperty("browser").equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", prop.getProperty("chrome_driver_path"));
			driver=new ChromeDriver();
					
		}else if(prop.getProperty("browser").equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", prop.getProperty("firefox_driver_path"));
			driver=new FirefoxDriver();
			
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Integer.parseInt(prop.getProperty("pageload_timeout")), TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(prop.getProperty("implicit_wait")), TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("base_url"));
	}

	

}


