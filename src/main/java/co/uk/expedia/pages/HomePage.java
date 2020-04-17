package co.uk.expedia.pages;

/*
Created by SP
*/

import co.uk.expedia.utility.Utility;
import org.openqa.selenium.By;

public class HomePage extends Utility {

    By acceptBtn = By.xpath("//span[@class='button-text']");

    By accountMenuTab = By.xpath("//button[@id='header-account-menu']");
    By signInBtn = By.xpath("//button[@id='header-account-signin-button']");
    By flightsLink = By.xpath("//a[@id='primary-header-flight']");
    By flightsTab = By.xpath("//span[contains(text(),'Flights')]");

public void clickOnAcceptTab (){
    clickOnElement(acceptBtn);
}

    public void clickonAccountTab() {
        clickOnElement(accountMenuTab);
    }
    public void clickOnSignInTab() {
        mouseHoverToElementAndClick(signInBtn);
    }

    public void clickOnFlightsTab(){
        clickOnElement(flightsTab);
    }
}
