package lib;

import lib.ui.NavigationUI;
import lib.ui.RegistrationPageObject;
import org.openqa.selenium.remote.DesiredCapabilities;

public class CoreTestCase extends CoreTestCaseBeforeReg {

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("noReset", "true");
        RegistrationPageObject registrationPageObject = new RegistrationPageObject(driver);
        NavigationUI navigationUI = new NavigationUI(driver);
        Metoo metoo = new Metoo();


        try {
            registrationPageObject.waitForRegTitle();
        }
        catch ( Exception e)
        {
                navigationUI.clickEnglishLangBtn();
                navigationUI.clickToTopView();
                navigationUI.clickToRegistrationByName("Login / Registration");

                // ADD ONLY 9 NUMBERS this is phone number
                registrationPageObject.clickToNumberOnReg(metoo.NICKS_PHONE_NUMBER);

                navigationUI.clickToDeny();

                //ADD ONLY 5 NUMBERS this is sms code
                registrationPageObject.clickToNumberOnReg(metoo.NICKS_SMS_CODE);

                //ADD ONLY 5 NUMBERS this is pin code
                registrationPageObject.clickToNumberOnReg(metoo.NICKS_PIN_CODE);

        }
    }
}
