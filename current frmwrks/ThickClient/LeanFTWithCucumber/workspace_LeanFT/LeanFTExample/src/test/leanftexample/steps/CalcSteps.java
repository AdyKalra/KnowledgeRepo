package test.leanftexample.steps;

import com.hp.lft.sdk.*;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import test.leanftexample.pages.CalculatorStandardView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

/**
 * Created by dsoxAndreas on 19/04/2016.
 */
public class CalcSteps {

    private CalculatorStandardView calc;

    @Given("I started the Calculator")
    public void IStartedTheCalculator() throws GeneralLeanFtException {
        calc = new CalculatorStandardView();
    }

    @When("^I add '(\\d+)' and '(\\d+)'$")
    public void i_add_x_and_y(int p0, int p1) throws Throwable {
        calc.AddNumbers(Arrays.asList(p0, p1));
    }

    @Then("^the result is '(\\d+)'$")
    public void the_result_is(String p0) throws Throwable {
        assertEquals(p0, calc.getResult());
    }

    @When("^I add the numbers '(\\d+)', '(\\d+)' and '(\\d+)'$")
    public void i_add_the_numbers_and(int p0, int p1, int p2) throws Throwable {
        calc.AddNumbers(Arrays.asList(p0, p1, p2));
    }

    @When("^I add all these numbers: '((?:\\d{1},)+\\d)'$")
    public void i_add_all_these_numbers(String p0) throws Throwable {
        List<Integer> numbers = Arrays.stream(p0.split(",")).map(o -> Integer.parseInt(o)).collect(Collectors.toList());
        calc.AddNumbers(numbers);
    }

}
