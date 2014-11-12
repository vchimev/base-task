package base.web.core;


//import java.util.concurrent.TimeUnit;
//import org.openqa.selenium.os.WindowsUtils;

import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.*;
import org.openqa.selenium.firefox.*;

public class Browser {

	private static WebDriver driver;
	
	public static WebDriver driver() {
		return driver;
	}

	public static void open(String url) {
		driver = new FirefoxDriver();
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(url);
	}
	
	public static void close() {
		//driver.quit();
		driver.close();
	}
	
	public static String getTitle() {
		return driver.getTitle();
	}
}