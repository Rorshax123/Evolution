package lib.ui.factories;

import io.appium.java_client.AppiumDriver;
import lib.Platform;
import lib.ui.LocalPaymentsPageObject;
import lib.ui.android.AndroidLocalPaymentsPageObject;

public class LocalPaymentsPageObjectFactory {
    public static LocalPaymentsPageObject get(AppiumDriver driver){
       // if (Platform.getInstance().isAndroid()){
            return new AndroidLocalPaymentsPageObject(driver);
        /*} else {
            return new IOSLocalPaymentsPageObject(driver);
        }*/
    }
}
