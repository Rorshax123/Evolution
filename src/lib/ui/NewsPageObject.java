package lib.ui;

import io.appium.java_client.AppiumDriver;

public class NewsPageObject extends MainPageObject {
    private static final String
            NEWS_TITLE = "xpath://*[@resource-id='air.com.ssdsoftwaresolutions.clickuz:id/tvTitle'][@text='News']",
            LAST_NEWS_TITLE = "xpath://*[@text = 'CLICK Evolution – new, convenient, reliable.']",
            LAST_NEWS_TITLE_TPL = "xpath://*[@text='{SUBSTRING}']";

    public NewsPageObject(AppiumDriver driver) {
        super(driver);
    }

    /*TEMPLATES*/
    private static String getResultSubstring(String substring) {
        return LAST_NEWS_TITLE_TPL.replace("{SUBSTRING}", substring);
    }
    /*TEMPLATES**/


    public void waitForNewsTitle() {
        this.waitForElementPresent(NEWS_TITLE, "Can not find news title", 5);
    }

    public void waitForNewsTitleNotPresent() {
        this.waitForElementNotPresent(NEWS_TITLE, "Can not find news title", 5);
    }

    public void swipeToTheLastNews() {
        this.swipeUntilFindElement(LAST_NEWS_TITLE, "Can not find Last news by swiping left", 20);
    }

    public void clickToNewsByTitle(String substring) {
        String newsTitle = getResultSubstring(substring);
        this.waitForElementAndClick(newsTitle, "Can not open news", 5);
    }
}
