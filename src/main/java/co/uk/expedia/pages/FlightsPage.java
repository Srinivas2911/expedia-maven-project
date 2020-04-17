package co.uk.expedia.pages;

/*
Created by SP
*/

import co.uk.expedia.utility.Utility;
import org.openqa.selenium.By;

public class FlightsPage extends Utility {

    By flightFromField = By.xpath("//input[@id='flight-origin-hp-flight']");
    By flightToField = By.xpath("//input[@id='flight-destination-hp-flight']");
    By departDate = By.xpath("//input[@id='flight-departing-hp-flight']");
    By returnJourneyDate = By.xpath("//input[@id='flight-returning-hp-flight']");
    By travellersField = By.xpath("//div[@class='menu-bar gcw-travel-selector-wrapper']//button[@class='trigger-utility menu-trigger btn-utility btn-secondary dropdown-toggle theme-standard pin-left menu-arrow gcw-component gcw-traveler-amount-select gcw-component-initialized']");

    By addNoOfTravButton = By.xpath("//body[contains(@class,'')]/meso-native-marquee/section[@id='WizardHero']/div[@id='hero-banner']/div[contains(@class,'hero-banner-gradient native-marquee')]/div[contains(@class,'cols-row hero-banner-inner')]/section[@id='wizardSection']/div[contains(@class,'hero-banner-box siteId-3 cf hideClassicDcol')]/div[@id='wizard-tabs']/div[contains(@class,'tabs-container col')]/section[@id='section-flight-tab-hp']/form[@id='gcw-flights-form-hp-flight']/fieldset[contains(@class,'room-data')]/div[contains(@class,'cols-nested')]/div[contains(@class,'ab25184-traveler-wrapper-flight available-for-flights gcw-clear-both')]/div[@id='traveler-selector-hp-flight']/div[contains(@class,'menu-bar gcw-travel-selector-wrapper')]/ul[contains(@class,'menu-bar-inner')]/li[contains(@class,'open')]/div[contains(@class,'menu sticky gcw-menu')]/div[contains(@class,'menu-main')]/div[contains(@class,'traveler-selector-sinlge-room-data traveler-selector-room-data')]/div[contains(@class,'uitk-grid step-input-outside gcw-component gcw-component-step-input gcw-step-input gcw-component-initialized')]/div[contains(@class,'uitk-col all-col-shrink')]/button[contains(@class,'uitk-step-input-button uitk-step-input-plus')]/span[1]//*[local-name()='svg']");
    By closeLink = By.xpath("//li[contains(@class,'open')]//button[contains(@class,'close btn-text')]");
    By searchButton = By.xpath("//form[@id='gcw-flights-form-hp-flight']//button[contains(@class,'btn-primary btn-action gcw-submit')]");

    By getSameDestinationText = By.xpath("//span[@class='title-city-text']");

    By flightModule = By.xpath("//ul[@id='flightModuleList']");
    By flightModuleList = By.cssSelector("#flightModuleList");
    By forwardDateBtn = By.xpath("//button[contains(@class,'datepicker-paging datepicker-next btn-paging btn-secondary next')]");

    public void enterFlightFromOriginCity(String flyingfrom) {
        sendTextToElement(flightFromField, flyingfrom);
        sendTabAndEnterKey(flightToField);
    }

    public void enterFlightToDestinationCity(String flyingTo) {
        sendTextToElement(flightToField, flyingTo);
        sendTabAndEnterKey(flightToField);
    }

    public void enterOutboundDateOfTravel(String flyoutDate) {
        sendTextToElement(departDate, flyoutDate);
        sendTabAndEnterKey(departDate);
    }

    public void enterReturnDateOfTravel(String returnDate) {
        clearTextFromField(returnJourneyDate);
        sendTextToElement(returnJourneyDate, returnDate);
        sendTabAndEnterKey(returnJourneyDate);
    }

    public void clickOnTravellers() {
        waitUntilElementToBeClickable(travellersField, 50);
        clickOnElement(travellersField);
    }

    public void addTwoAdultTravellersAndClose() {
        clickOnElement(addNoOfTravButton);
//        clickOnElement(addNoOfTravButton);
        clickOnElement(closeLink);
    }

    public void clickOnSearchButton() {
        clickOnElement(searchButton);
    }

    public String getSameDestinationTextMessage() {
        waitUntilVisibilityOfElementLocated(getSameDestinationText, 50);
        return getTextFromElement(getSameDestinationText);
    }

    public String verifyBodyTextContainsDestinationName() {
        String bodyText = driver.findElement(By.tagName("body")).getText();
        //String bodyText = driver.findElement(By.cssSelector("#flightModuleList")).getText();
        return bodyText;
    }
}
