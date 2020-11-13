package lib.ui;

import io.appium.java_client.AppiumDriver;
import lib.Platform;

public class NavigationUI extends MainPageObject {
    private static final String
            RUSSIAN_LANG_BTN = "xpath://*[@text='Русский']",
            UZBEK_LANG_BTN = "xpath://*[@text='O'zbek']",
            ENGLISH_LANG_BTN = "xpath://*[@text='English']",
            DASHBOARD_TOP_VIEW = "xpath://*[@resource-id='air.com.ssdsoftwaresolutions.clickuz:id/tvTopTip']",
            DASHBOARD_MUSHROM = "xpath://*[@resource-id = 'air.com.ssdsoftwaresolutions.clickuz:id/llMushroomChart']",
            DASHBOARD_FUNCTIONBLOCKED = "xpath://*[@text = 'This function is blocked']",
            FUNCTION_BLOCKED_ALERT_CANCEL = "xpath://*[@text='Cancel']",
            FUNCTION_BLOCKED_ALERT_SIGNUP = "xpath://*[@text='Sign up']",
            DASHBOARD_NEWS = "xpath://*[@resource-id = 'air.com.ssdsoftwaresolutions.clickuz:id/ivTopLeftIcon']",
            DASHBOARD_MENU = "xpath://*[@resource-id = 'air.com.ssdsoftwaresolutions.clickuz:id/flMenu']",
            DASHBOARD_PLUS = "xpath://*[@resource-id = 'air.com.ssdsoftwaresolutions.clickuz:id/rbPlus']",
            PLUS_TITLE = "xpath://*[@text = 'Request for funds']",
            REQUEST_FUNDS = "xpath://*[@text = 'Request funds']",
            MY_QR = "xpath://*[@text = 'My QR-code']",
            DASHBOARD_MINUS = "xpath://*[@resource-id = 'air.com.ssdsoftwaresolutions.clickuz:id/rbMinus']",
            MINUS_TITLE = "xpath://*[@text = 'Expense transactions']",
            PAYMENT = "xpath://*[@text = 'Payment']",
            LOCAL_PAYMENTS = "xpath://*[@text = 'Local Payment']",
            TRANSFER = "xpath://*[@text = 'Transfer']",
            CLICK_PASS = "xpath://*[@text = 'CLICK PASS']",
            QR = "xpath://*[@text = 'QR - scanner']",
            INVOICES = "xpath://*[@text = 'Invoices']",
            FAVOURITE = "xpath://*[@text = 'Favourite']",
            AUTO_PAYMENTS = "xpath://*[@text = 'Auto payments']",
            DASHBOARD_X_BTN = "xpath://*[@resource-id = 'air.com.ssdsoftwaresolutions.clickuz:id/ivCloseOperations']",
            DASHBOARD_CALL = "id:air.com.ssdsoftwaresolutions.clickuz:id/tvCallClick",
            PHONE_NUMBER = "xpath://*[@text = '+998 71 231 08 80']",
            DASHBOARD_EXIT = "id:air.com.ssdsoftwaresolutions.clickuz:id/tvExit",
            DASHBOARD_SETTINGS = "id:air.com.ssdsoftwaresolutions.clickuz:id/ivTopLeftIcon",
            DASHBOARD_USER_NAME = "id:air.com.ssdsoftwaresolutions.clickuz:id/tvUserName",
            BACK_BTN = "xpath://*[@resource-id='air.com.ssdsoftwaresolutions.clickuz:id/ivBack']",
            ALLOW_BTN = "xpath://*[@text = 'ALLOW']",
            DENY_BTN = "xpath://*[@text = 'DENY']",
            PLAY_MARKET_CLICK = "xpath://*[@text = 'CLICK.UZ (CLICK LLC)']",
            PLAY_MARKET_SIGN_IN = "id:com.android.vending:id/0_resource_name_obfuscated",
            DASHBOARD_HIDE_BALANCE_BTN = "xpath://*[@text = 'Hide balance']",
            DASHBOARD_REG_BTN = "id:air.com.ssdsoftwaresolutions.clickuz:id/btnRegistrationCard",
            DASHBOARD_REG_BTN_TPL = "xpath://*[@resource-id='air.com.ssdsoftwaresolutions.clickuz:id/btnRegistrationCard']//*[@text='{SUBSTRING}']";

    public NavigationUI(AppiumDriver driver) {
        super(driver);
    }

    /*TEMPLATES*/
    private static String getResultSubstring(String substring) {
        return DASHBOARD_REG_BTN_TPL.replace("{SUBSTRING}", substring);
    }
    /*TEMPLATES*/

    public void clickRussianLangBtn() {
        this.waitForElementAndClick(RUSSIAN_LANG_BTN, "Can not found russian button", 10);
    }

    public void clickUzbekLangBtn() {
        this.waitForElementAndClick(UZBEK_LANG_BTN, "Can not found uzbek button", 10);
    }

    public void clickEnglishLangBtn() {
        this.waitForElementAndClick(ENGLISH_LANG_BTN, "Can not found english button", 10);
    }

    public void clickToTopView() {
        this.waitForElementAndClick(DASHBOARD_TOP_VIEW, "Can not find top view", 10);
        this.waitForElementPresent(DASHBOARD_REG_BTN, "Can not find reg btn", 5);
    }

    public void clickToTopViewRu() {
        this.waitForElementAndClick(DASHBOARD_TOP_VIEW, "Can not find top view", 10);
        this.waitForRegBtnWithSubstring("Вход / Регистрация");
    }

    public void clickToTopViewUz() {
        this.waitForElementAndClick(DASHBOARD_TOP_VIEW, "Can not find top view", 10);
        this.waitForRegBtnWithSubstring("Kirish / Ro'yxatdan o'tish");
    }

    public void clickToMushrom() {
        this.waitForElementAndClick(DASHBOARD_MUSHROM, "Mushrom is not available", 5);
        this.waitForElementPresent(DASHBOARD_FUNCTIONBLOCKED, "Function blocked alert is not present", 5);
    }

    public void clickToCancel() {
        this.waitForElementAndClick(FUNCTION_BLOCKED_ALERT_CANCEL, "Cancel button is not available", 5);
        this.waitForElementNotPresent(FUNCTION_BLOCKED_ALERT_CANCEL, "Function blocked cancel btn is present", 5);
    }

    public void clickToSignUp() {
        this.waitForElementAndClick(FUNCTION_BLOCKED_ALERT_SIGNUP, "SignUp button is not available", 5);
    }

    public void clickToRegistrationByName(String substring) {
        String regElement = getResultSubstring(substring);
        waitForElementAndClick(regElement, "Can not found registration button", 5);
    }

    public void clickToRegistration() {
        waitForElementAndClick(DASHBOARD_REG_BTN, "Can not found registration button", 5);
    }

    public void clickToNews() {
        this.waitForElementAndClick(DASHBOARD_NEWS, "Can not find news button", 5);
    }

    public void clickToMenu() {
        this.waitForElementAndClick(DASHBOARD_MENU, "Can not found menu button", 5);
        this.waitForElementPresent(DASHBOARD_CALL, "Can not found call btn", 5);
        this.waitForElementPresent(DASHBOARD_EXIT, "Can not found exit btn", 5);
        this.waitForElementPresent(DASHBOARD_SETTINGS, "Can not found settings btn", 5);
        this.waitForElementPresent(DASHBOARD_USER_NAME, "Can not found user name label", 5);
    }

    public void clickToCall() {
        this.waitForElementAndClick(DASHBOARD_CALL, "Can not found menu button", 5);
    }

    public void clickToExit() {
        this.waitForElementAndClick(DASHBOARD_EXIT, "Can not found menu button", 5);
        this.waitForElementNotPresent(DASHBOARD_EXIT, "Exit button is present", 5);
    }

    public void clickToSettings() {
        this.waitForElementAndClick(DASHBOARD_SETTINGS, "Can not found settings btn", 5);
    }

    public void clickToPlus() {
        this.waitForElementAndClick(DASHBOARD_PLUS, "Can not click to plus btn", 5);
        this.waitForElementPresent(PLUS_TITLE, "Plus title is not visible", 5);
    }

    public void clickRequestFunds() {
        this.waitForElementAndClick(REQUEST_FUNDS, "Can not click to request funds btn", 5);
    }

    public void clickMyQR() {
        this.waitForElementAndClick(MY_QR, "Can not click to my qr btn", 5);
    }

    public void clickToMinus() {
        this.waitForElementAndClick(DASHBOARD_MINUS, "Can not click to minus btn", 5);
        this.waitForElementPresent(MINUS_TITLE, "Can not find minus title", 5);
    }

    public void clickToX() {
        this.waitForElementAndClick(DASHBOARD_X_BTN, "Can not click to x btn", 5);
    }

    public void clickToPayment() {
        this.waitForElementAndClick(PAYMENT, "Can not find payment button", 5);
    }

    public void clickToLocalPayments() {
        this.waitForElementAndClick(LOCAL_PAYMENTS, "Can not find local payments btn", 5);
    }

    public void clickToBackBtn() {
        this.waitForElementAndClick(BACK_BTN, "Can not click to back button", 5);
    }

    public void clickToAllowBtn() {
        this.waitForElementAndClick(ALLOW_BTN, "Can not find allow btn", 5);
    }

    public void clickToDeny() {
        this.waitForElementAndClick(DENY_BTN, "CAn not find deny btn", 5);
    }

    public void waitForRegBtnWithSubstring(String substring) {
        String regElement = getResultSubstring(substring);
        waitForElementPresent(regElement, "Can not found reg button", 5);
    }

    public void waitForPhoneNumberOfClick() {
        this.waitForElementPresent(PHONE_NUMBER, "Can not open call form", 5);
    }

    public void waitForExitBtnNotPresent() {
        this.waitForElementNotPresent(DASHBOARD_EXIT, "Not exit from app", 5);
    }

    public void waitForRegBtnPresent() {
        this.waitForElementPresent(DASHBOARD_REG_BTN, "Can not found reg button", 5);
    }

    public void waitForRegBtnNotPresent() {
        this.waitForElementNotPresent(DASHBOARD_REG_BTN, "Can not found registration button", 10);
    }

    public void waitForRequestFoundsViewPresent() {
        this.waitForElementPresent(PLUS_TITLE, "Can not find request funds title", 5);
    }

    public void waitForExpencesViewPresent() {
        this.waitForElementPresent(MINUS_TITLE, "Can not found expences title", 5);
    }

    public void waitPlayMarketView() {
        this.waitForElementPresent(PLAY_MARKET_SIGN_IN, "Can not open playmarket", 5);
    }

    public void waitForMushromPresent() {
        this.waitForElementPresent(DASHBOARD_MUSHROM, "Can not found mushrom on dashboard", 5);
    }

    public void waitForFunctionBlockedAlert() {
        this.waitForElementPresent(DASHBOARD_FUNCTIONBLOCKED, "Can not find function blocked alert title", 5);
    }

    public void backToAppAfterRedirectingCall() {

        driver.navigate().back();
        driver.navigate().back();
        driver.navigate().back();
    }

    public void clickToNotActiveMinusBtns() {
        this.swipeCategoryOnDashboardAndClick(TRANSFER, "Can not found transfer btn", 5);
        this.swipeCategoryOnDashboardAndClick(CLICK_PASS, "Can not found click pass", 5);
        this.swipeCategoryOnDashboardAndClick(QR, "Can not found QR", 5);
        this.swipeCategoryOnDashboardAndClick(INVOICES, "Can not found Invoices", 5);
        this.swipeCategoryOnDashboardAndClick(FAVOURITE, "Can not found Favourite", 5);
        this.swipeCategoryOnDashboardAndClick(AUTO_PAYMENTS, "Can not found AutoPayments", 5);
    }

    public void clickToNotActivePlusBtns() {
        this.waitForElementAndClick(REQUEST_FUNDS, "Can not click to request funds btn", 5);
        this.waitForElementAndClick(MY_QR, "Can not click to my qr btn", 5);

    }

    public void openMainMenu() {
        if (Platform.getInstance().isAndroid()) {
            RegistrationPageObject registrationPageObject = new RegistrationPageObject(driver);
            registrationPageObject.waitPinFormAndAddPin();
            this.waitForElementPresent(DASHBOARD_HIDE_BALANCE_BTN, "Can not find hide balance btn", 5);
        } else if (Platform.getInstance().isAndroidBeforeReg()) {
            this.waitForElementAndClick(ENGLISH_LANG_BTN, "Can not find English lang btn", 5);
            this.waitForElementAndClick(DASHBOARD_TOP_VIEW, "Can not find top view", 5);
        }
    }

    public void openMainMenuBeforeReg() {
        this.waitForElementAndClick(ENGLISH_LANG_BTN, "Can not find English lang btn", 5);
        this.waitForElementAndClick(DASHBOARD_TOP_VIEW, "Can not find top view", 5);
    }

    public void openSettings() {
        this.openMainMenu();
        this.clickToMenu();
        this.clickToSettings();
    }

    public void openLocalPayments() {
        this.openMainMenu();
        this.clickToMinus();
        this.clickToLocalPayments();
    }

    public void openPayment() {
        this.openMainMenu();
        this.clickToMinus();
        this.clickToPayment();
    }
}
