package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class NavigationUI extends MainPageObject{
    public NavigationUI(AppiumDriver driver) {
        super(driver);
    }
    private static final String
        RUSSIAN_LANG_BTN = "//*[@text='Русский']",
        UZBEK_LANG_BTN = "//*[@text='O\'zbek']",
        ENGLISH_LANG_BTN = "//*[@text='English']",
        DASHBOARD_TOP_VIEW = "//*[@resource-id='air.com.ssdsoftwaresolutions.clickuz:id/tvTopTip']",
        DASHBOARD_MUSHROM = "//*[@resource-id = 'air.com.ssdsoftwaresolutions.clickuz:id/llMushroomChart']",
        DASHBOARD_FUNCTIONBLOCKED = "//*[@text = 'This function is blocked']",
            FUNCTION_BLOCKED_ALERT_CANCEL = "//*[@text='Cancel']",
            FUNCTION_BLOCKED_ALERT_SIGNUP = "//*[@text='Sign up']",
        DASHBOARD_NEWS = "//*[@resource-id = 'air.com.ssdsoftwaresolutions.clickuz:id/ivTopLeftIcon']",
        DASHBOARD_MENU = "//*[@resource-id = 'air.com.ssdsoftwaresolutions.clickuz:id/flMenu']",
        DASHBOARD_PLUS = "//*[@resource-id = 'air.com.ssdsoftwaresolutions.clickuz:id/rbPlus']",
            PLUS_TITLE = "//*[@text = 'Request for funds']",
            PLUS_PAYMENT = "//*[@text = 'Payment']",
            PLUS_LOCAL_PAYMENTS = "//*[@text = 'Local Payment']",
            PLUS_TRANSFER = "//*[@text = 'Transfer']",
            PLUS_CLICK_PASS = "//*[@text = 'CLICK PASS']",
            PLUS_QR = "//*[@text = 'QR - scanner']",
            PLUS_INVOICES = "//*[@text = 'Invoices']",
            PLUS_FAVOURITE = "//*[@text = 'Favourite']",
            PLUS_AUTO_PAYMENTS = "//*[@text = 'Auto payments']",
        DASHBOARD_MINUS = "//*[@resource-id = 'air.com.ssdsoftwaresolutions.clickuz:id/rbMinus']",
            MINUS_TITLE = "//*[@text = 'Expense transactions']",
        DASHBOARD_X_BTN = "//*[@resource-id = 'air.com.ssdsoftwaresolutions.clickuz:id/ivCloseOperations']",
        DASHBOARD_CALL = "//*[@resource-id = 'air.com.ssdsoftwaresolutions.clickuz:id/tvCallClick']",
            PHONE_NUMBER = "//*[@text = '+998 71 231 08 80']",
        DASHBOARD_EXIT = "//*[@resource-id = 'air.com.ssdsoftwaresolutions.clickuz:id/tvExit']",
        DASHBOARD_SETTINGS = "//*[@resource-id = 'air.com.ssdsoftwaresolutions.clickuz:id/ivTopLeftIcon']",
        BACK_BTN = "//*[@resource-id='air.com.ssdsoftwaresolutions.clickuz:id/ivBack']",
        ALLOW_BTN = "//*[@text = 'DENY']",
        DENY_BTN = "//*[@text = 'ALLOW']",
        PLAY_MARKET_CLICK = "//*[@text = 'CLICK.UZ (CLICK LLC)']",
        DASHBOARD_REG_BTN = "//*[@resource-id='air.com.ssdsoftwaresolutions.clickuz:id/btnRegistrationCard']//*[@text='Login / registration']",
        DASHBOARD_REG_BTN_TPL = "//*[@resource-id='air.com.ssdsoftwaresolutions.clickuz:id/btnRegistrationCard']//*[@text='{SUBSTRING}']";

    /*TEMPLATES*/
    private static String getResultSubstring(String substring){
        return DASHBOARD_REG_BTN_TPL.replace("{SUBSTRING}", substring);
    }
    /*TEMPLATES*/

    public void clickRussianLangBtn(){
        this.waitForElementAndClick(By.xpath(RUSSIAN_LANG_BTN), "Can not found russian button", 10);
    }

    public void clickUzbekLangBtn(){
        this.waitForElementAndClick(By.xpath(UZBEK_LANG_BTN), "Can not found uzbek button", 10);
    }

    public void clickEnglishLangBtn(){
        this.waitForElementAndClick(By.xpath(ENGLISH_LANG_BTN), "Can not found english button", 10);
    }

    public void clickTopView(){
        this.waitForElementAndClick(By.xpath(DASHBOARD_TOP_VIEW), "Can not find top view", 10);
    }

    public void clickToMushrom(){
        this.waitForElementAndClick(By.xpath(DASHBOARD_MUSHROM), "Mushrom is not available", 5);
    }

    public void clickToCancel(){
        this.waitForElementAndClick(By.xpath(FUNCTION_BLOCKED_ALERT_CANCEL), "Cancel button is not available", 5);
    }

    public void clickToSignUp(){
        this.waitForElementAndClick(By.xpath(FUNCTION_BLOCKED_ALERT_SIGNUP), "SignUp button is not available", 5);
    }

    public void clickToRegistration(String substring){
        String regElement = getResultSubstring(substring);
        waitForElementAndClick(By.xpath(regElement), "Can not found registration button", 5);
    }

    public void clickToNews(){
        this.waitForElementAndClick(By.xpath(DASHBOARD_NEWS), "Can not find news button", 5);
    }

    public void clickToMenu(){
        this.waitForElementAndClick(By.xpath(DASHBOARD_MENU), "Can not found menu button", 5);
    }
    public void clickToCall(){
        this.waitForElementAndClick(By.xpath(DASHBOARD_CALL), "Can not found menu button", 5);
    }
    public void clickToExit(){
        this.waitForElementAndClick(By.xpath(DASHBOARD_EXIT), "Can not found menu button", 5);
    }
    public void clickToSettings(){
        this.waitForElementAndClick(By.xpath(DASHBOARD_SETTINGS), "Can not found settings btn", 5);
    }

    public void clickToPlusBtn(){
        this.waitForElementAndClick(By.xpath(DASHBOARD_PLUS), "Can not click  to plus btn", 5);
    }

    public void clickToMinusBtn()
    {
        this.waitForElementAndClick(By.xpath(DASHBOARD_MINUS), "Can not click to minus btn", 5);
    }

    public void clickToXBtn(){
        this.waitForElementAndClick(By.xpath(DASHBOARD_X_BTN), "Can not click to x btn", 5);
    }

    public void clickToPayment(){
        this.waitForElementAndClick(By.xpath(PLUS_PAYMENT), "Can not find payment button", 5);
    }

    public void clickToLocalPayments(){
        this.waitForElementAndClick(By.xpath(PLUS_LOCAL_PAYMENTS), "Can not find local payments btn", 5);
    }

    public void clickToBackBtn(){
        this.waitForElementAndClick(By.xpath(BACK_BTN), "Can not click to back button",5 );
    }

    public void clickToAllowBtn(){
        this.waitForElementAndClick(By.xpath(ALLOW_BTN), "Can not find allow btn", 5);
    }

    public void clickToDeny(){
        this.waitForElementAndClick(By.xpath(DENY_BTN), "CAn not find deny btn", 5);
    }

    public void waitForFunctionBlockedAlert(){
        this.waitForElementPresent(By.xpath(DASHBOARD_FUNCTIONBLOCKED), "This function blocked alert not present", 5);
    }

    public void waitForRegBtnWithSubstring(String substring){
        String regElement = getResultSubstring(substring);
        waitForElementPresent(By.xpath(regElement), "Can not found reg button", 5);
    }

    public void waitForPhoneNumberOfClick(){
        this.waitForElementPresent(By.xpath(PHONE_NUMBER), "Can not open call form", 5);
    }

    public void waitForExitBtnNotPresent(){
        this.waitForElementNotPresent(By.xpath(DASHBOARD_EXIT), "Not exit from app", 5);
    }

    public void waitForRegBtnNotPresent(){
        this.waitForElementNotPresent(By.xpath(DASHBOARD_REG_BTN), "Can not found registration button", 10);
    }

    public void waitForRequestFoundsViewPresent(){
        this.waitForElementPresent(By.xpath(PLUS_TITLE), "Can not find request funds title", 5);
    }

    public void waitForExpencesViewPresent(){
        this.waitForElementPresent(By.xpath(MINUS_TITLE), "Can not found expences title", 5);
    }

    public void waitPlayMarketView(){
        this.waitForElementPresent(By.xpath(PLAY_MARKET_CLICK), "Can not open playmarket", 5);
    }

    public void waitForMushromPresent(){
        this.waitForElementPresent(By.xpath(DASHBOARD_MUSHROM), "Can not found mushrom on dashboard", 5);
    }

    public void backToAppAfterRedirectingCall(){

        driver.navigate().back();
        driver.navigate().back();
        driver.navigate().back();
    }

    public void clickToNotActiveBtnsOnDashboard(){

        this.swipeCategoryOnDashboardAndClick(By.xpath(PLUS_TRANSFER), "Can not found transfer btn", 5);
        this.swipeCategoryOnDashboardAndClick(By.xpath(PLUS_CLICK_PASS), "Can not found click pass", 5);
        this.swipeCategoryOnDashboardAndClick(By.xpath(PLUS_QR), "Can not found QR", 5);
        this.swipeCategoryOnDashboardAndClick(By.xpath(PLUS_INVOICES), "Can not found Invoices", 5);
        this.swipeCategoryOnDashboardAndClick(By.xpath(PLUS_FAVOURITE), "Can not found Favourite", 5);
        this.swipeCategoryOnDashboardAndClick(By.xpath(PLUS_AUTO_PAYMENTS), "Can not found AutoPayments", 5);

    }
}
