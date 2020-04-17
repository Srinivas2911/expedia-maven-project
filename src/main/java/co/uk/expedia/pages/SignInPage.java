package co.uk.expedia.pages;

/*
Created by SP
*/

import co.uk.expedia.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SignInPage extends Utility {
    By emailField = By.cssSelector("#gss-signin-email");
    By passwordField = By.xpath("//input[@id='gss-signin-password']");
    By signInSumbitBtn = By.xpath("//button[@id='gss-signin-submit']");
    By alertMessage = By.xpath("//h5[@class='alert-message']");
    By errorMessage = By.xpath("/html[1]/body[1]/div[12]/div[1]/div[1]/div[1]/div[2]/div[3]/div[2]/fieldset[1]/div[1]/div[1]/div[2]");

    public void enterEmailId (String email){
        //waitUntilVisibilityOfElementLocated(emailField, 90);
       clickOnElement(emailField);
        sendTextToElement(emailField, email);
    }

    public void enterPassword (String password){
        clickOnElement(passwordField);
        sendTextToElement(passwordField, password);
    }

    public void clickonSignInButton(){
        clickOnElement(signInSumbitBtn);
    }

    public String getAlertMessage (){
        verifyThatTextIsDisplayed(alertMessage,"You may have entered an unknown email address or an incorrect password." );
        return getTextFromElement(alertMessage);
    }

    public String getErrorMessage (){
        waitUntilVisibilityOfElementLocated(errorMessage, 90);
        verifyThatTextIsDisplayed(errorMessage,"You may have entered an unknown email address or an incorrect password." );
        return getTextFromElement(errorMessage);
    }

    public void ignoreCaptcha (){
        try {
            WebElement captcha = driver.findElement(By.xpath("//*[@id=\"rc-imageselect-target\"]/table/tbody/tr[1]/td[2]/div/div[1]/img"));
            captcha.clear();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
