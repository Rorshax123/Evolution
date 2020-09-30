package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class NewsPageObject extends MainPageObject {
    public NewsPageObject(AppiumDriver driver) {
        super(driver);
    }

    private static final String
        NEWS_TITLE = "//*[@resource-id='air.com.ssdsoftwaresolutions.clickuz:id/tvTitle'][@text='News']",
        LAST_NEWS_TITLE = "//*[@text = 'CLICK Evolution – new, convenient, reliable.']",
        LAST_NEWS_TITLE_TPL = "//*[@text='{SUBSTRING}']";

    /*TEMPLATES*/
    private static String getResultSubstring(String substring){
        return LAST_NEWS_TITLE_TPL.replace("{SUBSTRING}", substring);
    }
    /*TEMPLATES**/


    public void waitForNewsTitle(){
        this.waitForElementPresent(By.xpath(NEWS_TITLE), "Can not find news title", 5);
    }

    public void waitForNewsTitleNotPresent(){
        this.waitForElementNotPresent(By.xpath(NEWS_TITLE), "Can not find news title", 5);
    }

    public void swipeToTheLastNews(){
        this.swipeUntilFindElement(By.xpath(LAST_NEWS_TITLE), "Can not find Last news by swiping left", 20);
    }

    public void clickToNewsByTitle(String substring){
        String newsTitle = getResultSubstring(substring);
        this.waitForElementAndClick(By.xpath(newsTitle), "Can not open news", 5);
    }
}
