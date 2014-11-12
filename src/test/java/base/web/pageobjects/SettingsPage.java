package base.web.pageobjects;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.web.core.Browser;
import base.web.core.Constants;
import base.web.core.TestHelper;

public class SettingsPage {

	@FindBy(tagName = "h1")
	private WebElement header;

	@FindBy(id = "sidebar")
	private WebElement sideBar;

	@FindBy(css = "#sidebar .leads a")
	private WebElement leads;
	
	public SettingsPage() {
		PageFactory.initElements(Browser.driver(), this);
		TestHelper.waitForVisible(sideBar);
		
		assertPageIsLoaded();
		assertSettingsPageHeader();
    }

	private void assertPageIsLoaded() {
		assertTrue("This is not " + Constants.titleProfilePage + " page!",
				Constants.titleProfilePage.equals(Browser.getTitle()));
	}
	
	private void assertSettingsPageHeader() {
        assertEquals("Page Header Assertion Failed! Expected: " + Constants.strSettings + ", Actual: " + header.getText().trim() + ".",
        		Constants.strSettings, header.getText().trim());
	}
	
	public LeadsCustomizePage customizeLeads() {
		leads.click();
		return new LeadsCustomizePage();
	}
}