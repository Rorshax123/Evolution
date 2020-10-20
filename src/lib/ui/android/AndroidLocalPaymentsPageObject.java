package lib.ui.android;

import io.appium.java_client.AppiumDriver;
import lib.ui.LocalPaymentsPageObject;

public class AndroidLocalPaymentsPageObject extends LocalPaymentsPageObject {
    static {
        LOCAL_PATMENTS_TITLE = "xpath://*[@text = 'Local Payment']";
                LOCAL_PAYMENTS_QR_BTN = "xpath://*[@resource-id = 'air.com.ssdsoftwaresolutions.clickuz:id/btnQr']";
                LOCAL_PAYMENTS_SEARCH_FIELD = "xpath://*[@resource-id = 'air.com.ssdsoftwaresolutions.clickuz:id/etSearchText']";
                LOCAL_PAYMENTS_GEOLOCATION = "xpath://*[@text = 'Geolocation']";
                GEOLOCATION_ALLOW = "xpath://*[@resorce-id = 'air.com.ssdsoftwaresolutions.clickuz:id/tvTurnOn']";
                GEOLOCATION_X = "xpath://*[@resource-id = 'air.com.ssdsoftwaresolutions.clickuz:id/ivCancel']";
                CATEGORY_RETAIL = "xpath://*[@text = 'Retail']";
                SERVICE_NAME_TPL = "xpath://*[@text = '{SUBSTRING}']";
                LOCAL_PAYMENTS_CATEGORY_NAME_TPL = "xpath://*[@resource-id = 'air.com.ssdsoftwaresolutions.clickuz:id/tvCategory'][@text = '{SUBSTRING}']";
                LOCAL_PAYMENTS_CATEGORYTITLE_TPL = "xpath://*[@resource-id = 'air.com.ssdsoftwaresolutions.clickuz:id/tvTitle'][@text = '{SUBSTRING}']";
    }

    public AndroidLocalPaymentsPageObject(AppiumDriver driver) {
        super(driver);
    }
}
