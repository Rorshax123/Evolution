package lib.ui;

import io.appium.java_client.AppiumDriver;
import lib.Metoo;

public class RegistrationPageObject extends MainPageObject {

    private static final String
            REGISTRATION_TITLE = "xpath://*[@text='Authorization']",
            REGISTRATION_NUMBERS_TPL = "xpath://*[@text = '{number}']",
            REGISTRATION_RESET_APP = "id:air.com.ssdsoftwaresolutions.clickuz:id/tvResetData";

    public RegistrationPageObject(AppiumDriver driver) {
        super(driver);
    }

    /*TEMPLATES*/
    private static String changePhoneNumber(String number) {
        return REGISTRATION_NUMBERS_TPL.replace("{number}", number);
    }
    /*TEMPLATES*/

    public void waitForRegTitle() {
        this.waitForElementPresent(REGISTRATION_TITLE, "Cannot find registration title", 5);
    }

    public boolean waitForRegTitleBool() {
        return this.waitForElementPresent(REGISTRATION_TITLE, "Cannot find registration title", 5).isDisplayed();
    }

    private void clickToNumber(String linkToNumber) {
        this.waitForElementAndClick(linkToNumber, " Cannot found nine", 5);
    }

    public void clickToNumbers(String phoneNumber) {

        for (int i = 0; i < phoneNumber.length(); i++) {
            int numb = Character.getNumericValue(phoneNumber.charAt(i));
            for (int j = 0; j <= 9; j++) {
                if (numb == j) {
                    clickToNumber(changePhoneNumber("" + j));
                    break;
                }
            }
        }

    }

    public void waitForgotClickPinBtn() {
        this.waitForElementPresent(REGISTRATION_RESET_APP, "Can not find forgot click pin btn", 10);
    }

    public void skipRegistrationFast() {
        NavigationUI navigationUI = new NavigationUI(driver);
        Metoo metoo = new Metoo();
        navigationUI.openMainMenuBeforeReg();
        navigationUI.clickToRegistration();
        this.clickToNumbers(Metoo.NICKS_PHONE_NUMBER);
        navigationUI.clickToDeny();
        this.clickToNumbers(Metoo.NICKS_SMS_CODE);
    }


    public void waitPinFormAndAddPin() {
        Metoo metoo = new Metoo();
        this.waitForgotClickPinBtn();
        this.clickToNumbers(Metoo.NICKS_PIN_CODE);
    }

    public void addPin() {
        Metoo metoo = new Metoo();
        this.clickToNumbers(Metoo.NICKS_PIN_CODE);
    }

    public void addPin(String newPin) {
        this.clickToNumbers(newPin);
    }
}
