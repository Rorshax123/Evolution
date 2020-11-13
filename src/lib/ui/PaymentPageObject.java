package lib.ui;

import io.appium.java_client.AppiumDriver;

public class PaymentPageObject extends MainPageObject {

    private static final String
            PAYMENT_MAIN_TITLE = "xpath://*[@text = 'Payment']",
            PAYMENT_EMPTY_SEARCH_INPUT = "xpath://*[@text = 'Enter Service name']",
            PAYMENT_QR_BTN = "xpath://*[@resource-id = 'air.com.ssdsoftwaresolutions.clickuz:id/btnQr']",
            MOBILE_OPERATORS_CATEGORY = "xpath://*[@text = 'Mobile operators']",
            UZMOBILE_GSM = "xpath://*[@resource-id = 'air.com.ssdsoftwaresolutions.clickuz:id/rvServiceList']//*[@index = '4']",
            PAYMENT_CATEGORY_TPL = "xpath://*[@resource-id = 'air.com.ssdsoftwaresolutions.clickuz:id/tvCategory'][@text='{SUBSTRING}']",
            PAYMENT_CATEGORY_TTITLE_TPL = "xpath://*[@resource-id = 'air.com.ssdsoftwaresolutions.clickuz:id/tvTitle'][@text='{SUBSTRING}']";

    public PaymentPageObject(AppiumDriver driver) {
        super(driver);
    }

    /*TEMPLATES*/
    private static String getResultSubstring(String substring) {
        return PAYMENT_CATEGORY_TPL.replace("{SUBSTRING}", substring);
    }

    private static String getResultTitleSubstring(String substring) {
        return PAYMENT_CATEGORY_TTITLE_TPL.replace("{SUBSTRING}", substring);
    }
    /*TEMPLATES*/

    public void clickToCategoryByName(String categoryName) {
        String element = getResultSubstring(categoryName);
        this.waitForElementAndClick(element, "Can not found and clcik to" + element + " category", 5);
    }

    public void clickToMobileOperatorsCategory() {
        this.waitForElementAndClick(MOBILE_OPERATORS_CATEGORY, "Can not found mobile operators category", 5);
        this.waitForCategoryTitle("Mobile operators");
    }

    public void clickToSearchFieldAndSendKeys(String serviceName) {
        this.waitForElementAndSendkeys(PAYMENT_EMPTY_SEARCH_INPUT, "Can not found search field", serviceName, 5);
    }

    public void clickToQrBtn() {
        this.waitForElementAndClick(PAYMENT_QR_BTN, "Can not click to qr button", 5);
    }

    public void clickToUzmobileGsm() {
        this.waitForElementAndClick(UZMOBILE_GSM, "Can not uzmobile gsm btn", 5);
    }

    public void waitForPaymentTitle() {
        this.waitForElementPresent(PAYMENT_MAIN_TITLE, "Can not found main title of payment", 5);
    }

    public void waitForCategoryTitle(String categoryTitle) {
        String category = getResultTitleSubstring(categoryTitle);
        this.waitForElementPresent(category, "Can not found" + PAYMENT_CATEGORY_TTITLE_TPL + "category title", 5);
    }
}
