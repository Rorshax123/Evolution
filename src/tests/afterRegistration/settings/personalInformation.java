package tests.afterRegistration.settings;

import lib.CoreTestCase;
import lib.ui.NavigationUI;
import lib.ui.SettingsPageObject;
import org.junit.Test;

public class personalInformation extends CoreTestCase {

    @Test
    public void testSetttings() throws InterruptedException {

        NavigationUI navigationUI = new NavigationUI(driver);
        SettingsPageObject settingsPageObject = new SettingsPageObject(driver);

        navigationUI.waitForMushromPresent();
        navigationUI.clickToMenu();
        navigationUI.clickToSettings();

        settingsPageObject.clickToPersonalInfo();
        settingsPageObject.waitForSettingsCategoryTitleByName("Personal Info");
        settingsPageObject.clickToBirthDate();
        settingsPageObject.waitForSettingsCategoryTitleByName("Date of Birth");
        settingsPageObject.swipeUntilFindRequiredDate("1923");

        Thread.sleep(5000);



    }
}
