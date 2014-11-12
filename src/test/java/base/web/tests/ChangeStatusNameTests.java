package base.web.tests;

import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import base.web.components.DropDown;
import base.web.components.IFramePopup;
import base.web.components.TopBar;
import base.web.core.Browser;
import base.web.core.Constants;
import base.web.pageobjects.DashboardPage;
import base.web.pageobjects.LeadPage;
import base.web.pageobjects.LeadsCustomizePage;
import base.web.pageobjects.LeadsPage;
import base.web.pageobjects.LoginPage;
import base.web.pageobjects.NewLeadPage;
import base.web.pageobjects.SettingsPage;

public class ChangeStatusNameTests {

	private String leadName;
	private String statusChanged = Constants.statusNew;
	
	@BeforeMethod
	public void setUp() {
		Browser.open(Constants.urlLoginPage);
	}

	@Test
	public void test01()
	{
		testBase(statusChanged);
	}

	@Test
	public void test02()
	{
		testBase(statusChanged);
	}

	private void testBase(String statusOld) {
		// Log into the Web version of Base
		LoginPage loginPage = new LoginPage();
				
		DashboardPage dashboardPage = loginPage.login(Constants.email, Constants.password);
		TopBar topBar = dashboardPage.TopBar();
		
		// Create a new Lead
		IFramePopup popup = topBar.selectLeadsVideo();
		LeadsPage leadsPage = popup.skipVideo();
		NewLeadPage newLeadPage = leadsPage.createNewLead();
		LeadPage leadPage = newLeadPage.addNewLead();
		this.leadName = leadPage.getLeadLastName();
		
		// Check that its Lead status is "New"
		leadPage.assertLeadStatus(statusOld);
		
		// Go into Settings / Leads / Lead statuses and change the name of the "New" status to a different name
		DropDown userDropDown = topBar.openUserDropDown();
		userDropDown.assertLoggedUser(Constants.user);

		SettingsPage settingsPage = userDropDown.selectSettings();
		LeadsCustomizePage leadsCustomizePage = settingsPage.customizeLeads();

		leadsCustomizePage.selectLeadStatuses();
		statusChanged = leadsCustomizePage.changeStatus(statusOld);

		// Go back to the Lead to check if the name change is reflected
		leadsPage = topBar.selectLeads();
		leadPage = leadsPage.selectLead(this.leadName);
		leadPage.assertLeadStatus(statusChanged);
		
		// Logout
		userDropDown = topBar.openUserDropDown();
		loginPage = userDropDown.Logout();
	}

	@AfterMethod
	public void tearDown() {
		Browser.close();
	}
}