package lib.ui;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.regex.Pattern;

public class MainPageObject {

    protected AppiumDriver driver;


    public MainPageObject(AppiumDriver driver)
    {
        this.driver = driver;
    }


    public WebElement waitForElementPresent(String locator, String errorMessage, long timeoutInSeconds) {

        By by = this.getLocatorByString(locator);
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(errorMessage);
        return wait.until(
                ExpectedConditions.presenceOfElementLocated(by)
        );
    }

    public void waitForSearchElementPresentByText(String locator,String text, String errorMessage, long timeoutInSeconds) {
        By by = this.getLocatorByString(locator);
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(errorMessage);
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(by));
        String elementText = element.getText().toLowerCase();
        Assert.assertTrue(elementText.contains(text));

    }

    public WebElement waitForElementAndClick(String locator, String errorMessage, long timeoutInSeconds) {
        WebElement element = waitForElementPresent(locator, errorMessage, timeoutInSeconds);
        element.click();
        return element;
    }

    public WebElement waitForElementAndClear(String locator, String errorMessage, long timeoutInSeconds) {
        WebElement element = waitForElementPresent(locator, errorMessage, timeoutInSeconds);
        element.clear();
        return element;
    }

    public WebElement waitForElementAndSendkeys(String locator, String errorMessage, String value, long timeoutInSeconds) {
        WebElement element = waitForElementPresent(locator, errorMessage, timeoutInSeconds);
        element.sendKeys(value);
        return element;
    }

    public boolean waitForElementNotPresent(String locator, String errorMessage, long timeoutInSeconds) {
        By by = this.getLocatorByString(locator);
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(errorMessage + "\n");
        return wait.until(
                ExpectedConditions.invisibilityOfElementLocated(by)
        );
    }


    public void swipeUp(int timeInSeconds) {

        TouchAction action = new TouchAction(driver);

        Dimension size = driver.manage().window().getSize();
        int x = size.width / 2;

        int startY = (int) (size.height * 0.8);
        int endY = (int) (size.height * 0.2);


        action
                .press(PointOption.point(x, startY))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(timeInSeconds)))
                .moveTo(PointOption.point(x, endY))
                .release()
                .perform();
    }

    public void swipeLeftFromRight(int timeInSeconds) {

        TouchAction action = new TouchAction(driver);

        Dimension size = driver.manage().window().getSize();
        int y = size.height / 2;

        int startX = (int) (size.width * 0.9);
        int endX = (int) (size.width * 0.1);


        action
                .press(PointOption.point(startX, y))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(timeInSeconds)))
                .moveTo(PointOption.point(endX, y))
                .release()
                .perform();
    }

    public void swipeLeftFromRightQuick(){
        swipeLeftFromRight(200);
    }

    public void swipeUntilFindElement(String locator, String erorrMessage, int maxSwipes) {
        int alreadySwiped = 0;
        By by = this.getLocatorByString(locator);
        while (driver.findElements(by).size() == 0) {
            if (alreadySwiped > maxSwipes) {
                waitForElementPresent(locator, "Cannot find element by swiping left \n" + erorrMessage, 0);
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


        action
                .press(PointOption.point(startX, y))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(timeInSeconds)))
                .moveTo(PointOption.point(endX, y))
                .release()
                .perform();
    }

    public void swipeCategoryOnDashboardAndClick(String locator, String errorMessage, int maxswipes){
        int alreadySwiped = 0;
        By by = this.getLocatorByString(locator);
        while (driver.findElements(by).size() == 0){
            if (alreadySwiped > maxswipes){
                waitForElementAndClick(locator, "Can not found element by swiping \n" + errorMessage, 0);
                return;
            }
            swipeLeftFromRightY_80(300);
            ++alreadySwiped;
        }
    }



    public void swipeLeftFromRightByElement(String locator, String errorMessage, long timeOutInSeconds) {

        WebElement element = waitForElementPresent(locator,
                errorMessage,
                timeOutInSeconds);

        int left_x = element.getLocation().getX();
        int right_x = left_x + element.getSize().getWidth();
        int upper_y = element.getLocation().getY();
        int lower_y = upper_y + element.getSize().getHeight();
        int middle_y = (upper_y + lower_y) / 2;

        TouchAction action = new TouchAction(driver);
        action
                .press(PointOption.point(right_x - 10, middle_y))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(8000)))
                .moveTo(PointOption.point(left_x + 10, middle_y))
                .release()
                .perform();
    }

    public void swipeLeftFromRightUntilFindElement(String locator, String searchElement, String erorrMessage, int maxSwipes) {
        int alreadySwiped = 0;
        By by = this.getLocatorByString(searchElement);
        while (driver.findElements(by).size() == 0) {
            if (alreadySwiped > maxSwipes) {
                waitForElementPresent(searchElement, "Cannot find element by swiping left \n" + erorrMessage, 0);
                return;
            }
            swipeLeftFromRightByElement(locator, "Can not find element by swiping", 5);
            ++alreadySwiped;
        }
    }


    public int getCountOfElements(String locator) {
        By by = this.getLocatorByString(locator);
        List elements = driver.findElements(by);
        return elements.size();
    }

    public String waitForElementAndGetAttribute(String locator, String attribute, String errorMessage, long timeOutInSeconds){
        WebElement element = waitForElementPresent(locator, errorMessage, 5);
        return element.getAttribute(attribute);
    }

    private By getLocatorByString(String locatorWithType){
        String[] explodedLocator = locatorWithType.split(Pattern.quote(":"),2);
        String byType = explodedLocator[0];
        String locator = explodedLocator[1];

        if (byType.equals("xpath")){
            return By.xpath(locator);
        }else if (byType.equals("id")){
            return By.id(locator);
        }else {
            throw new  IllegalArgumentException("Can not get type of locator. Locator " + locatorWithType);
        }
    }

}
