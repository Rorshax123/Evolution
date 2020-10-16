package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class RegistrationPageObject extends MainPageObject{

    public RegistrationPageObject(AppiumDriver driver) {
        super(driver);
    }

    private static final String
        REGISTRATION_TITLE = "xpath://*[@text='Authorization']",
        REGISTRATION_NUMBERS_TPL = "xpath://*[@resource-id = 'air.com.ssdsoftwaresolutions.clickuz:id/numpad']//*[@text = '{number}']";

    /*TEMPLATES*/
    private static String changePhoneNumber(String number){
        return REGISTRATION_NUMBERS_TPL.replace("{number}", number);
    }
    /*TEMPLATES*/


    public void waitForRegTitle(){
        this.waitForElementPresent(REGISTRATION_TITLE, "Cannot find registration title", 5);
    }


    public boolean waitForRegTitleBool(){
        return this.waitForElementPresent(REGISTRATION_TITLE, "Cannot find registration title", 5).isDisplayed();
    }


    private void clickToNumber(String linkToNumber){
        this.waitForElementAndClick(linkToNumber, " Cannot found nine", 5);
    }

    public void clickToNumberOnReg(String phoneNumber){

        for (int i = 0; i < phoneNumber.length(); i++ ){
            int numb = Character.getNumericValue(phoneNumber.charAt(i));
            for (int j = 0; j <= 9; j++){
                if (numb == j){
                    clickToNumber(changePhoneNumber("" + j));
                    break;
                }
            }
        }

    }
}
