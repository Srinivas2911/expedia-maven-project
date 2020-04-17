package co.uk.expedia.testsuite;

/*
Created by SP
*/

import co.uk.expedia.pages.AccountPage;
import co.uk.expedia.pages.HomePage;
import co.uk.expedia.pages.SignInPage;
import co.uk.expedia.testbase.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

/*
baseURL:https://www.expedia.co.uk/
        Create the page object model with everything like Listeners, XML file, properties.
        create the pages
        1.HomePage
        2.AccountPage
        3.SignInPage
        4.FlightsPage

        Create the test classes in testsuite
        1.LoginTest - enter invalid username and password and click on sign in tab and verify error message.
*/

public class LoginTest extends TestBase {
    HomePage hp = new HomePage();
    SignInPage sip = new SignInPage();
    AccountPage ap = new AccountPage();
    SoftAssert sa = new SoftAssert();

    String email = "Roger@gmail.com";
    String password = "Roger123";

    @Test (priority = 0, groups = { "regression"})
    public void verifyErrorMessageIsDisplayed() {
        hp.clickOnAcceptTab();
        hp.clickonAccountTab();
        hp.clickOnSignInTab();
        sip.enterEmailId(email);
        sip.enterPassword(password);
        sip.clickonSignInButton();
        //sip.ignoreCaptcha();
        System.out.println(sip.getErrorMessage());
        sa.assertTrue(sip.getErrorMessage().contains("You may have entered an unknown email address or an incorrect password"));
        sa.assertAll();

    }
}
