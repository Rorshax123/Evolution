package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

public class SettingsPageObject extends MainPageObject {
    private static final String
            SETTINGS_TITLE = "xpath://*[@text = 'Settings']",
            SETTINGS_GENERAL = "xpath://*[@text = 'General']",
            GENERAL_VIBRATION = "xpath://*[@text = 'Vibro-response']",
            GENERAL_CHANGE_THEME = "xpath://*[@text = 'Change theme']",
            CHANGE_THEME_TO_SYSTEM = "id:air.com.ssdsoftwaresolutions.clickuz:id/llSystem",
            CHANGE_THEME_TO_DARK = "id:air.com.ssdsoftwaresolutions.clickuz:id/llNight",
            CHANGE_THEME_TO_LIGHT = "id:air.com.ssdsoftwaresolutions.clickuz:id/llLight",
            SETTINGS_PERSONAL_INFO = "xpath://*[@text = 'Personal info']",
            BIRTH_DATE = "id:air.com.ssdsoftwaresolutions.clickuz:id/tvBirthDate",
            NEXT = "id:air.com.ssdsoftwaresolutions.clickuz:id/btnNext",
            YEAR = "xpath://*[@resource-id = 'air.com.ssdsoftwaresolutions.clickuz:id/yearPicker']/*[@class = 'androidx.recyclerview.widget.RecyclerView']",
            REGION = "id:air.com.ssdsoftwaresolutions.clickuz:id/tvRegion",
            REGION_KHOREZM = "xpath://*[@text = 'Khorezm']",
            FIRST_NAME = "id:air.com.ssdsoftwaresolutions.clickuz:id/etFirstName",
            SECOND_NAME = "id:air.com.ssdsoftwaresolutions.clickuz:id/etSecondName",
            THIRD_NAME = "id:air.com.ssdsoftwaresolutions.clickuz:id/etPatronym",
            PROFILE_PICTURE = "id:air.com.ssdsoftwaresolutions.clickuz:id/ivProfilePic",
            CHOOSE_ACTION = "xpath://*[@text = 'Choose action:']",
            PICK_FROM_GALLERY = "xpath://*[@text = 'Pick from Gallery']",
            TAKE_A_PICTURE = "xpath://*[@text = 'Take a picture Camera']",
            REMOVE_PROFILE_PIC = "xpath://*[@text = 'Remove profile picture']",
            SAVE_BTN = "id:air.com.ssdsoftwaresolutions.clickuz:id/btnSave",
            SETTINGS_CHANGE_LANGUAGE = "xpath://*[@text = 'Change language']",
            SETTINGS_ABOUT = "xpath://*[@text = 'About']",
            ABOUT_USER_AGREEMENT = "xpath://*[@text = 'User agreement']",
            ABOUT_RATE_US_ON_GOOGLE_PLAY = "xpath://*[@text = 'Rate us on Google Play']",
            SETTINGS_SECURITY = "id:air.com.ssdsoftwaresolutions.clickuz:id/llSecurity",
            CHANGE_CLICK_PIN = "id:air.com.ssdsoftwaresolutions.clickuz:id/llChangePin",
            TRUSTED_DEVICES = "id:air.com.ssdsoftwaresolutions.clickuz:id/llDevices",
            FOURTH_INDEX_SESSION_TIME = "xpath://*[@class = 'android.widget.LinearLayout'][@index = '3']//*[@resource-id = 'air.com.ssdsoftwaresolutions.clickuz:id/tvLoginTime']",
            FOURTH_INDEX_SESSIONS_X_BTN = "xpath://*[@class = 'android.widget.LinearLayout'][@index = '3']",
            KILL_ALL_SESIONS = "id:air.com.ssdsoftwaresolutions.clickuz:id/tvTerminateDevices",
            CANCEL_BTN = "id:air.com.ssdsoftwaresolutions.clickuz:id/btnCancel",
            NEXT_BTN = "id:air.com.ssdsoftwaresolutions.clickuz:id/btnSuccess",
            FINGER_PRINT_BTN = "id:air.com.ssdsoftwaresolutions.clickuz:id/swUseFingerprint",
            LOCK_APP_BTN = "id:air.com.ssdsoftwaresolutions.clickuz:id/swAppLock",
            TECHNICAL_SUPPORT = "id:air.com.ssdsoftwaresolutions.clickuz:id/llSupport",
            TS_REGISTRATION = "xpath://*[@text = 'Registration']",
            TS_PAYMENT = "xpath://*[@text = 'Payment']",
            TS_BALANCE = "xpath://*[@text = 'Balance']",
            TS_OTHER = "xpath://*[@text = 'Other']",
    
            SETTINGS_CATEGORY_TITLE_TPL = "xpath://*[@resource-id = 'air.com.ssdsoftwaresolutions.clickuz:id/tvTitle'][@text = '{SUBSTRING}']",
            BIRT_DATE_YEAR_TPL = "xpath://*[@resource-id = 'air.com.ssdsoftwaresolutions.clickuz:id/yearPicker']//*[@text = '{SUBSTRING}']";

    public SettingsPageObject(AppiumDriver driver) {
        super(driver);
    }

    /*TEMPLATES*/
    private static String getSettingsCategoryTitleTpl(String substring) {
        return SETTINGS_CATEGORY_TITLE_TPL.replace("{SUBSTRING}", substring);
    }

    private static String getBirtDateYearTpl(String substring) {
        return BIRT_DATE_YEAR_TPL.replace("{SUBSTRING}", substring);
    }
    /*TEMPLATES*/

    public void clickToGeneral() {
        this.waitForElementAndClick(SETTINGS_GENERAL, "Can not click to general btn on settings", 5);
        this.waitForSettingsCategoryTitleByName("General");
    }

    public void clickToPersonalInfo() {
        this.waitForElementAndClick(SETTINGS_PERSONAL_INFO, "Can not found personal info btn", 5);
        this.waitForSettingsCategoryTitleByName("Personal Info");
    }

    public void clickToBirthDate() {
        this.waitForElementAndClick(BIRTH_DATE, "Can not found birth date on personal info form", 5);
        this.waitForSettingsCategoryTitleByName("Date of Birth");
    }

    public void clickToRegion() {
        this.waitForElementAndClick(REGION, "Can not found region on personal info form", 5);
    }

    public void clickToFirstNameAndSendkeys(String name) {
        this.waitForElementAndClear(FIRST_NAME, "Can not found personal info form", 5);
        this.waitForElementAndSendkeys(FIRST_NAME, "Can not found first name on personal info form", name, 5);
    }

    public void clickToSecondNameAndSendkeys(String secondName) {
        this.waitForElementAndClear(SECOND_NAME, "Can not found second name field and clear it", 5);
        this.waitForElementAndSendkeys(SECOND_NAME, "Can not found second name on personal info form", secondName, 5);
    }

    public void clickToThirdNameAndSendkeys(String thirdName) {
        this.waitForElementAndClear(THIRD_NAME, "Can not found third name and clear this field", 5);
        this.waitForElementAndSendkeys(THIRD_NAME, "Can not found third name on personal info form", thirdName, 5);
    }

    public void clickToProfilePic() {
        this.waitForElementAndClick(PROFILE_PICTURE, "Can not found profile picture btn on personal info form", 5);
        this.waitForElementPresent(CHOOSE_ACTION, "The alert choose action cant found", 5);
    }

    public void clickToPickFromGallery() {
        this.waitForElementAndClick(PICK_FROM_GALLERY, "Can not found pick from gallery btn", 5);
    }

    public void clickToTakePictureACamera() {
        this.waitForElementAndClick(TAKE_A_PICTURE, "Can not found take photo btn", 5);
    }

    public void clickToRemoveProfilePic() {
        this.waitForElementAndClick(REMOVE_PROFILE_PIC, "Can not found remove profile photo btn", 5);
    }

    public void clickToSave() {
        this.waitForElementAndClick(SAVE_BTN, "Can not found save btn on personal info form", 5);
    }

    public void clickToAbout() {
        this.waitForElementAndClick(SETTINGS_ABOUT, "Can not click to about btn", 5);
        this.waitForSettingsCategoryTitleByName("About");
    }

    public void clickToUserAgreement() {
        this.waitForElementAndClick(ABOUT_USER_AGREEMENT, "Can not click to user agreement", 5);
        this.waitForSettingsCategoryTitleByName("User agreement");
    }

    public void clickToRateUs() {
        this.waitForElementAndClick(ABOUT_RATE_US_ON_GOOGLE_PLAY, "Can not click to rate us btn", 5);
    }

    public void clickToChangeTheme() {
        this.waitForElementAndClick(GENERAL_CHANGE_THEME, "Can not found change theme btn", 5);
        this.waitForSettingsCategoryTitleByName("Change theme");
    }

    public void clickToSystemMode() {
        this.waitForElementAndClick(CHANGE_THEME_TO_SYSTEM, "Can not click to system mode", 5);
    }

    public void clickToDarkMode() {
        this.waitForElementAndClick(CHANGE_THEME_TO_DARK, "Can not click to dark mode", 5);
    }

    public void clickToLightMode() {
        this.waitForElementAndClick(CHANGE_THEME_TO_LIGHT, "Can not click to light mode", 5);
    }

    public void clickToChangeLanguage() {
        this.waitForElementAndClick(SETTINGS_CHANGE_LANGUAGE, "Can not click to change language", 5);
        this.waitForSettingsCategoryTitleByName("Change language");
    }

    public void clickToNext() {
        this.waitForElementAndClick(NEXT, "Can not found next btn", 5);
    }

    public void clickToRegionKhorezm() {
        this.waitForElementAndClick(REGION_KHOREZM, "Can not found and click Khorezm region", 5);
    }

    public void clickToSecurity() {
        this.waitForElementAndClick(SETTINGS_SECURITY, "Can not found security btn", 5);
        this.waitForSettingsCategoryTitleByName("Security");
    }

    public void clickToChangeClickPin() {
        this.waitForElementAndClick(CHANGE_CLICK_PIN, "Can not found change click pin btn", 5);
        this.waitForSettingsCategoryTitleByName("Changing CLICK-PIN");
    }

    public void clickToTrustedDevices() {
        this.waitForElementAndClick(TRUSTED_DEVICES, "Can not found trusted devices btn", 5);
        this.waitForSettingsCategoryTitleByName("Trusted Devices");
    }

    public void clickToKillAllSessions() {
        this.waitForElementAndClick(KILL_ALL_SESIONS, "Can not found kill all sessions btn", 5);
    }

    public void clickToKillFourthSession() {
        this.waitForElementAndClick(FOURTH_INDEX_SESSIONS_X_BTN, "Can not found fourth session", 5);
    }

    public void clickToCancel() {
        this.waitForElementAndClick(CANCEL_BTN, "Can not found cancel btn", 5);
    }

    public void clickToUseFingerPrint() {
        this.waitForElementAndClick(FINGER_PRINT_BTN, "Can not found finger print btn", 5);
    }

    public void clickToNextOnSessionKill() {
        this.waitForElementAndClick(NEXT_BTN, "Can not found cancel btn", 5);
    }

    public void clickToTechnicalSupport() {
        this.waitForElementAndClick(TECHNICAL_SUPPORT, "Can not found and click to technical support", 5);
        this.waitForSettingsCategoryTitleByName("Technical Support");
    }

    //TS - technical support
    public void clickToTSRegistration() {
        this.waitForElementAndClick(TS_REGISTRATION, "Can not found technical support registration button", 5);
    }

    public void waitForFingerPrintBtnDisable() {
        WebElement element = waitForElementPresent(FINGER_PRINT_BTN, "Can not found finger print btn", 5);
        if (element.getAttribute("checked").equals("true")) {
            this.waitForElementAndClick(FINGER_PRINT_BTN, "Can not found finger print btn and click it", 5);
        }
        Assert.assertTrue(element.getAttribute("checked").equals("false"));
    }

    public void waitForFingerPrintBtnEnable() {
        WebElement element = waitForElementPresent(FINGER_PRINT_BTN, "Can not found finger print btn", 5);
        if (element.getAttribute("checked").equals("false")) {
            this.waitForElementAndClick(FINGER_PRINT_BTN, "Can not found finger print btn and click it", 5);
        }
        Assert.assertTrue(element.getAttribute("checked").equals("true"));
    }

    public void waitForLockAppDisable() {
        WebElement element = waitForElementPresent(LOCK_APP_BTN, "Can not found lock application btn", 5);
        if (element.getAttribute("checked").equals("true")) {
            this.waitForElementAndClick(LOCK_APP_BTN, "Can not found and click to lock applitaction btn", 5);
        }
        Assert.assertTrue(element.getAttribute("checked").equals("false"));
    }

    public void waitForLockAppEnable() {
        WebElement element = waitForElementPresent(LOCK_APP_BTN, "Can not found lock application btn", 5);
        if (element.getAttribute("checked").equals("false")) {
            this.waitForElementAndClick(LOCK_APP_BTN, "Can not found and click to lock applitaction btn", 5);
        }
        Assert.assertTrue(element.getAttribute("checked").equals("true"));
    }

    public void turnOnVibration() {
        WebElement element = this.waitForElementPresent(GENERAL_VIBRATION, "Can not turn on vibration", 5);
        if (element.getAttribute("checked").equals("false")) {
            this.waitForElementAndClick(GENERAL_VIBRATION, "Can not turn on vibration", 5);
        }
        Assert.assertTrue(element.getAttribute("checked").equals("true"));
    }

    public void turnOffVibration() {
        WebElement element = this.waitForElementPresent(GENERAL_VIBRATION, "Can not turn on vibration", 5);
        if (element.getAttribute("checked").equals("true")) {
            this.waitForElementAndClick(GENERAL_VIBRATION, "Can not turn on vibration", 5);
        }
        Assert.assertTrue(element.getAttribute("checked").equals("false"));
    }

    public void waitForTitleOfSettings() {
        this.waitForElementPresent(SETTINGS_TITLE, "Can not found settings title", 5);
    }

    public void waitForSettingsCategoryTitleByName(String titleName) {
        String title = getSettingsCategoryTitleTpl(titleName);
        this.waitForElementPresent(title, "Can not found" + title + "title", 5);
    }

    public void swipeUntilFindRequireYear(String date) {
        String year = getBirtDateYearTpl(date);
        this.swipeLeftFromRightUntilFindElement(YEAR, year, "Can not found this year", 20);
    }

    public void swipeUpTwoTimes() {
        this.swipeUp(1000);
        this.swipeUp(1000);
    }

    public String getDeviceName() {
        return this.waitForElementAndGetAttribute(FOURTH_INDEX_SESSION_TIME, "text", "Can not get element text", 5);
    }
}
