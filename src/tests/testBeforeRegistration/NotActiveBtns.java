package tests.testBeforeRegistration;

import lib.CoreTestCaseBeforeReg;
import lib.ui.NavigationUI;
import org.junit.Test;

public class NotActiveBtns extends CoreTestCaseBeforeReg {
    @Test
    public void testPlus(){
        NavigationUI navigationUI = new NavigationUI(driver);
        navigationUI.openMainMenu();
        navigationUI.clickToPlus();
        navigationUI.clickToNotActivePlusBtns();
        navigationUI.clickToX();
    }

    @Test
    public void testMinus(){
        NavigationUI navigationUI = new NavigationUI(driver);
        navigationUI.openMainMenu();
        navigationUI.clickToMinus();
        navigationUI.clickToNotActiveMinusBtns();
        navigationUI.clickToX();
    }
}
