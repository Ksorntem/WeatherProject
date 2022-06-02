package tests;

import base.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.TenDayPage;

public class TenDayTest extends BaseTest {
    HomePage homePage;
    TenDayPage tenDayPage;

    @BeforeMethod
    public void localSetup(){

        homePage = new HomePage(getDriver());
        tenDayPage = new TenDayPage(getDriver());
    }
    @Test(testName = "T3 - getTempDetail", description = "Click to 10Day button and print out the detail")
    public void tempTenDayTest(){

        homePage.waitForElementVisibility(homePage.privacyTxt);
        homePage.closeBtn.click();
        homePage.click(homePage.tenDayBtn);
        tenDayPage.upBtn.click();

        for(int i = 0; i > tenDayPage.date.size(); i++){
            System.out.println(tenDayPage.date.get(i).getText()+ " - "+tenDayPage.tempDetail.get(i).getText()+ " - "
                    +tenDayPage.summaryDetail.get(i).getText());

        }
    }
}
