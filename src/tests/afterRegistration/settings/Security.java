package tests.afterRegistration.settings;

import lib.CoreTestCase;
import lib.ui.NavigationUI;
import lib.ui.RegistrationPageObject;
import lib.ui.SettingsPageObject;
import org.junit.Assert;
import org.junit.Test;

public class Security extends CoreTestCase {
    @Test
    public void testChangeClickPin() {
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

    @Test
    public void testTrustedDevices() throws InterruptedException {
        NavigationUI navigationUI = new NavigationUI(driver);
        SettingsPageObject settingsPageObject = new SettingsPageObject(driver);

        navigationUI.openSettings();
        settingsPageObject.clickToSecurity();
        settingsPageObject.clickToTrustedDevices();
        String firstDevice = settingsPageObject.getDeviceName();
        settingsPageObject.clickToKillFourthSession();
        settingsPageObject.clickToCancel();
        settingsPageObject.clickToKillFourthSession();
        settingsPageObject.clickToNextOnSessionKill();
        Assert.assertNotEquals(firstDevice, settingsPageObject.getDeviceName());
        settingsPageObject.swipeUpTwoTimes();
        settingsPageObject.clickToKillAllSessions();
        settingsPageObject.clickToCancel();
    }

    @Test
    public void testFingerPrintBtn() {
        NavigationUI navigationUI = new NavigationUI(driver);
        SettingsPageObject settingsPageObject = new SettingsPageObject(driver);

        navigationUI.openSettings();
        settingsPageObject.clickToSecurity();
        settingsPageObject.waitForFingerPrintBtnDisable();
        settingsPageObject.waitForFingerPrintBtnEnable();
    }

    @Test
    public void testLockApplication() throws InterruptedException {
        NavigationUI navigationUI = new NavigationUI(driver);
        SettingsPageObject settingsPageObject = new SettingsPageObject(driver);
        RegistrationPageObject registrationPageObject = new RegistrationPageObject(driver);

        navigationUI.openSettings();
        settingsPageObject.clickToSecurity();
        settingsPageObject.waitForLockAppDisable();
        clickHomeAndOpenApp(12000);
        settingsPageObject.waitForSettingsCategoryTitleByName("Security");
        settingsPageObject.waitForLockAppEnable();
        clickHomeAndOpenApp(12000);
        registrationPageObject.waitForgotClickPinBtn();
    }
}
