package tests.beforeRegistration;

import lib.CoreTestCase;
import lib.ui.LocalPaymentsPageObject;
import lib.ui.NavigationUI;
import lib.ui.factories.LocalPaymentsPageObjectFactory;
import org.junit.Test;

public class LocalPayments extends CoreTestCase {

    @Test
    public void testRetaiService(){

        NavigationUI navigationUI = new NavigationUI(driver);
        navigationUI.openLocalPayments();

        LocalPaymentsPageObject localPaymentsPageObject = LocalPaymentsPageObjectFactory.get(driver);
        navigationUI.clickToDeny();
        localPaymentsPageObject.waitTitleOfLocalPayments();
        localPaymentsPageObject.clickToRetail();
        localPaymentsPageObject.clickToSearchAndSendkeys("Optimist");
        localPaymentsPageObject.clickToServiceByName("Optimist (MegaPlanet)");
        navigationUI.waitForFunctionBlockedAlert();
        navigationUI.clickToCancel();
    }

    @Test
    public void testQRScanner(){
        NavigationUI navigationUI = new NavigationUI(driver);
        navigationUI.openLocalPayments();

        LocalPaymentsPageObject localPaymentsPageObject = LocalPaymentsPageObjectFactory.get(driver);
        localPaymentsPageObject.clickToQrBtn();
        navigationUI.waitForFunctionBlockedAlert();
    }
}
