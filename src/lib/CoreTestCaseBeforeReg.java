package lib;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import junit.framework.TestCase;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.time.Duration;

public class CoreTestCaseBeforeReg extends TestCase {

    protected static String
            APPIUMURL = "http://127.0.0.1:4723/wd/hub",
            PLATFORM_ANDROID_BEFORE_REG = "android_before_reg",
            PLATFORM_ANDROID = "android";
    protected AppiumDriver driver;

    @Override
    protected void setUp() throws Exception {

        super.setUp();

        DesiredCapabilities capabilities = this.getCapabilitiesByPlatformEnv();

        driver = new AndroidDriver(new URL(APPIUMURL), capabilities);

        screenRotationPortrait();

    }

    @Override
    protected void tearDown() throws Exception {
        driver.quit();

        super.tearDown();

    }

    protected void screenRotationPortrait(){
        driver.rotate(ScreenOrientation.PORTRAIT);
    }

    protected void screenRotationLandscape(){
        driver.rotate(ScreenOrientation.LANDSCAPE);
    }

    protected void runAppInBackground(int seconds){
        driver.runAppInBackground(Duration.ofMillis(seconds));
    }

    protected void clickToSystemBack(){driver.navigate().back(); }

    protected void resetApp(){driver.resetApp();}

    private DesiredCapabilities getCapabilitiesByPlatformEnv() throws Exception {

        String platform = System.getenv("PLATFORM");
        DesiredCapabilities capabilities = new DesiredCapabilities();

        if (platform.equals(PLATFORM_ANDROID)){
            capabilities.setCapability("platformName", "Android");
            capabilities.setCapability("deviceName", "AndroidDevice");
            capabilities.setCapability("platformVersion", "8.1.0");
            capabilities.setCapability("automationName", "Appium");
            capabilities.setCapability("appPackage", "air.com.ssdsoftwaresolutions.clickuz");
            capabilities.setCapability("appActivity", "uz.click.evo.ui.mainrouter.MainRouterActivity");
            capabilities.setCapability("app", "/Users/ailus/Desktop/Evolution/apks/evo.apks");
            capabilities.setCapability("fullReset", "false");
        }else if (platform.equals(PLATFORM_ANDROID_BEFORE_REG)){
            capabilities.setCapability("platformName", "Android");
            capabilities.setCapability("deviceName", "AndroidDevice");
            capabilities.setCapability("platformVersion", "8.1.0");
            capabilities.setCapability("automationName", "Appium");
            capabilities.setCapability("appPackage", "air.com.ssdsoftwaresolutions.clickuz");
            capabilities.setCapability("appActivity", "uz.click.evo.ui.mainrouter.MainRouterActivity");
            capabilities.setCapability("app", "/Users/ailus/Desktop/Evolution/apks/evo.apks");
            capabilities.setCapability("fullReset", "false");
        }else {
            throw new Exception("Cannot get run platform from env variable. Platform variable "+ platform);
        }

        return capabilities;
    }

    

}
