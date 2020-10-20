package tests.beforeRegistration;

import lib.CoreTestCase;
import lib.ui.NavigationUI;
import lib.ui.NewsPageObject;
import lib.ui.RegistrationPageObject;
import org.junit.Test;

public class Dashboard extends CoreTestCase {

    @Test
    public void testRegistration(){
        NavigationUI navigationUI = new NavigationUI(driver);
        navigationUI.openMainMenu();
        navigationUI.clickToRegistration();

        RegistrationPageObject registrationPageObject = new RegistrationPageObject(driver);
        registrationPageObject.waitForRegTitle();
        clickToSystemBack();
    }

    @Test
    public void testMushromReg(){
        NavigationUI navigationUI = new NavigationUI(driver);
        navigationUI.openMainMenu();
        navigationUI.clickToMushrom();
        navigationUI.clickToCancel();
        navigationUI.waitForRegBtnWithSubstring("Login / Registration");
        navigationUI.clickToMushrom();
        navigationUI.clickToSignUp();

        RegistrationPageObject registrationPageObject = new RegistrationPageObject(driver);
        registrationPageObject.waitForRegTitle();
        clickToSystemBack();
        navigationUI.waitForRegBtnNotPresent();
    }

    @Test
    public void testNews(){
        NavigationUI navigationUI = new NavigationUI(driver);
        navigationUI.openMainMenu();
        navigationUI.clickToNews();

        NewsPageObject newsPageObject = new NewsPageObject(driver);
        newsPageObject.waitForNewsTitle();
        newsPageObject.swipeToTheLastNews();
        newsPageObject.clickToNewsByTitle("CLICK Evolution – new, convenient, reliable.");
        navigationUI.clickToBackBtn();
        newsPageObject.waitForNewsTitle();
        navigationUI.clickToBackBtn();

        navigationUI.waitForRegBtnWithSubstring("Login / registration");
    }

    @Test
    public void testMenu(){
        NavigationUI navigationUI = new NavigationUI(driver);
        navigationUI.openMainMenu();
        navigationUI.clickToMenu();
        navigationUI.clickToCall();
        navigationUI.waitForPhoneNumberOfClick();
        navigationUI.backToAppAfterRedirectingCall();
        navigationUI.clickToExit();
    }
}
