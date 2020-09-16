package tests.beforeRegistration;

import lib.CoreTestCaseBeforeReg;
import lib.ui.NavigationUI;
import org.junit.Test;

public class LanguageForm extends CoreTestCaseBeforeReg {

    @Test
    public void testLanguageRu(){
        NavigationUI navigationUI = new NavigationUI(driver);

        navigationUI.clickRussianLangBtn();
        navigationUI.clickTopView();
        navigationUI.waitForRegBtnWithSubstring("Вход / Регистрация");
    }

    @Test
    public void testLanguageUz(){
        NavigationUI navigationUI = new NavigationUI(driver);

        navigationUI.clickUzbekLangBtn();
        navigationUI.clickTopView();
        navigationUI.waitForRegBtnWithSubstring("Kirish / Ro'yxatdan o'tish");
    }

    @Test
    public void testLanguageEn(){
        NavigationUI navigationUI = new NavigationUI(driver);

        navigationUI.clickEnglishLangBtn();
        navigationUI.clickTopView();
        navigationUI.waitForRegBtnWithSubstring("Login / registration");
    }
}
