package tests.afterRegistration.settings;

import lib.CoreTestCase;
import lib.ui.NavigationUI;
import lib.ui.RegistrationPageObject;
import lib.ui.SettingsPageObject;
import org.junit.Test;

public class Security extends CoreTestCase {
    @Test
    public void testChangeClickPin(){
        NavigationUI navigationUI = new NavigationUI(driver);
        SettingsPageObject settingsPageObject = new SettingsPageObject(driver);
        RegistrationPageObject registrationPageObject = new RegistrationPageObject(driver);

        navigationUI.openSettings();
        settingsPageObject.clickToSecurity();
        settingsPageObject.clickToChangeClickPin();
        registrationPageObject.addPin();
        settingsPageObject.waitForSettingsCategoryTitleByName("Enter new CLICK-PIN");
        registrationPageObject.addPin("00000");
        settingsPageObject.waitForSettingsCategoryTitleByName("Confirm new CLICK-PIN");
        registrationPageObject.addPin("00000");

        closeAndLaunchApp();

        registrationPageObject.addPin("00000");
        navigationUI.clickToMenu();
        navigationUI.clickToSettings();
        settingsPageObject.clickToSecurity();
        settingsPageObject.clickToChangeClickPin();
        registrationPageObject.addPin("00000");
        settingsPageObject.waitForSettingsCategoryTitleByName("Enter new CLICK-PIN");
        registrationPageObject.addPin();
        settingsPageObject.waitForSettingsCategoryTitleByName("Confirm new CLICK-PIN");
        registrationPageObject.addPin();
    }
}
