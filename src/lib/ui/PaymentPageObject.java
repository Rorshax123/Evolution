package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class PaymentPageObject extends MainPageObject {

    public PaymentPageObject(AppiumDriver driver) {
        super(driver);
    }

    private static final String
        PAYMENT_MAIN_TITLE = "//*[@text = 'Payment']",
        PAYMENT_EMPTY_SEARCH_INPUT = "//*[@text = 'Enter Service name']",
        PAYMENT_QR_BTN = "//*[@resource-id = 'air.com.ssdsoftwaresolutions.clickuz:id/btnQr']",
        PAYMENT_UZMOBILE_GSM = "//*[@resource-id = 'air.com.ssdsoftwaresolutions.clickuz:id/rvServiceList']//*[@index = '4']",
        PAYMENT_CATEGORY_TPL = "//*[@resource-id = 'air.com.ssdsoftwaresolutions.clickuz:id/tvCategory'][@text='{SUBSTRING}']",
        PAYMENT_CATEGORY_TTITLE_TPL = "//*[@resource-id = 'air.com.ssdsoftwaresolutions.clickuz:id/tvTitle'][@text='{SUBSTRING}']";

    /*TEMPLATES*/
    private static String getResultSubstring(String substring){
        return PAYMENT_CATEGORY_TPL.replace("{SUBSTRING}", substring);
    }

    private static String getResultTitleSubstring(String substring){
        return PAYMENT_CATEGORY_TTITLE_TPL.replace("{SUBSTRING}", substring);
    }
    /*TEMPLATES*/

    public void clickToCategoryByName(String categoryName){
        String element = getResultSubstring(categoryName);
        this.waitForElementAndClick(By.xpath(element), "Can not found and clcik to" + element + " category", 5);
    }

    public void clickToSearchFieldAndSendKeys(String serviceName){
        this.waitForElementAndSendkeys(By.xpath(PAYMENT_EMPTY_SEARCH_INPUT), "Can not found search field", serviceName, 5);
    }

    public void clickToQrBtn() {
        this.waitForElementAndClick(By.xpath(PAYMENT_QR_BTN), "Can not click to qr button", 5);
    }

    public void clickToUzmobileGsm(){
        this.waitForElementAndClick(By.xpath(PAYMENT_UZMOBILE_GSM), "Can not uzmobile gsm btn", 5);
    }

    public void waitForMainPaymentTitle(){
        this.waitForElementPresent(By.xpath(PAYMENT_MAIN_TITLE), "Can not found main title of payment", 5);
    }

    public void waitForCategoryTitle(String categoryTitle){
        String category = getResultTitleSubstring(categoryTitle);
        this.waitForElementPresent(By.xpath(category), "Can not found" + PAYMENT_CATEGORY_TTITLE_TPL + "category title", 5);
    }
}
