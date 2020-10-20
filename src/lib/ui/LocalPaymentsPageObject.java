package lib.ui;

import io.appium.java_client.AppiumDriver;

abstract public class LocalPaymentsPageObject extends MainPageObject {

    public LocalPaymentsPageObject(AppiumDriver driver) {
        super(driver);
    }

     protected static String
        LOCAL_PATMENTS_TITLE = "xpath://*[@text = 'Local Payment']",
        LOCAL_PAYMENTS_QR_BTN = "xpath://*[@resource-id = 'air.com.ssdsoftwaresolutions.clickuz:id/btnQr']",
        LOCAL_PAYMENTS_SEARCH_FIELD = "xpath://*[@resource-id = 'air.com.ssdsoftwaresolutions.clickuz:id/etSearchText']",
        LOCAL_PAYMENTS_GEOLOCATION = "xpath://*[@text = 'Geolocation']",
            GEOLOCATION_ALLOW = "xpath://*[@resorce-id = 'air.com.ssdsoftwaresolutions.clickuz:id/tvTurnOn']",
            GEOLOCATION_X = "xpath://*[@resource-id = 'air.com.ssdsoftwaresolutions.clickuz:id/ivCancel']",
        CATEGORY_RETAIL = "xpath://*[@text = 'Retail']",
        SERVICE_NAME_TPL = "xpath://*[@text = '{SUBSTRING}']",
        LOCAL_PAYMENTS_CATEGORY_NAME_TPL = "xpath://*[@resource-id = 'air.com.ssdsoftwaresolutions.clickuz:id/tvCategory'][@text = '{SUBSTRING}']",
        LOCAL_PAYMENTS_CATEGORYTITLE_TPL= "xpath://*[@resource-id = 'air.com.ssdsoftwaresolutions.clickuz:id/tvTitle'][@text = '{SUBSTRING}']";

    /*TEMPLATES*/
    private static String getCategoryName(String substring){
        return LOCAL_PAYMENTS_CATEGORY_NAME_TPL.replace("{SUBSTRING}", substring);
    }

    private static String getCategoryTitleTpl(String substring){
        return LOCAL_PAYMENTS_CATEGORYTITLE_TPL.replace("{SUBSTRING}", substring);
    }

    private static String getServiceNameTpl(String substring){
        return SERVICE_NAME_TPL.replace("{SUBSTRING}", substring);
    }
    /*TEMPLATES*/

    public void clickToCategoryByName(String categoryName){
        String catName = getServiceNameTpl(categoryName);
        this.waitForElementAndClick(catName, "Can not find" + categoryName + " category", 5);
    }

    public void clickToRetail(){
        this.waitForElementAndClick(CATEGORY_RETAIL, "Can not find retail category", 5);
        this.waitTitletCategoryByName("Retail");
    }

    public void clickToServiceByName(String serviceName){
        String service = getServiceNameTpl(serviceName);
        this.waitForElementAndClick(service, "Can not find " + serviceName + "service", 5);
    }

    public void clickToQrBtn(){
        this.waitForElementAndClick(LOCAL_PAYMENTS_QR_BTN, "Can not find qr btn", 5);
    }

    public void clickToSearchAndSendkeys(String sendkeys){
        this.waitForElementAndSendkeys(LOCAL_PAYMENTS_SEARCH_FIELD, "Can not send keys to search field", sendkeys, 5);
    }

    public void clickToAllowBtn(){
        this.waitForElementAndClick(GEOLOCATION_ALLOW, "Can not find allow btn", 5);
    }

    public void clickToXBtn(){
        this.waitForElementAndClick(GEOLOCATION_X, "Can not find X btn", 5);
    }

    public void waitTitleOfLocalPayments(){
        this.waitForElementPresent(LOCAL_PATMENTS_TITLE, "Can not find local payments title", 5);
    }

    public void waitGeolocationAlert(){
        this.waitForElementPresent(LOCAL_PAYMENTS_GEOLOCATION, "Can not find geolocation alert", 5);
    }

    public void waitCategoryByName(String categoryName){
        String catName = getCategoryName(categoryName);
        this.waitForElementPresent(catName, "Can not find" + categoryName + " category", 5);
    }
    public void waitTitletCategoryByName(String categoryTitle){
        String categoryTitleTplName = getCategoryTitleTpl(categoryTitle);
        this.waitForElementPresent(categoryTitleTplName, "Can not find" + categoryTitle + " category", 5);
    }





}
