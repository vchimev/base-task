package base.web.pageobjects;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.web.core.Browser;
import base.web.core.Constants;
import base.web.core.TestHelper;

public class NewLeadPage {

	@FindBy(tagName = "h1")
	private WebElement header;

	@FindBy(linkText = "Cancel")
	private WebElement btnCancel;

	@FindBy(css = ".save")
	private WebElement btnSave;

	@FindBy(id = "lead-last-name")
	private WebElement inputLeadLastName;

	public NewLeadPage() {
		PageFactory.initElements(Browser.driver(), this);
		
		assertPageIsLoaded();
		assertNewLeadPageHeader();
    }

	private void assertPageIsLoaded() {
		assertTrue("This is not " + Constants.titleLeadsPage + " page!",
				Constants.titleLeadsPage.equals(Browser.getTitle()));
	}
	
	private void assertNewLeadPageHeader() {
        assertEquals("Page Header Assertion Failed! Expected: " + Constants.strNewLead + ", Actual: " + header.getText().trim() + ".",
        		Constants.strNewLead, header.getText().trim());
    }
	
	private void typeLeadLastName(String leadLastName) {
        inputLeadLastName.sendKeys(leadLastName);
    }
	
	private void clickSave() {
        btnSave.click();
    }
	
	public LeadPage addNewLead() {
		String leadName = TestHelper.generateRandomString();
		
		typeLeadLastName(leadName);
		clickSave();
		
		return new LeadPage(leadName);
	}
}