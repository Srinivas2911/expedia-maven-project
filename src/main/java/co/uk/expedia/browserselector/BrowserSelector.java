package co.uk.expedia.browserselector;

/*
Created by SP
*/

import co.uk.expedia.basepage.BasePage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserSelector extends BasePage {

    /* projectPath as String is assigned for all project to choose local user directory
     * thru the ("user*dir")
     * Browser selector extends to BasePage in search of the Webdriver
     */
    String projectPath =System.getProperty("user.dir");

    /* if else method is provided to select a browser
     * choose any browser between chrome, firefox or internet explorer
     * else offer a wrong name
     */

    public void selectBrowser (String browser){
        if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chromedriver.exe");
            driver = new ChromeDriver();
        }else if (browser.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", projectPath + "/drivers/geckodriver.exe");
            driver = new FirefoxDriver();
        }else if (browser.equalsIgnoreCase("ie")){
            System.setProperty("webdriver.ie.driver", projectPath + "/drivers/IEDriverServer.exe");
            driver = new InternetExplorerDriver();
        }else {
            System.out.println("Wrong browser name");
        }
    }

}
