package base.web.core;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestHelper {

	public static final int length = 4;
	private static final int timeOutInSeconds = 5;
		
	public static void waitForVisible(WebElement webElement) {
		WebDriverWait wait = new WebDriverWait(Browser.driver(), timeOutInSeconds);
		wait.until(ExpectedConditions.visibilityOf(webElement));
	}
	
	public static String generateRandomString(){
		return RandomStringUtils.randomAlphabetic(length);
	}
}
