package tests.beforeRegistration;

import lib.CoreTestCaseBeforeReg;
import lib.ui.NavigationUI;
import lib.ui.SettingsPageObject;
import org.junit.Test;

public class AboutApp extends CoreTestCaseBeforeReg {

    @Test
    public void testAboutApp(){
        NavigationUI navigationUI = new NavigationUI(driver);
        navigationUI.clickEnglishLangBtn();
        navigationUI.clickTopView();
        navigationUI.clickToMenu();
        navigationUI.clickToSettings();

        SettingsPageObject settingsPageObject = new SettingsPageObject(driver);
        settingsPageObject.clickToAbout();
        settingsPageObject.waitForSettingsCategoryTitleByName("About");
        settingsPageObject.clickToUserAgreement();
        settingsPageObject.waitForSettingsCategoryTitleByName("User agreement");
        navigationUI.clickToBackBtn();
        settingsPageObject.waitForSettingsCategoryTitleByName("About");
        settingsPageObject.clickToRateUs();
        navigationUI.waitPlayMarketView();
        clickToSystemBack();
        settingsPageObject.waitForSettingsCategoryTitleByName("About");
    }
}
