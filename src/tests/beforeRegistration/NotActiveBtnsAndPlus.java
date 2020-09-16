package tests.beforeRegistration;

import lib.CoreTestCaseBeforeReg;
import lib.ui.NavigationUI;
import org.junit.Test;

public class NotActiveBtnsAndPlus extends CoreTestCaseBeforeReg {
    @Test
    public void testPlusAndNotActiveBtns(){
        NavigationUI navigationUI = new NavigationUI(driver);
        navigationUI.clickEnglishLangBtn();
        navigationUI.clickTopView();
        navigationUI.clickToPlusBtn();
        navigationUI.waitForRequestFoundsViewPresent();
        navigationUI.clickToXBtn();
        navigationUI.clickToMinusBtn();
        navigationUI.waitForExpencesViewPresent();
        navigationUI.clickToNotActiveBtnsOnDashboard();

    }
}
