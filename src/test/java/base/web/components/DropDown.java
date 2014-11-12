package base.web.components;

import static org.testng.AssertJUnit.assertEquals;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.web.core.Browser;
import base.web.pageobjects.LoginPage;
import base.web.pageobjects.SettingsPage;

public class DropDown {

	@FindBy(className = "user-name")
	private WebElement userName;

	@FindBy(linkText = "Settings")
	private WebElement settings;

	@FindBy(linkText = "Logout")
	private WebElement logout;

	public DropDown() {
		PageFactory.initElements(Browser.driver(), this);
	}
	
	private String getLoggedUserText() {
		return userName.getText();
	}
	
	public void assertLoggedUser(String expected) {
        assertEquals("Logged User Assertion Failed! Expected: " + expected + ", Actual: " + getLoggedUserText() + ".",
        		expected, getLoggedUserText());
	}
	
	public SettingsPage selectSettings() {
		settings.click();
		return new SettingsPage();
	}
	
	public LoginPage Logout() {
		logout.click();
		return new LoginPage();
	}
}