package base;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

public class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void sleep(Long milliSeconds) {
        try {
            Thread.sleep(milliSeconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void click(WebElement element) {
        moveIntoView(element);
        waitForElementClickability(element);
        element.click();
    }

    public String getText(WebElement element) {
        moveIntoView(element);
        waitForElementVisibility(element);
        return element.getText();
    }

    public void waitForElementClickability(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForElementVisibility(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void moveIntoView(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void swichToNextWindow(WebElement element) {
        String mainWindowID = driver.getWindowHandle();
        Set<String> allWindows = driver.getWindowHandles();

        for (String each : allWindows) {
            driver.switchTo().window(each);
            if (driver.getTitle().contains("Facebook")) {
                System.out.println(driver.getTitle());
            } else if (driver.getTitle().contains("Twitter")) {
                System.out.println(driver.getTitle());
            } else if (driver.getTitle().contains("YouTube")) {
                System.out.println(driver.getTitle());
            }
        }

        driver.switchTo().window(mainWindowID);

    }
}
