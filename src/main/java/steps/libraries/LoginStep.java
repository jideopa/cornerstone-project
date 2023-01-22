package steps.libraries;

import base.CornerstoneBase;
import pages.LoginPage;
import utils.CustomerAccount;

public class LoginStep extends CornerstoneBase {
   private CommonSteps commonSteps = new CommonSteps();
   private LoginPage loginPage = new LoginPage();

    public void completeLoginForm() {
        loginPage.emailInputField.sendKeys(CustomerAccount.EXISTING_Customer.getEmailAddress());
        loginPage.passwordInputField.sendKeys(CustomerAccount.EXISTING_Customer.getPassword());
        commonSteps.scrollDownToElement(loginPage.signButton);
        loginPage.signButton.click();
        commonSteps.waitForElementToBeClickable(loginPage.accountButton);
    }
}
