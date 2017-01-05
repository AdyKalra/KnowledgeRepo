package test.leanftexample.pages;

import com.hp.lft.sdk.GeneralLeanFtException;
import com.hp.lft.sdk.web.Browser;

/**
 * Created by dsoxAndreas on 20/04/2016.
 */
public class GoogleSearchResultsPage {

    private Browser browser;

    public GoogleSearchResultsPage(Browser browser) {
        this.browser = browser;
    }

    public String getTitle() throws GeneralLeanFtException {
        return browser.getTitle();
    }
}
