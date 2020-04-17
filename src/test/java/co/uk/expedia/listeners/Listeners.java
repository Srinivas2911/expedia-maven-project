package co.uk.expedia.listeners;

/*
Created by SP
*/

import co.uk.expedia.utility.Utility;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class Listeners implements ITestListener {

    @Override
    public void onTestStart(ITestResult iTestResult) {
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
// This simple method stores screenshot in under Utility
        System.out.println("My Test passed "+iTestResult.getName());
        Utility.takeScreenShot();
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
// This method stores screenshots in designated folder : screenshots
        String screenshotName = Utility.takeScreenShot(iTestResult.getName());
        System.setProperty("org.uncommons.reportng.escape-output", "false");
        Reporter.log("Click to see screenshot");
        Reporter.log("<a target = \"_blank\" href="+screenshotName+">Screenshot</a>");
        Reporter.log("<br>");
        Reporter.log("<br>");
        Reporter.log("<a target = \"_blank\" href="+screenshotName+"><img src="+screenshotName+" height=200 width=200></img></a>");
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
    }

    @Override
    public void onStart(ITestContext iTestContext) {
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
    }
}
