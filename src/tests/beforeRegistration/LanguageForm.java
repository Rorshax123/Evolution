package tests.beforeRegistration;

import lib.CoreTestCase;
import lib.ui.NavigationUI;
import org.junit.Test;

public class LanguageForm extends CoreTestCase {

    @Test
    public void testLanguageRu(){
        NavigationUI navigationUI = new NavigationUI(driver);
        navigationUI.clickRussianLangBtn();
        navigationUI.clickToTopViewRu();
    }

    @Test
    public void testLanguageUz(){
        NavigationUI navigationUI = new NavigationUI(driver);
        navigationUI.clickUzbekLangBtn();
        navigationUI.clickToTopViewUz();
    }

    @Test
    public void testLanguageEn(){
        NavigationUI navigationUI = new NavigationUI(driver);
        navigationUI.clickEnglishLangBtn();
        navigationUI.clickToTopView();
    }
}
