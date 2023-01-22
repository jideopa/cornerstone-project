package steps.libraries;

import base.CornerstoneBase;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import pages.LoginPage;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.Properties;

@Log4j2
public class CommonSteps extends CornerstoneBase {
   private LoginPage loginPage = new LoginPage();

    public void OpenPage() {
        Properties properties = new Properties();
        try {
            FileReader reader = new FileReader("src/test/resources/config.properties");
            properties.load(reader);

        } catch (FileNotFoundException e) {
            e.fillInStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        driver.get(properties.getProperty("login-page"));
       waitForElementToBeClickable(loginPage.signButton);
    }

    public void scrollDownToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", element);
        log.info("Strolling to element " + element.getText());
    }

    public void mouseHover(WebElement webElement) {
        Actions builder = new Actions(driver);
        builder.moveToElement(webElement).build().perform();
    }

    public void waitForElementToBeClickable(WebElement element) {
        FluentWait wait = new FluentWait(driver);
        wait.withTimeout(Duration.ofMillis(30000));
        wait.pollingEvery(Duration.ofMillis(250));
        wait.ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        log.info("waiting for element to be clickable " + element.getText());

    }
}
