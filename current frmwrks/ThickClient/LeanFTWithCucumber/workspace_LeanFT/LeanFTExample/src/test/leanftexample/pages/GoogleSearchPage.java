package test.leanftexample.pages;

import com.hp.lft.sdk.GeneralLeanFtException;
import com.hp.lft.sdk.WaitUntilTestObjectState;
import com.hp.lft.sdk.web.*;

/**
 * Created by dsoxAndreas on 20/04/2016.
 */
public class GoogleSearchPage {

    private Browser browser;

    public GoogleSearchPage(Browser browser) throws GeneralLeanFtException {
        browser.navigate("http://www.google.com/");
        browser.sync();
        this.browser = browser;
    }

    public GoogleSearchResultsPage searchFor(String p0) throws GeneralLeanFtException {
        EditField searchField = browser.describe(
                EditField.class,
                new EditFieldDescription.Builder().name("q").title("Search").build());

        // Set keyword value in Search Field
        searchField.setValue(p0);
        // Click on Search button - shortcut way
        browser.describe(Button.class, new ButtonDescription.Builder()
                .buttonType("submit").tagName("INPUT").name("Google Search").build()).click();
        browser.sync();
        browser.describe(WebElement.class, new WebElementDescription.Builder()
                .cssSelector("h3 > a").index(0).build()).click();
        browser.sync();
        // Wait for Browser title to change
        WaitUntilTestObjectState.waitUntil(browser,
                new WaitUntilTestObjectState.WaitUntilEvaluator<Browser>() {
                    public boolean evaluate(Browser browser) {
                        try {
                            browser.sync();
                            return browser.getTitle().contains(p0);
                        } catch (GeneralLeanFtException e) {
                            // TODO Auto-generated catch block
                            return false;
                        }
                    }
                },10000);
        return new GoogleSearchResultsPage(browser);
    }
}
