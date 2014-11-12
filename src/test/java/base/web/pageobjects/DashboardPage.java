package base.web.pageobjects;

import static org.testng.AssertJUnit.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.web.core.Browser;
import base.web.core.Constants;
import base.web.components.TopBar;

public class DashboardPage {

	@FindBy(tagName = "h1")
	private WebElement header;
	
	public DashboardPage() {
		PageFactory.initElements(Browser.driver(), this);
		
		assertPageIsLoaded();
		assertDashboardPageHeader();
    }

	private void assertPageIsLoaded() {
		assertTrue("This is not " + Constants.titleBaseCRM + " page!",
				Constants.titleBaseCRM.equals(Browser.getTitle()));
	}
	
	private void assertDashboardPageHeader() {
		assertEquals("Page Header Assertion Failed! Expected: " + Constants.strDashboard + ", Actual: " + header.getText().trim() + ".",
				Constants.strDashboard, header.getText().trim());
    }
	
	public TopBar TopBar() {
		TopBar topBar = new TopBar();
		return topBar;
	}
}