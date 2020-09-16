package tests.registration;

import lib.CoreTestCaseBeforeReg;
import lib.ui.NavigationUI;
import lib.ui.RegistrationPageObject;
import org.junit.Test;

public class Registration extends CoreTestCaseBeforeReg {

    @Test
    public void testRegistration(){

        NavigationUI navigationUI = new NavigationUI(driver);

        navigationUI.clickEnglishLangBtn();
        navigationUI.clickTopView();
        navigationUI.clickToRegistration("Login / registration");

        RegistrationPageObject registrationPageObject = new RegistrationPageObject(driver);

        registrationPageObject.waitForRegTitle();

    }
}
