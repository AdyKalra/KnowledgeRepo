package test.leanftexample;

import com.hp.lft.sdk.Desktop;
import com.hp.lft.sdk.GeneralLeanFtException;
import com.hp.lft.sdk.stdwin.Window;
import com.hp.lft.sdk.stdwin.WindowDescription;
import com.hp.lft.sdk.web.Browser;
import com.hp.lft.sdk.web.BrowserFactory;
import com.hp.lft.sdk.web.BrowserType;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Created by dsoxAndreas on 20/04/2016.
 */
public class DriverFactory {

    private static Browser browser;
    private static Process winApp;

    private DriverFactory(){}

    public static Browser startBrowser() throws GeneralLeanFtException, IOException {
        if (browser == null)
            createNewBrowserInstance();
        return browser;
    }

    private static void createNewBrowserInstance() throws GeneralLeanFtException {
        // Open Internet Explorer Browser
        browser = BrowserFactory.launch(BrowserType.INTERNET_EXPLORER);
    }

    public static Browser getBrowser() {
        return browser;
    }

    public static void quitBrowser() {
        try {
            browser.close();
        } catch (GeneralLeanFtException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        browser = null;
    }

    public static Process startWinApp(String s) throws IOException, InterruptedException {
        if (winApp == null)
            createNewWinAppInstance(s);
        return winApp;
    }

    private static void createNewWinAppInstance(String s) throws IOException, InterruptedException {
        winApp = new ProcessBuilder("C:\\Windows\\System32\\" + s).start();
        // Pause to ensure Calculator has fully opened on the computer.
        Thread.sleep(4 * 1000);
    }

    public static void quitWinApp() {
        winApp.destroy();
        winApp = null;
    }
}
