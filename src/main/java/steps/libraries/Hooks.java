package steps.libraries;

import base.CornerstoneBase;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;

@Log4j2
public class Hooks extends CornerstoneBase {
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        log.info("Setup Completed");
        log.info("Browser Launch");
    }

    @After(order = 2)
    public void takeScreenShotOnFailedScenario(Scenario scenario) {
        if ((scenario.isFailed())) {
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
            log.info("Screen shot taken");
        }
    }

    @After(order = 1)
    public void tearDown() {
        log.info("Browser quit");
        driver.quit();
    }
}
