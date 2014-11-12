package base.web.pageobjects;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.web.core.Browser;
import base.web.core.Constants;
import base.web.core.TestHelper;

public class LeadPage {

	private String leadLastName;

	@FindBy(tagName = "h1")
	private WebElement header;

	@FindBy(className = "lead-status")
	private WebElement leadStatus;

	private void setLeadLastName(String leadLastName) {
		this.leadLastName = leadLastName;
	}

	public String getLeadLastName() {
		return this.leadLastName;
	}

	public LeadPage() {
		PageFactory.initElements(Browser.driver(), this);
		TestHelper.waitForVisible(leadStatus);
		
		assertPageIsLoaded();
		assertLeadPageHeader();
    }

	public LeadPage(String leadName) {
		PageFactory.initElements(Browser.driver(), this);
		TestHelper.waitForVisible(leadStatus);
		
		setLeadLastName(leadName);
		
		assertPageIsLoaded();
		assertLeadPageHeader();
    }
	
	private void assertPageIsLoaded() {
		assertTrue("This is not " + Constants.titleBaseCRM + " page!",
				Constants.titleBaseCRM.equals(Browser.getTitle()));
	}
	
	private void assertLeadPageHeader() {
		String leadHeader = Constants.strLeads.concat(" /"); 
        assertTrue("Page Header Assertion Failed!",
    			header.getText().trim().startsWith(leadHeader));
    }
	
	private String getLeadStatusText() {
		return leadStatus.getText();
	}
	
	public void assertLeadStatus(String expectedText) {
        assertEquals("Lead Status Assertion Failed! Expected: " + expectedText + ", Actual: " + getLeadStatusText() + ".",
        		expectedText, getLeadStatusText());
	}
}