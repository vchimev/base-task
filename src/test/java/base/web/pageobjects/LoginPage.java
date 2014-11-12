package base.web.pageobjects;

import static org.testng.AssertJUnit.assertTrue;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.web.core.Browser;
import base.web.core.Constants;

public class LoginPage {

	@FindBy(id = "user_email")
	private WebElement inputEmail;

	@FindBy(id = "user_password")
	private WebElement inputPassword;

	@FindBy(tagName = "button")
	private WebElement btnLogin;
	
	public LoginPage() {
		PageFactory.initElements(Browser.driver(), this);
		assertPageIsLoaded();
    }
	
	public void assertPageIsLoaded() {
		assertTrue("This is not " + Constants.titleLoginPage + " page!",
				Constants.titleLoginPage.equals(Browser.getTitle()));
	}
	
	private void typeEmail(String email) {
        inputEmail.sendKeys(email);
    }

    private void typePassword(String password) {
    	inputPassword.sendKeys(password);    
    }

    private void submitLogin() {
    	btnLogin.submit();
    }
    
    public DashboardPage login(String email, String password) {
        typeEmail(email);
        typePassword(password);
        submitLogin();
        return new DashboardPage();
    }
}