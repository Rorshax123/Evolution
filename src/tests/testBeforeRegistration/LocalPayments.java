package tests.testBeforeRegistration;

import lib.CoreTestCaseBeforeReg;
import lib.ui.LocalPaymentsPageObject;
import lib.ui.NavigationUI;
import org.junit.Test;

public class LocalPayments extends CoreTestCaseBeforeReg {

    @Test
    public void testRetaiService(){

        NavigationUI navigationUI = new NavigationUI(driver);
        navigationUI.openLocalPayments();

        LocalPaymentsPageObject localPaymentsPageObject = new LocalPaymentsPageObject(driver);
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

        LocalPaymentsPageObject localPaymentsPageObject = new LocalPaymentsPageObject(driver);
        localPaymentsPageObject.clickToQrBtn();
        navigationUI.waitForFunctionBlockedAlert();
    }
}
