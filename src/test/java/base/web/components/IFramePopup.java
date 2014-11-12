package base.web.components;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.web.core.Browser;
import base.web.pageobjects.LeadsPage;

public class IFramePopup {

	@FindBy(css = ".skip")
	private WebElement btnSkip;

	public IFramePopup() {
		PageFactory.initElements(Browser.driver(), this);
	}
	
	public LeadsPage skipVideo() {
		btnSkip.click();
		return new LeadsPage();
	}
}