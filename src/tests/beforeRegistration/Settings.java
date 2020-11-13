package tests.beforeRegistration;

import lib.CoreTestCase;
import lib.ui.NavigationUI;
import lib.ui.SettingsPageObject;
import org.junit.Test;

public class Settings extends CoreTestCase {

    @Test
    public void testAboutApp() {
        NavigationUI navigationUI = new NavigationUI(driver);
        navigationUI.openSettings();

        SettingsPageObject settingsPageObject = new SettingsPageObject(driver);
        settingsPageObject.waitForTitleOfSettings();
        settingsPageObject.clickToAbout();
        settingsPageObject.clickToUserAgreement();
        navigationUI.clickToBackBtn();
        settingsPageObject.waitForSettingsCategoryTitleByName("About");
        settingsPageObject.clickToRateUs();
        navigationUI.waitPlayMarketView();
        clickToSystemBack();
        settingsPageObject.waitForSettingsCategoryTitleByName("About");
    }

    @Test
    public void testVibration() {
        NavigationUI navigationUI = new NavigationUI(driver);
        navigationUI.openSettings();

        SettingsPageObject settingsPageObject = new SettingsPageObject(driver);
        settingsPageObject.waitForTitleOfSettings();
        settingsPageObject.clickToGeneral();
        settingsPageObject.turnOffVibration();
        navigationUI.clickToBackBtn();
        settingsPageObject.clickToGeneral();
        settingsPageObject.turnOnVibration();
    }

    @Test
    public void testChangeTheme() {
        NavigationUI navigationUI = new NavigationUI(driver);
        navigationUI.openSettings();

        SettingsPageObject settingsPageObject = new SettingsPageObject(driver);
        settingsPageObject.waitForTitleOfSettings();
        settingsPageObject.clickToGeneral();
        settingsPageObject.clickToChangeTheme();
        settingsPageObject.clickToLightMode();
        navigationUI.clickToTopView();
    }

    @Test
    public void testChangeLanguage() {
        NavigationUI navigationUI = new NavigationUI(driver);
        navigationUI.openSettings();

        SettingsPageObject settingsPageObject = new SettingsPageObject(driver);
        settingsPageObject.clickToGeneral();
        settingsPageObject.clickToChangeLanguage();

        navigationUI.clickRussianLangBtn();
        navigationUI.clickToTopViewRu();
    }

}
