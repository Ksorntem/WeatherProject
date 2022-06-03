package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import utils.SeleniumUtils;

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

    @Test(testName = "T2 - Test social media buttons - Facebook",description = "Verify Facebook titile")
    public void facebookTest(){
        homePage.click(homePage.closeBtn);
        homePage.click(homePage.facebookBtn);
        String actualTitle = SeleniumUtils.switchToWindowAndVerifyTitle(getDriver(), extentManager);

        Assert.assertEquals(actualTitle, "The Weather Channel - Home | Facebook");
    }

    @Test(testName = "T3 - Test social media buttons - Twitter",description = "Verify Twitter titile")
    public void test03(){
        homePage.click(homePage.twitterBtn);
        homePage.click(homePage.closeBtn);
        homePage.click(homePage.twitterBtn);
        String actualTitle = SeleniumUtils.switchToWindowAndVerifyTitle(getDriver(), extentManager);

        Assert.assertEquals(actualTitle, "The Weather Channel (@weatherchannel) / Twitter");
    }

    @Test(testName = "T4 - Test social media buttons - Youtube",description = "Verify Youtube titile")
    public void test04(){
        homePage.click(homePage.youtubeBtn);
        homePage.click(homePage.closeBtn);
        homePage.click(homePage.youtubeBtn);
        String actualTitle = SeleniumUtils.switchToWindowAndVerifyTitle(getDriver(), extentManager);

        Assert.assertEquals(actualTitle, "The Weather Channel - YouTube");
    }
}
