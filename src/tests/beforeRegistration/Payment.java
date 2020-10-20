package tests.beforeRegistration;

import lib.CoreTestCase;
import lib.ui.NavigationUI;
import lib.ui.PaymentPageObject;
import org.junit.Test;

public class Payment extends CoreTestCase {

    @Test
    public void testMobileOperatorsCategory(){

        NavigationUI navigationUI = new NavigationUI(driver);
        navigationUI.openPayment();

        PaymentPageObject paymentPageObject = new PaymentPageObject(driver);
        paymentPageObject.waitForPaymentTitle();
        paymentPageObject.clickToMobileOperatorsCategory();
        paymentPageObject.clickToUzmobileGsm();

        navigationUI.waitForFunctionBlockedAlert();
        navigationUI.clickToCancel();
        paymentPageObject.waitForCategoryTitle("Mobile operators");
        paymentPageObject.clickToSearchFieldAndSendKeys("Uz");
        paymentPageObject.clickToQrBtn();
        navigationUI.waitForFunctionBlockedAlert();

    }

    @Test
    public void testQR(){
        NavigationUI navigationUI = new NavigationUI(driver);
        navigationUI.openPayment();

        PaymentPageObject paymentPageObject = new PaymentPageObject(driver);
        paymentPageObject.clickToQrBtn();
        navigationUI.waitForFunctionBlockedAlert();

    }
}
