package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;

public class HomeTest extends BaseTest {
    HomePage homePage;

    @BeforeMethod
    public void localSetup(){

        homePage = new HomePage(getDriver());

    }

    @Test(testName = "T1 - PopUp text",description = "Get the the text of the pop-up window")
    public void popUpTest(){

        homePage.waitForElementVisibility(homePage.privacyTxt);
        System.out.println(homePage.privacyTxt.getText());
        Assert.assertTrue(homePage.privacyTxt.isDisplayed());
        homePage.closeBtn.click();

    }

    @Test(testName = "T2 - GetTitle",description = "Print out titles of all 3 pages")
    public void getTitleTest(){

        homePage.click(homePage.facebook);
        homePage.click(homePage.twitter);
        homePage.click(homePage.youtube);

        homePage.swichToNextWindow(homePage.facebook);

        Assert.assertEquals(getDriver().getTitle(), "The Weather Channel - Home | Facebook");

    }
}
