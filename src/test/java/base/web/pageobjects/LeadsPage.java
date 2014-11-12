package base.web.pageobjects;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.CacheLookup;

import base.web.core.Browser;
import base.web.core.Constants;

public class LeadsPage {

	@FindBy(tagName = "h1")
	private WebElement header;

	@FindBy(id = "selection")
	private WebElement btnNewLead;
	
	@FindBy(className = "lead-name")
	@CacheLookup
	private List<WebElement> leads;
		
	public LeadsPage() {
		PageFactory.initElements(Browser.driver(), this);
		
		assertPageIsLoaded();
		assertLeadsPageHeader();
    }

	private void assertPageIsLoaded() {
		assertTrue("This is not " + Constants.titleLeadsPage + " page!",
				Constants.titleLeadsPage.equals(Browser.getTitle()));
	}
	
	private void assertLeadsPageHeader() {
        assertEquals("Page Header Assertion Failed! Expected: " + Constants.strLeads + ", Actual: " + header.getText().trim() + ".",
    			Constants.strLeads, header.getText().trim());
    }
	
	public NewLeadPage createNewLead() {
		btnNewLead.click();
        return new NewLeadPage();
    }

	public LeadPage selectLead(String leadName) {
		WebElement lead = getLeadToSelect(leadName);
		lead.click();
		
		return new LeadPage();
	}
	
	private WebElement getLeadToSelect(String leadName) {
		WebElement leadToSelect = null;

		for (int i = 0; i < leads.size(); i++) {
			if (leads.get(i).getText().equals(leadName)) {
				leadToSelect = leads.get(i);
				break;
			}
		}
		
		return leadToSelect;
	}
}