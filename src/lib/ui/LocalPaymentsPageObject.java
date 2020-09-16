package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class LocalPaymentsPageObject extends MainPageObject {

    public LocalPaymentsPageObject(AppiumDriver driver) {
        super(driver);
    }

    private static final String
        LOCAL_PATMENTS_TITLE = "//*[@text = 'Local Payment']",
        LOCAL_PAYMENTS_QR_BTN = "//*[@resource-id = 'air.com.ssdsoftwaresolutions.clickuz:id/btnQr']",
        LOCAL_PAYMENTS_SEARCH_FIELD = "//*[@resource-id = 'air.com.ssdsoftwaresolutions.clickuz:id/etSearchText']",
        LOCAL_PAYMENTS_GEOLOCATION = "//*[@text = 'Geolocation']",
            GEOLOCATION_ALLOW = "//*[@resorce-id = 'air.com.ssdsoftwaresolutions.clickuz:id/tvTurnOn']",
            GEOLOCATION_X = "//*[@resource-id = 'air.com.ssdsoftwaresolutions.clickuz:id/ivCancel']",
        SERVICE_NAME_TPL = "//*[@text = '{SUBSTRING}']",
        LOCAL_PAYMENTS_CATEGORY_NAME_TPL = "//*[@resource-id = 'air.com.ssdsoftwaresolutions.clickuz:id/tvCategory'][@text = '{SUBSTRING}']",
        LOCAL_PAYMENTS_CATEGORYTITLE_TPL= "//*[@resource-id = 'air.com.ssdsoftwaresolutions.clickuz:id/tvTitle'][@text = '{SUBSTRING}']";

    /*TEMPLATES*/
    private static String getCategoryName(String substring){
        return LOCAL_PAYMENTS_CATEGORY_NAME_TPL.replace("{SUBSTRING}", substring);
    }

    private static String getCategorytitleTpl(String substring){
        return LOCAL_PAYMENTS_CATEGORYTITLE_TPL.replace("{SUBSTRING}", substring);
    }

    private static String getServiceNameTpl(String substring){
        return SERVICE_NAME_TPL.replace("{SUBSTRING}", substring);
    }
    /*TEMPLATES*/

    public void clickToCategoryByName(String categoryName){
        String catName = getServiceNameTpl(categoryName);
        this.waitForElementAndClick(By.xpath(catName), "Can not find" + categoryName + " category", 5);
    }

    public void clickToServiceByName(String serviceName){
        String service = getServiceNameTpl(serviceName);
        this.waitForElementAndClick(By.xpath(service), "Can not find " + serviceName + "service", 5);
    }

    public void clickToQrBtn(){
        this.waitForElementAndClick(By.xpath(LOCAL_PAYMENTS_QR_BTN), "Can not find qr btn", 5);
    }

    public void clickToSearchAndSendkeys(String sendkeys){
        this.waitForElementAndSendkeys(By.xpath(LOCAL_PAYMENTS_SEARCH_FIELD), "Can not send keys to search field", sendkeys, 5);
    }

    public void clickToAllowBtn(){
        this.waitForElementAndClick(By.xpath(GEOLOCATION_ALLOW), "Can not find allow btn", 5);
    }

    public void clickToXBtn(){
        this.waitForElementAndClick(By.xpath(GEOLOCATION_X), "Can not find X btn", 5);
    }

    public void waitTitle(){
        this.waitForElementPresent(By.xpath(LOCAL_PATMENTS_TITLE), "Can not find local payments title", 5);
    }

    public void waitGeolocationAlert(){
        this.waitForElementPresent(By.xpath(LOCAL_PAYMENTS_GEOLOCATION), "Can not find geolocation alert", 5);
    }

    public void waitCategoryByName(String categoryName){
        String catName = getCategoryName(categoryName);
        this.waitForElementPresent(By.xpath(catName), "Can not find" + categoryName + " category", 5);
    }





}
