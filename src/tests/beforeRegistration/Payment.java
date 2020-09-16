package tests.beforeRegistration;

import lib.CoreTestCaseBeforeReg;
import lib.ui.NavigationUI;
import lib.ui.PaymentPageObject;
import org.junit.Test;

public class Payment extends CoreTestCaseBeforeReg {

    @Test
    public void testPayment(){

        NavigationUI navigationUI = new NavigationUI(driver);

        navigationUI.clickEnglishLangBtn();
        navigationUI.clickTopView();
        navigationUI.clickToMinusBtn();
        navigationUI.waitForExpencesViewPresent();
        navigationUI.clickToPayment();

        PaymentPageObject paymentPageObject = new PaymentPageObject(driver);

        paymentPageObject.clickToCategoryByName("Mobile operators");
        paymentPageObject.waitForCategoryTitle("Mobile operators");
        paymentPageObject.clickToUzmobileGsm();

        navigationUI.waitForFunctionBlockedAlert();
        navigationUI.clickToCancel();
        paymentPageObject.waitForCategoryTitle("Mobile operators");
        paymentPageObject.clickToSearchFieldAndSendKeys("Uz");
        paymentPageObject.clickToQrBtn();
        navigationUI.waitForFunctionBlockedAlert();

    }
}
