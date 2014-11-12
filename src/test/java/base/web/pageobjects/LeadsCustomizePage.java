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
import base.web.core.TestHelper;

public class LeadsCustomizePage {

	@FindBy(tagName = "h2")
	private WebElement header;

	@FindBy(linkText = "Custom Fields")
	private WebElement customFields;

	@FindBy(linkText = "Lead Statuses")
	private WebElement leadStatuses;
	
	@FindBy(linkText = "Tags")
	private WebElement tags;
		
	// Main Container
	@FindBy(css = "#lead-status .control-label")
	@CacheLookup
	private List<WebElement> statuses;

	@FindBy(css = "#lead-status .edit")
	@CacheLookup
	private List<WebElement> btnsEdit;
	
	@FindBy(css = "#lead-status #name")
	private WebElement inputName;
	
	@FindBy(css = "#lead-status .save")
	private WebElement btnSave;
	
	public LeadsCustomizePage() {
		PageFactory.initElements(Browser.driver(), this);
		TestHelper.waitForVisible(header);
		
		assertPageIsLoaded();
		assertNewLeadPageHeader();
    }

	private void assertPageIsLoaded() {
		assertTrue("This is not " + Constants.titleLeadsCustomizePage + " page!",
				Constants.titleLeadsCustomizePage.equals(Browser.getTitle()));
	}
	
	private void assertNewLeadPageHeader() {
        assertEquals("Page Header Assertion Failed! Expected: " + Constants.strLeads + ", Actual: " + header.getText().trim() + ".",
        		Constants.strLeads, header.getText().trim());
	}
	
	private void editStatus(String status) {
		WebElement btnEditToSelect = null;
		
		for (int i = 0; i < statuses.size(); i++) {
			if (statuses.get(i).getText().equals(status)) {
				btnEditToSelect = btnsEdit.get(i);
				break;
			}
		}
		
		btnEditToSelect.click();
	}

	private void enterStatus(String status) {
		TestHelper.waitForVisible(inputName);
		inputName.clear();
		
		inputName.sendKeys(status);
		btnSave.click();
	}
	
	public String changeStatus(String statusBefore) {
		String statusRandom = TestHelper.generateRandomString();
		
		editStatus(statusBefore);
		enterStatus(statusRandom);
		
		return statusRandom;
	}
	
	public void selectLeadStatuses() {
		leadStatuses.click();
	}
}