package test.leanftexample.steps;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import com.hp.lft.sdk.*;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import test.leanftexample.DriverFactory;
import test.leanftexample.pages.GoogleSearchPage;
import test.leanftexample.pages.GoogleSearchResultsPage;

public class GoogleSteps {
	
	GoogleSearchPage searchPage;
	GoogleSearchResultsPage resultsPage;

	@Given("I am on the Google main page")
	public void IAmOnTheGoogleHomePage() throws GeneralLeanFtException {
		searchPage = new GoogleSearchPage(DriverFactory.getBrowser());
	}

	@When("I google '(.*)'")
	public void IGoogle(final String p0) throws Exception{
		resultsPage = searchPage.searchFor(p0);
	}

	@Then("the page title is '(.*)'")
	public void thePageTitleIs(String p0) throws Exception{
		assertThat(resultsPage.getTitle(), is(p0));
	}
	
}
