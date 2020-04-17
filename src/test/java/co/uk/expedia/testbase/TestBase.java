package co.uk.expedia.testbase;

/*
Created by SP
*/

import co.uk.expedia.basepage.BasePage;
import co.uk.expedia.browserselector.BrowserSelector;
import co.uk.expedia.loadproperty.LoadProperty;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class TestBase extends BasePage {
    //Object created for Browser Selector for choosing browser and running the browser
// Object for Load Property for calling the browser and URL

    BrowserSelector browserSelector = new BrowserSelector();
    LoadProperty loadProperty = new LoadProperty();

    String baseUrl = loadProperty.getProperty("baseUrl");
    String browser = loadProperty.getProperty("browser");


    @BeforeMethod(groups = {"sanity", "smoke", "regression"})
    public void openBrowser() {
        browserSelector.selectBrowser(browser);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        driver.get(baseUrl);
    }

    @AfterMethod(groups = {"sanity", "smoke", "regression"})
    public void tearDown() {
        driver.quit();
    }

}
