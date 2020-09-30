package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class SettingsPageObject extends MainPageObject {
    public SettingsPageObject(AppiumDriver driver) {
        super(driver);
    }

    private static final String
        SETTINGS_TITLE = "//*[@text = 'Settings']",
        SETTINGS_GENERAL = "//*[@text = 'General']",
            GENERAL_VIBRATION = "//*[@text = 'Vibro-response']",
            GENERAL_CHANGE_THEME = "//*[@text = 'Change theme']",
                CHANGE_THEME_TO_SYSTEM = "//*[@text = 'System mode']",
                CHANGE_THEME_TO_DARK = "//*[@text = 'Dark mode']",
                CHANGE_THEME_TO_LIGHT = "//*[@text = 'Light mode']",
        SETTINGS_PERSONAL_INFO = "//*[@text = 'Personal info']",
                BIRTH_DATE = "//*[@resource-id = 'air.com.ssdsoftwaresolutions.clickuz:id/tvBirthDate']",
                    YEAR = "//*[@resource-id = 'air.com.ssdsoftwaresolutions.clickuz:id/yearPicker']",
                REGION = "//*[@resource-id = 'air.com.ssdsoftwaresolutions.clickuz:id/tvRegion']",
                FIRST_NAME = "//*[@resource-id = 'air.com.ssdsoftwaresolutions.clickuz:id/etFirstName']",
                SECOND_NAME = "//*[@resource-id = 'air.com.ssdsoftwaresolutions.clickuz:id/etSecondName']",
                THIRD_NAME = "//*[@resource-id = 'air.com.ssdsoftwaresolutions.clickuz:id/etPatronym']",
                PROFILE_PICTURE = "//*[@resource-id = 'air.com.ssdsoftwaresolutions.clickuz:id/ivProfilePic']",
                    CHOOSE_ACTION  = "//*[@text = 'Choose action:']",
                SAVE_BTN = "//*[@resource-id = 'air.com.ssdsoftwaresolutions.clickuz:id/btnSave']",
        SETTINGS_CHANGE_LANGUAGE = "//*[@text = 'Change language']",
        SETTINGS_ABOUT = "//*[@text = 'About']",
            ABOUT_USER_AGREEMENT = "//*[@text = 'User agreement']",
            ABOUT_RATE_US_ON_GOOGLE_PLAY = "//*[@text = 'Rate us on Google Play']",
        SETTINGS_CATEGORY_TITLE_TPL = "//*[@resource-id = 'air.com.ssdsoftwaresolutions.clickuz:id/tvTitle'][@text = '{SUBSTRING}']",
        BIRT_DATE_YEAR_TPL = "//*[@resource-id = 'air.com.ssdsoftwaresolutions.clickuz:id/yearPicker']//*[@text = '{SUBSTRING}'][@index = '2']";


    /*TEMPLATES*/
    private static String getSettingsCategoryTitleTpl(String substring){
        return SETTINGS_CATEGORY_TITLE_TPL.replace("{SUBSTRING}", substring);
    }

    private static String getBirtDateYearTpl(String substring){
        return BIRT_DATE_YEAR_TPL.replace("{SUBSTRING}", substring);
    }
    /*TEMPLATES*/

    public void clickToGeneral(){
        this.waitForElementAndClick(By.xpath(SETTINGS_GENERAL), "Can not click to general btn on settings", 5);
    }

    public void clickToPersonalInfo(){
        this.waitForElementAndClick(By.xpath(SETTINGS_PERSONAL_INFO), "Can not found personal info btn", 5);;
    }

    public void clickToBirthDate(){
        this.waitForElementAndClick(By.xpath(BIRTH_DATE), "Can not found birth date on personal info form", 5);
    }

    public void clickToRegion(){
        this.waitForElementAndClick(By.xpath(REGION), "Can not found region on personal info form", 5);
    }

    public void clickToFirstNameAndSendkeys(String name){
        this.waitForElementAndSendkeys(By.xpath(FIRST_NAME), "Can not found first name on personal info form", name, 5);
    }

    public void clickToSecondNameAndSendkeys(String secondName){
        this.waitForElementAndSendkeys(By.xpath(SECOND_NAME), "Can not found second name on personal info form", secondName, 5);
    }

    public void clickToThirdNameAndSendkeys(String thirdName){
        this.waitForElementAndSendkeys(By.xpath(THIRD_NAME), "Can not found third name on personal info form", thirdName, 5);
    }

    public void clickToProfilePic(){
        this.waitForElementAndClick(By.xpath(PROFILE_PICTURE), "Can not found profile picture btn on personal info form", 5);
    }
    public void clickToSave(){
        this.waitForElementAndClick(By.xpath(SAVE_BTN), "Can not found save btn on personal info form", 5);
    }

    public void clickToAbout(){
        this.waitForElementAndClick(By.xpath(SETTINGS_ABOUT), "Can not click to about btn", 5);
    }

    public void clickToUserAgreement(){
        this.waitForElementAndClick(By.xpath(ABOUT_USER_AGREEMENT), "Can not click to user agreement", 5);
    }

    public void clickToRateUs(){
        this.waitForElementAndClick(By.xpath(ABOUT_RATE_US_ON_GOOGLE_PLAY), "Can not click to rate us btn", 5);
    }

    public void clickToChangeTheme(){
        this.waitForElementAndClick(By.xpath(GENERAL_CHANGE_THEME), "Can not found cahnge theme btn", 5);
    }

    public void clickToSystemMode(){
        this.waitForElementAndClick(By.xpath(CHANGE_THEME_TO_SYSTEM), "Can not click to system mode", 5);
    }

    public void clickToDarkMode(){
        this.waitForElementAndClick(By.xpath(CHANGE_THEME_TO_DARK), "Can not click to dark mode", 5);
    }

    public void clickToLightMode(){
        this.waitForElementAndClick(By.xpath(CHANGE_THEME_TO_LIGHT), "Can not click to light mode", 5);
    }

    public void clickToChangeLanguage(){
        this.waitForElementAndClick(By.xpath(SETTINGS_CHANGE_LANGUAGE), "Can not click to change language", 5);
    }

    public void turnOnVibration(){
        this.waitForElementAndClick(By.xpath(GENERAL_VIBRATION), "Can not turn on vibration", 5);
    }
    public void turnOffVibration(){
        this.waitForElementAndClick(By.xpath(GENERAL_VIBRATION), "Can not turn off vibration", 5);
    }

    public void waitForTitleOfSettings(){
        this.waitForElementPresent(By.xpath(SETTINGS_TITLE), "Can not found settings title", 5);
    }

    public void waitForSettingsCategoryTitleByName(String titleName){
        String title = getSettingsCategoryTitleTpl(titleName);
        this.waitForElementPresent(By.xpath(title), "Can not found" + title + "title", 5);
    }

    public void waitTextChooseActionWhenClickToProfilePic(){
        this.waitForElementPresent(By.xpath(CHOOSE_ACTION), "Can not open actions form", 5);
    }

    public void swipeUntilFindRequiredDate(String date){
        String year = getBirtDateYearTpl(date);
        this.swipeLeftFromRightUntilFindElement(By.xpath(YEAR),By.xpath(year), "Can not found this year", 20);
    }


}
