package lib;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class Platform {
    private static final String
            APPIUM_URL = "http://127.0.0.1:4723/wd/hub",
            PLATFORM_ANDROID_BEFORE_REG = "android_before_reg",
            PLATFORM_ANDROID = "android",
            PLATFORM_IOS = "ios";
    private static Platform instance;
    private Platform(){}

    public static Platform getInstance(){
        if (instance == null) {
            instance = new Platform();
        }
        return instance;
    }

    public AppiumDriver getDriver() throws Exception{
        URL URL = new URL(APPIUM_URL);
        if (this.isAndroid() || this.isAndroidBeforeReg()){
            return new AndroidDriver(URL, this.getAndroidDesireCapabilities());
        } else if (this.isIOS()){
            return new IOSDriver(URL, this.getIOSDesiredCapabilities());
        }
        else {
            throw new Exception("Can not detect type of the driver. Platform value: " + this.getPlatformVar());
        }
    }

    public boolean isAndroid(){
        return isPlatform(PLATFORM_ANDROID);
    }

    public boolean isAndroidBeforeReg(){
        return isPlatform(PLATFORM_ANDROID_BEFORE_REG);
    }

    public boolean isIOS(){
        return isPlatform(PLATFORM_IOS);
    }

    private DesiredCapabilities getAndroidDesireCapabilities(){
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "AndroidDevice");
        capabilities.setCapability("platformVersion", "8.1.0");
        capabilities.setCapability("automationName", "Appium");
        capabilities.setCapability("appPackage", "air.com.ssdsoftwaresolutions.clickuz");
        capabilities.setCapability("appActivity", "uz.click.evo.ui.mainrouter.MainRouterActivity");
        capabilities.setCapability("app", "/Users/ailus/Desktop/Evolution/apks/evo.apks");
        if (this.isAndroid()){
            capabilities.setCapability("fullReset", "false");
        }
        return capabilities;
    }

    private DesiredCapabilities getIOSDesiredCapabilities(){
        DesiredCapabilities capabilities = new DesiredCapabilities();
        return capabilities;
    }

    private boolean isPlatform(String myPlatform){
        String platform = this.getPlatformVar();
        return myPlatform.equals(platform);
    }

    private String getPlatformVar(){
        return System.getenv("PLATFORM");
    }
}
