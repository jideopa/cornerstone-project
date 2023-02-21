package steps.libraries;

import base.CornerstoneBase;
import pages.LoginPage;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class LoginStep extends CornerstoneBase {
   private CommonSteps commonSteps = new CommonSteps();
   private LoginPage loginPage = new LoginPage();

    public void completeLoginForm() {
        Properties properties = new Properties();
        try {
            FileReader fileReader = new FileReader("src/test/resources/config.properties");

            properties.load(fileReader);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        loginPage.emailInputField.sendKeys(properties.getProperty("email"));
        loginPage.passwordInputField.sendKeys(properties.getProperty("password"));
        commonSteps.scrollDownToElement(loginPage.signButton);
        loginPage.signButton.click();
        commonSteps.waitForElementToBeClickable(loginPage.accountButton);
    }
}
