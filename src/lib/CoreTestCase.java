package lib;

import io.appium.java_client.AppiumDriver;
import junit.framework.TestCase;
import lib.ui.NavigationUI;
import lib.ui.RegistrationPageObject;
import org.openqa.selenium.ScreenOrientation;

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
        driver.runAppInBackground(Duration.ofMillis(seconds));
    }

    protected void clickToSystemBack() {
        driver.navigate().back();
    }

    protected void resetApp() {
        driver.resetApp();
    }

    private void skipRegistration(){
        if (Platform.getInstance().isAndroid()){
            RegistrationPageObject registrationPageObject = new RegistrationPageObject(driver);
            try {
                registrationPageObject.waitForRegTitle();
            }catch (Exception e){
                registrationPageObject.skipRegistrationFast();
            }
        }
    }

}
