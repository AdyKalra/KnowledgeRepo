package com.gk.test;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;


@CucumberOptions(features = "src/test/resources", monochrome = true, tags = "@gui", plugin = {
        "pretty", "html:target/cucumber-report/single",
        "json:target/cucumber-report/single/cucumber.json",
        "rerun:target/cucumber-report/single/rerun.txt"},
        glue = "com.gk.test")
public class RunSingleSuite extends AbstractTestNGCucumberTests {
}
