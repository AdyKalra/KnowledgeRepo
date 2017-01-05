package test.leanftexample;

import com.hp.lft.report.ReportException;
import com.hp.lft.report.Reporter;
import com.hp.lft.sdk.Desktop;
import com.hp.lft.sdk.GeneralLeanFtException;
import com.hp.lft.sdk.stdwin.Window;
import com.hp.lft.sdk.stdwin.WindowDescription;
import com.hp.lft.sdk.web.BrowserFactory;
import com.hp.lft.sdk.web.BrowserType;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

import java.io.IOException;

/**
 * Created by dsoxAndreas on 20/04/2016.
 */
public class Hooks {

    @Before("@web")
    public void beforeWeb(Scenario scenario) throws Exception {
        //the following will start a new test node in the report
        Reporter.startTest(scenario.getName());
        DriverFactory.startBrowser();
    }

    @After("@web")
    public void afterWeb() throws InterruptedException, ReportException {
        //the following ends the test node in the report
        DriverFactory.quitBrowser();
        Reporter.endTest();
    }

    @Before("@calc")
    public void BeforeCalc(Scenario scenario) throws IOException, InterruptedException, GeneralLeanFtException, ReportException {
        //the following will start a new test node in the report
        Reporter.startTest(scenario.getName());
        //Launch the Calculator application.
        DriverFactory.startWinApp("calc.exe");

    }

    @After("@calc")
    public void AfterCalc() throws ReportException {
        // Exit and close the Calculator.
        DriverFactory.quitWinApp();
        Reporter.endTest();
    }
}
