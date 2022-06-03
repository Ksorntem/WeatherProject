package tests;

import base.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.TenDayPage;

import java.util.List;

public class TenDayTest extends BaseTest {
    HomePage homePage;
    TenDayPage tenDayPage;

    @BeforeMethod
    public void localSetup(){

        homePage = new HomePage(getDriver());
        tenDayPage = new TenDayPage(getDriver());
    }
    @Test(testName = "T5 - getTempDetail", description = "Click to 10Day button and print out the detail")
    public void tempTenDayTest(){

        homePage.click(homePage.closeBtn);
        homePage.click(homePage.tenDayBtn);
        tenDayPage.upBtn.click();
        extentManager.logScreenshot();

        List<WebElement> dateList = tenDayPage.date;
        List<WebElement> temDetailList = tenDayPage.tempDetail;
        List<WebElement> summaryDetailList = tenDayPage.summaryDetail;

        for(int i = 0; i < dateList.size(); i++){
            System.out.println(dateList.get(i).getText()+ " - " +temDetailList.get(i).getText()+ " - "
                    +summaryDetailList.get(i).getText());

        }
    }
}
