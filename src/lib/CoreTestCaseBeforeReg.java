package lib;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import junit.framework.TestCase;
import lib.ui.NavigationUI;
import lib.ui.RegistrationPageObject;
import org.eclipse.jetty.websocket.common.ConnectionState;
import org.junit.Assert;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.mobile.NetworkConnection;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class CoreTestCaseBeforeReg extends TestCase {

    protected static String AppiumURL = "http://127.0.0.1:4723/wd/hub";
    protected AppiumDriver driver;

    @Override
    protected void setUp() throws Exception {

        super.setUp();
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "AndroidDevice");
        capabilities.setCapability("platformVersion", "8.0");
        capabilities.setCapability("automationName", "appium");
        capabilities.setCapability("appPackage", "air.com.ssdsoftwaresolutions.clickuz");
        capabilities.setCapability("appActivity", "uz.click.evo.ui.mainrouter.MainRouterActivity");
        capabilities.setCapability("app", "/Users/hasan/Desktop/Evolution/apks/evo_debug.apks");
        capabilities.setCapability("skipServerInstallation", "true");

        driver = new AndroidDriver(new URL(AppiumURL), capabilities);

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
        driver.runAppInBackground(seconds);
    }

    protected void clickToSystemBack(){driver.navigate().back(); }

    protected void resetApp(){driver.resetApp();}

    

}
