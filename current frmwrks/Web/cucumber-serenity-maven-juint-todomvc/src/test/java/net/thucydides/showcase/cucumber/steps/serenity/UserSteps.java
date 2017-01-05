package net.thucydides.showcase.cucumber.steps.serenity;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import net.thucydides.showcase.cucumber.pages.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class UserSteps extends ScenarioSteps {

    HomePage homePage;

    @Step
    public void opens_home_page() {
        homePage.open();
    }

    @Step
    public void enters_an_item(String keyword) {
        homePage.enterSearchTerms(keyword);
        homePage.add();
    }

    @Step
    public void should_see_items_for() {
        assertThat(homePage.getCountInFooter(),greaterThan(0));
    }

    @Step
    public void edit_item(int arg1, String arg2) {
       homePage.editItem(arg1,arg2);
    }

    @Step
    public void match_result(int arg1, String arg2) {
        assertThat(homePage.getToDoText(1),is(arg2));
    }

}
