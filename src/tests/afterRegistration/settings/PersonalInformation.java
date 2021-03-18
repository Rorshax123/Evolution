package tests.afterRegistration.settings;

import lib.CoreTestCase;
import lib.ui.NavigationUI;
import lib.ui.SettingsPageObject;
import org.junit.Test;

public class PersonalInformation extends CoreTestCase {

    @Test
    public void testBirthDate() {

        NavigationUI navigationUI = new NavigationUI(driver);
        SettingsPageObject settingsPageObject = new SettingsPageObject(driver);
        navigationUI.openSettings();
        settingsPageObject.clickToPersonalInfo();
        settingsPageObject.clickToBirthDate();
        settingsPageObject.waitForSettingsCategoryTitleByName("Date of Birth");
        settingsPageObject.swipeUntilFindRequireYear("1924");
        settingsPageObject.clickToNext();
        settingsPageObject.clickToSave();
    }

    @Test
    public void testRegion() {
        NavigationUI navigationUI = new NavigationUI(driver);
        SettingsPageObject settingsPageObject = new SettingsPageObject(driver);

        navigationUI.openSettings();
        settingsPageObject.clickToPersonalInfo();
        settingsPageObject.clickToRegion();
        settingsPageObject.waitForSettingsCategoryTitleByName("Pick your region");
        settingsPageObject.swipeUpTwoTimes();
        settingsPageObject.clickToRegionKhorezm();
        settingsPageObject.clickToSave();
    }

    @Test
    public void testFullNameUser() {

        NavigationUI navigationUI = new NavigationUI(driver);
        SettingsPageObject settingsPageObject = new SettingsPageObject(driver);
        navigationUI.openSettings();
        settingsPageObject.clickToPersonalInfo();
        settingsPageObject.clickToFirstNameAndSendkeys("Nikolay");
        settingsPageObject.clickToSecondNameAndSendkeys("Zadorojniy");
        settingsPageObject.clickToThirdNameAndSendkeys("Vladimirovich");
        settingsPageObject.clickToSave();
    }

    @Test
    public void testProfilePicture() {

        NavigationUI navigationUI = new NavigationUI(driver);
        SettingsPageObject settingsPageObject = new SettingsPageObject(driver);
        navigationUI.openSettings();
        settingsPageObject.clickToPersonalInfo();
        settingsPageObject.clickToProfilePic();
        settingsPageObject.clickToPickFromGallery();
        navigationUI.clickToDeny();
        settingsPageObject.clickToProfilePic();
        settingsPageObject.clickToTakePictureACamera();
        navigationUI.clickToDeny();
        navigationUI.clickToDeny();
        settingsPageObject.clickToProfilePic();
        settingsPageObject.clickToRemoveProfilePic();
        settingsPageObject.clickToSave();
    }
}
