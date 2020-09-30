package lib.ui;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class MainPageObject {

    protected AppiumDriver driver;


    public MainPageObject(AppiumDriver driver)
    {
        this.driver = driver;
    }


    public WebElement waitForElementPresent(By by, String errorMessage, long timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(errorMessage);
        return wait.until(
                ExpectedConditions.presenceOfElementLocated(by)
        );
    }

    public void waitForSearchElementPresentByText(By by,String text, String errorMessage, long timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(errorMessage);
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(by));
        String elementText = element.getText().toLowerCase();
        Assert.assertTrue(elementText.contains(text));

    }

    public WebElement waitForElementAndClick(By by, String errorMessage, long timeoutInSeconds) {
        WebElement element = waitForElementPresent(by, errorMessage, timeoutInSeconds);
        element.click();
        return element;
    }

    public WebElement waitForElementAndClear(By by, String errorMessage, long timeoutInSeconds) {
        WebElement element = waitForElementPresent(by, errorMessage, timeoutInSeconds);
        element.clear();
        return element;
    }

    public WebElement waitForElementAndSendkeys(By by, String errorMessage, String value, long timeoutInSeconds) {
        WebElement element = waitForElementPresent(by, errorMessage, timeoutInSeconds);
        element.sendKeys(value);
        return element;
    }

    public boolean waitForElementNotPresent(By by, String errorMessage, long timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(errorMessage + "\n");
        return wait.until(
                ExpectedConditions.invisibilityOfElementLocated(by)
        );
    }

    public void assertElementHasGivenText(String errorMessage, long timeOutInSeconds, String text, int index) {
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        wait.withMessage(errorMessage);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_container' and @index=" + index + "]//*[@resource-id='org.wikipedia:id/page_list_item_title']")));
        WebElement element = driver.findElement(By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_container' and @index=" + index + "]//*[@resource-id='org.wikipedia:id/page_list_item_title']"));
        Assert.assertTrue("The expected button has not " + text + " text", element.getText().contains(text));
    }

    public void swipeUp(int timeInSeconds) {

        TouchAction action = new TouchAction(driver);

        Dimension size = driver.manage().window().getSize();
        int x = size.width / 2;

        int startY = (int) (size.height * 0.8);
        int endY = (int) (size.height * 0.2);


        action.press(x, startY).waitAction(timeInSeconds).moveTo(x, endY).release().perform();
    }

    public void swipeLeftFromRight(int timeInSeconds) {

        TouchAction action = new TouchAction(driver);

        Dimension size = driver.manage().window().getSize();
        int y = size.height / 2;

        int startX = (int) (size.width * 0.9);
        int endX = (int) (size.width * 0.1);


        action.press(startX, y).waitAction(timeInSeconds).moveTo(endX, y).release().perform();
    }

    public void swipeLeftFromRightQuick(){
        swipeLeftFromRight(200);
    }

    public void swipeUntilFindElement(By by, String erorrMessage, int maxSwipes) {
        int alreadySwiped = 0;

        while (driver.findElements(by).size() == 0) {
            if (alreadySwiped > maxSwipes) {
                waitForElementPresent(by, "Cannot find element by swiping left \n" + erorrMessage, 0);
                return;
            }
            swipeLeftFromRightQuick();
            ++alreadySwiped;
        }
    }

    public void swipeLeftFromRightY_80(int timeInSeconds){

        TouchAction action = new TouchAction(driver);

        Dimension size = driver.manage().window().getSize();
        int y = (int)(size.height * 0.8);

        int startX = (int) (size.width * 0.9);
        int endX = (int) (size.width * 0.1);


        action.press(startX, y).waitAction(timeInSeconds).moveTo(endX, y).release().perform();
    }

    public void swipeCategoryOnDashboardAndClick(By by, String errorMessage, int maxswipes){
        int alreadySwiped = 0;

        while (driver.findElements(by).size() == 0){
            if (alreadySwiped > maxswipes){
                waitForElementAndClick(by, "Can not found element by swiping \n" + errorMessage, 0);
                return;
            }
            swipeLeftFromRightY_80(300);
            ++alreadySwiped;
        }
    }



    public void swipeLeftFromRightByElement(By by, String errorMessage, long timeOutInSeconds) {

        WebElement element = waitForElementPresent(by,
                errorMessage,
                timeOutInSeconds);

        int left_x = element.getLocation().getX();
        int right_x = left_x + element.getSize().getWidth();
        int upper_y = element.getLocation().getY();
        int lower_y = upper_y + element.getSize().getHeight();
        int middle_y = (upper_y + lower_y) / 2;

        TouchAction action = new TouchAction(driver);
        action
                .press(right_x, middle_y)
                .waitAction(300)
                .moveTo(left_x, middle_y)
                .release()
                .perform();
    }

    public void swipeLeftFromRightUntilFindElement(By by,By byText, String erorrMessage, int maxSwipes) {
        int alreadySwiped = 0;

        while (driver.findElements(byText).size() == 0) {
            if (alreadySwiped > maxSwipes) {
                waitForElementPresent(byText, "Cannot find element by swiping left \n" + erorrMessage, 0);
                return;
            }
            swipeLeftFromRightByElement(by, "Can not find element by swiping", 5);
            ++alreadySwiped;
        }
    }



    public void assertElementPresent(By by, String titleOfArticle){

        WebElement element = driver.findElement(by);

        String titleText = element.getText();

        Assert.assertEquals("Article elements not equal", titleText, titleOfArticle);


    }

    public int getCountOfElements(By by) {
        List elements = driver.findElements(by);
        return elements.size();
    }

    public String waitForElementAndGetAttribute( By by, String attribute, String errorMessage, long timeOutInSeconds){
        WebElement element = waitForElementPresent(by, errorMessage, 5);
        return element.getAttribute(attribute);
    }

}
