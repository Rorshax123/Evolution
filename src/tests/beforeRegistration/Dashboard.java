package tests.beforeRegistration;

import lib.CoreTestCaseBeforeReg;
import lib.ui.NavigationUI;
import lib.ui.NewsPageObject;
import lib.ui.RegistrationPageObject;
import org.junit.Test;

public class Dashboard extends CoreTestCaseBeforeReg {

    @Test
    public void testDashboard(){
        NavigationUI navigationUI = new NavigationUI(driver);

        navigationUI.clickEnglishLangBtn();
        navigationUI.clickTopView();
        navigationUI.waitForRegBtnWithSubstring("Login / registration");
        navigationUI.clickToMushrom();
        navigationUI.waitForFunctionBlockedAlert();
        navigationUI.clickToCancel();
        navigationUI.waitForRegBtnWithSubstring("Login / registration");
        navigationUI.clickToMushrom();
        navigationUI.clickToSignUp();

        RegistrationPageObject registrationPageObject = new RegistrationPageObject(driver);

        registrationPageObject.waitForRegTitle();
        clickToSystemBack();
        navigationUI.waitForRegBtnNotPresent();

        resetApp();

        navigationUI.clickEnglishLangBtn();
        navigationUI.clickTopView();
        navigationUI.waitForRegBtnWithSubstring("Login / registration");
        navigationUI.clickToRegistration("Login / registration");

        registrationPageObject.waitForRegTitle();
        clickToSystemBack();

        resetApp();

        navigationUI.clickEnglishLangBtn();
        navigationUI.clickTopView();
        navigationUI.waitForRegBtnWithSubstring("Login / registration");
        navigationUI.clickToNews();

        NewsPageObject newsPageObject = new NewsPageObject(driver);

        newsPageObject.waitForNewsTitle();
        newsPageObject.swipeToTheLastNews();
        newsPageObject.clickToNewsByTitle("CLICK Evolution – new, convenient, reliable.");
        navigationUI.clickToBackBtn();
        newsPageObject.waitForNewsTitle();
        navigationUI.clickToBackBtn();

        navigationUI.waitForRegBtnWithSubstring("Login / registration");
        navigationUI.clickToMenu();
        navigationUI.clickToCall();
        navigationUI.waitForPhoneNumberOfClick();
        navigationUI.backToAppAfterRedirectingCall();
        navigationUI.clickToExit();
        navigationUI.waitForExitBtnNotPresent();

    }
}
