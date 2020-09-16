package tests.beforeRegistration;

import lib.CoreTestCaseBeforeReg;
import lib.ui.NavigationUI;
import lib.ui.SettingsPageObject;
import org.junit.Test;

public class General extends CoreTestCaseBeforeReg {
    @Test
    public void testGeneralOnSettings(){
        NavigationUI navigationUI = new NavigationUI(driver);

        navigationUI.clickEnglishLangBtn();
        navigationUI.clickTopView();
        navigationUI.clickToMenu();
        navigationUI.clickToSettings();

        SettingsPageObject settingsPageObject = new SettingsPageObject(driver);

        settingsPageObject.waitForTitleOfSettings();

        navigationUI.clickToBackBtn();
        navigationUI.clickToSettings();

        settingsPageObject.clickToGeneral();
        settingsPageObject.waitForSettingsCategoryTitleByName("General");
        settingsPageObject.turnOffVibration();

        navigationUI.clickToBackBtn();

        settingsPageObject.clickToGeneral();
        settingsPageObject.turnOnVibration();

        settingsPageObject.clickToChangeTheme();
        settingsPageObject.waitForSettingsCategoryTitleByName("Change theme");
        settingsPageObject.clickToLightMode();

        navigationUI.clickTopView();
        navigationUI.clickToMenu();
        navigationUI.clickToSettings();
        settingsPageObject.clickToGeneral();
        settingsPageObject.clickToChangeLanguage();
        settingsPageObject.waitForSettingsCategoryTitleByName("Change language");

        navigationUI.clickRussianLangBtn();
        navigationUI.clickTopView();
        navigationUI.waitForRegBtnWithSubstring("Вход / Регистрация");

    }
}
