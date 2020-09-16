package tests.beforeRegistration;

import lib.CoreTestCaseBeforeReg;
import lib.ui.LocalPaymentsPageObject;
import lib.ui.NavigationUI;
import org.junit.Test;

public class LocalPayments extends CoreTestCaseBeforeReg {

    @Test
    public void testLocalPayments(){

        NavigationUI navigationUI = new NavigationUI(driver);

        navigationUI.clickEnglishLangBtn();
        navigationUI.clickTopView();
        navigationUI.clickToMinusBtn();
        navigationUI.clickToLocalPayments();

        LocalPaymentsPageObject localPaymentsPageObject = new LocalPaymentsPageObject(driver);
        navigationUI.clickToDeny();
        localPaymentsPageObject.waitTitle();
        localPaymentsPageObject.clickToCategoryByName("Retail");
        localPaymentsPageObject.clickToSearchAndSendkeys("Optimist");
        localPaymentsPageObject.clickToServiceByName("Optimist (MegaPlanet)");
        navigationUI.waitForFunctionBlockedAlert();
        navigationUI.clickToCancel();
        localPaymentsPageObject.clickToQrBtn();
        navigationUI.waitForFunctionBlockedAlert();

    }
}
