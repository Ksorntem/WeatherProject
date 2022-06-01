package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.WeakHashMap;

public class HomePage extends BasePage {

    protected WebDriver driver;

    public HomePage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

   @FindBy(xpath = "//p[@class='PrivacyDataNotice--mainParagraph--1nQsp']")
    public WebElement privacyTxt;

    @FindBy(name = "close")
    public WebElement closeBtn;
}
