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
    @Test
    public void tempTest(){

        homePage.click(homePage.tenDayBtn);
        tenDayPage.upBtn.click();

    }
}
