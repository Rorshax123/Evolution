package lib;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import junit.framework.TestCase;
import lib.ui.RegistrationPageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CoreTestCase extends TestCase {

    protected AppiumDriver driver;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        driver = Platform.getInstance().getDriver();
        screenRotationPortrait();
        this.skipRegistration();
    }

    @Override
    protected void tearDown() throws Exception {
        driver.quit();
        super.tearDown();
    }

    protected void screenRotationPortrait() {
        driver.rotate(ScreenOrientation.PORTRAIT);
    }

    protected void screenRotationLandscape() {
        driver.rotate(ScreenOrientation.LANDSCAPE);
    }

    protected void runAppInBackground(int seconds) {
        driver.runAppInBackground(Duration.ofSeconds(seconds));
    }

    protected void clickHomeAndOpenApp(int millis) throws InterruptedException {
        ((AndroidDriver)driver).pressKeyCode(AndroidKeyCode.HOME);
        Thread.sleep(millis);
        ((AndroidDriver)driver).pressKeyCode(AndroidKeyCode.KEYCODE_APP_SWITCH);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text = 'CLICK Evolution']"))).click();
    }

    protected void clickToSystemBack() {
        driver.navigate().back();
    }

    protected void resetApp() {
        driver.resetApp();
    }

    protected void closeAndLaunchApp() {
        driver.closeApp();
        driver.launchApp();
    }

    private void skipRegistration() {
        if (Platform.getInstance().isAndroid()) {
            RegistrationPageObject registrationPageObject = new RegistrationPageObject(driver);
            try {
                registrationPageObject.waitForRegTitle();
            } catch (Exception e) {
                registrationPageObject.skipRegistrationFast();
            }
        }
    }

}
