package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class SettingsPageObject extends MainPageObject {
    public SettingsPageObject(AppiumDriver driver) {
        super(driver);
    }

    private static final String
        SETTINGS_TITLE = "xpath://*[@text = 'Settings']",
        SETTINGS_GENERAL = "xpath://*[@text = 'General']",
            GENERAL_VIBRATION = "xpath://*[@text = 'Vibro-response']",
            GENERAL_CHANGE_THEME = "xpath://*[@text = 'Change theme']",
                CHANGE_THEME_TO_SYSTEM = "xpath://*[@text = 'System mode']",
                CHANGE_THEME_TO_DARK = "xpath://*[@text = 'Dark mode']",
                CHANGE_THEME_TO_LIGHT = "xpath://*[@text = 'Light mode']",
        SETTINGS_PERSONAL_INFO = "xpath://*[@text = 'Personal info']",
                BIRTH_DATE = "xpath://*[@resource-id = 'air.com.ssdsoftwaresolutions.clickuz:id/tvBirthDate']",
                    YEAR = "xpath://*[@resource-id = 'air.com.ssdsoftwaresolutions.clickuz:id/yearPicker']",
                REGION = "xpath://*[@resource-id = 'air.com.ssdsoftwaresolutions.clickuz:id/tvRegion']",
                FIRST_NAME = "xpath://*[@resource-id = 'air.com.ssdsoftwaresolutions.clickuz:id/etFirstName']",
                SECOND_NAME = "xpath://*[@resource-id = 'air.com.ssdsoftwaresolutions.clickuz:id/etSecondName']",
                THIRD_NAME = "xpath://*[@resource-id = 'air.com.ssdsoftwaresolutions.clickuz:id/etPatronym']",
                PROFILE_PICTURE = "xpath://*[@resource-id = 'air.com.ssdsoftwaresolutions.clickuz:id/ivProfilePic']",
                    CHOOSE_ACTION  = "xpath://*[@text = 'Choose action:']",
                SAVE_BTN = "xpath://*[@resource-id = 'air.com.ssdsoftwaresolutions.clickuz:id/btnSave']",
        SETTINGS_CHANGE_LANGUAGE = "xpath://*[@text = 'Change language']",
        SETTINGS_ABOUT = "xpath://*[@text = 'About']",
            ABOUT_USER_AGREEMENT = "xpath://*[@text = 'User agreement']",
            ABOUT_RATE_US_ON_GOOGLE_PLAY = "xpath://*[@text = 'Rate us on Google Play']",
        SETTINGS_CATEGORY_TITLE_TPL = "xpath://*[@resource-id = 'air.com.ssdsoftwaresolutions.clickuz:id/tvTitle'][@text = '{SUBSTRING}']",
        BIRT_DATE_YEAR_TPL = "xpath://*[@resource-id = 'air.com.ssdsoftwaresolutions.clickuz:id/yearPicker']//*[@text = '{SUBSTRING}'][@index = '2']";


    /*TEMPLATES*/
    private static String getSettingsCategoryTitleTpl(String substring){
        return SETTINGS_CATEGORY_TITLE_TPL.replace("{SUBSTRING}", substring);
    }

    private static String getBirtDateYearTpl(String substring){
        return BIRT_DATE_YEAR_TPL.replace("{SUBSTRING}", substring);
    }
    /*TEMPLATES*/

    public void clickToGeneral(){
        this.waitForElementAndClick(SETTINGS_GENERAL, "Can not click to general btn on settings", 5);
        this.waitForSettingsCategoryTitleByName("General");
    }

    public void clickToPersonalInfo(){
        this.waitForElementAndClick(SETTINGS_PERSONAL_INFO, "Can not found personal info btn", 5);;
    }

    public void clickToBirthDate(){
        this.waitForElementAndClick(BIRTH_DATE, "Can not found birth date on personal info form", 5);
    }

    public void clickToRegion(){
        this.waitForElementAndClick(REGION, "Can not found region on personal info form", 5);
    }

    public void clickToFirstNameAndSendkeys(String name){
        this.waitForElementAndSendkeys(FIRST_NAME, "Can not found first name on personal info form", name, 5);
    }

    public void clickToSecondNameAndSendkeys(String secondName){
        this.waitForElementAndSendkeys(SECOND_NAME, "Can not found second name on personal info form", secondName, 5);
    }

    public void clickToThirdNameAndSendkeys(String thirdName){
        this.waitForElementAndSendkeys(THIRD_NAME, "Can not found third name on personal info form", thirdName, 5);
    }

    public void clickToProfilePic(){
        this.waitForElementAndClick(PROFILE_PICTURE, "Can not found profile picture btn on personal info form", 5);
    }
    public void clickToSave(){
        this.waitForElementAndClick(SAVE_BTN, "Can not found save btn on personal info form", 5);
    }

    public void clickToAbout(){
        this.waitForElementAndClick(SETTINGS_ABOUT, "Can not click to about btn", 5);
        this.waitForSettingsCategoryTitleByName("About");
    }

    public void clickToUserAgreement(){
        this.waitForElementAndClick(ABOUT_USER_AGREEMENT, "Can not click to user agreement", 5);
        this.waitForSettingsCategoryTitleByName("User agreement");
    }

    public void clickToRateUs(){
        this.waitForElementAndClick(ABOUT_RATE_US_ON_GOOGLE_PLAY, "Can not click to rate us btn", 5);
    }

    public void clickToChangeTheme(){
        this.waitForElementAndClick(GENERAL_CHANGE_THEME, "Can not found cahnge theme btn", 5);
        this.waitForSettingsCategoryTitleByName("Change theme");
    }

    public void clickToSystemMode(){
        this.waitForElementAndClick(CHANGE_THEME_TO_SYSTEM, "Can not click to system mode", 5);
    }

    public void clickToDarkMode(){
        this.waitForElementAndClick(CHANGE_THEME_TO_DARK, "Can not click to dark mode", 5);
    }

    public void clickToLightMode(){
        this.waitForElementAndClick(CHANGE_THEME_TO_LIGHT, "Can not click to light mode", 5);
    }

    public void clickToChangeLanguage(){
        this.waitForElementAndClick(SETTINGS_CHANGE_LANGUAGE, "Can not click to change language", 5);
        this.waitForSettingsCategoryTitleByName("Change language");
    }

    public void turnOnVibration(){
        this.waitForElementAndClick(GENERAL_VIBRATION, "Can not turn on vibration", 5);
    }
    public void turnOffVibration(){
        this.waitForElementAndClick(GENERAL_VIBRATION, "Can not turn off vibration", 5);
    }

    public void waitForTitleOfSettings(){
        this.waitForElementPresent(SETTINGS_TITLE, "Can not found settings title", 5);
    }

    public void waitForSettingsCategoryTitleByName(String titleName){
        String title = getSettingsCategoryTitleTpl(titleName);
        this.waitForElementPresent(title, "Can not found" + title + "title", 5);
    }

    public void waitTextChooseActionWhenClickToProfilePic(){
        this.waitForElementPresent(CHOOSE_ACTION, "Can not open actions form", 5);
    }

    public void swipeUntilFindRequiredDate(String date){
        String year = getBirtDateYearTpl(date);
        this.swipeLeftFromRightUntilFindElement(YEAR,year, "Can not found this year", 20);
    }


}
