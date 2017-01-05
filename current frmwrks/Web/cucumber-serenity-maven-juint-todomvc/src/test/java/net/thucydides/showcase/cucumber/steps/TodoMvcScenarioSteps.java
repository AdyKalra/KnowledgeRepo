package net.thucydides.showcase.cucumber.steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import net.thucydides.showcase.cucumber.steps.serenity.UserSteps;

public class TodoMvcScenarioSteps {

    @Steps
    UserSteps user;

    @Given("^I am on the todomvc page$")
    public void I_am_on_the_todomvc_page() throws Throwable {
        user.opens_home_page();
    }

    @When("^I enter an '(.*)'$")
    public void I_enter_an_item(String keyword) throws Throwable {
        user.enters_an_item(keyword);
    }


    @Then("^I should see the count increased$")
    public void I_should_see_item_on_the_results_page() throws Throwable {
        user.should_see_items_for();

    }

    @When("^I edit an '(.*)' to '(.*)'$")
    public void i_edit_an_item_to_item(int arg1, String arg2) throws Throwable {
        user.edit_item(arg1,arg2);
    }

    @Then("^I should see '(.*)' edited to '(.*)' on the results page$")
    public void i_should_see_item_edited_on_the_results_page(int arg1, String arg2) throws Throwable {
        user.match_result(arg1,arg2);
    }

    @When("^I change the status$")
    public void i_change_the_status() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^I should see 'item(\\d+)' changed to completed$")
    public void i_should_see_item_changed_to_completed(int arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^I should see 'item(\\d+)' reactivated$")
    public void i_should_see_item_reactivated(int arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Given("^I am on the todomvc page and 'completed' is selected$")
    public void i_am_on_the_todomvc_page_and_completed_is_selected() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^I activate all active todos$")
    public void i_activate_all_active_todos() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^I delete the 'item(\\d+)'$")
    public void i_delete_the_item(int arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^the 'item(\\d+)' should not be visible$")
    public void the_item_should_not_be_visible(int arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^I clear all completed$")
    public void i_clear_all_completed() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^the results page should have no items$")
    public void the_results_page_should_have_no_items() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }



}
