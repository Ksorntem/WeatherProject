package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class TenDayPage extends BasePage {

    protected WebDriver driver;

    public TenDayPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "caret-up")
    public WebElement upBtn;

    @FindBy(xpath = "div[@data-testid='DetailsSummary']/h3")
    public List<WebElement> date;

    @FindBy(xpath = "div[@data-testid='DetailsSummary']/div[@data-testid='detailsTemperature']")
    public List<WebElement> tempDetail;

    @FindBy(xpath = "div[@data-testid='DetailsSummary']/div/span[@class='DetailsSummary--extendedData--365A_']")
    public List<WebElement> summaryDetail;

}
