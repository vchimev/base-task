package base.web.components;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.web.core.Browser;
import base.web.pageobjects.DashboardPage;
import base.web.pageobjects.LeadsPage;

public class TopBar {

	// Pull Left
	@FindBy(linkText = "Base CRM")
	private WebElement logoBase;

	@FindBy(id = "nav-dashboard")
	private WebElement navDashboard;

	@FindBy(id = "nav-leads")
	private WebElement navLeads;
	
	// Pull Right
	@FindBy(id = "notifications-widget")
	private WebElement btnNotifications;
	
	@FindBy(id = "user-dd")
	private WebElement btnUser;
		
	public TopBar() {
		PageFactory.initElements(Browser.driver(), this);
	}
	
	public DashboardPage selectBaseLogo() {
        logoBase.click();
        return new DashboardPage();
    }
	
	public DashboardPage selectDashboard() {
		navDashboard.click();
        return new DashboardPage();
    }
	
	public LeadsPage selectLeads() {
		navLeads.click();
        return new LeadsPage();
    }
	
	public IFramePopup selectLeadsVideo() {
		navLeads.click();
        return new IFramePopup();
    }
	
	public DropDown openUserDropDown() {
		btnUser.click();
        return new DropDown();
    }
}