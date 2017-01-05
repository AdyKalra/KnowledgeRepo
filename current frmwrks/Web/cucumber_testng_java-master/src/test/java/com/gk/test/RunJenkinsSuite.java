package com.gk.test;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;


@CucumberOptions(features = "src/test/resources", tags = "@gui,@api", monochrome = true, plugin = {
        "pretty", "html:target/cucumber-report/runjenkins",
        "json:target/cucumber-report/runjenkins/cucumber.json",
        "rerun:target/cucumber-report/runjenkins/rerun.txt"},
        glue = "com.gk.test")
public class RunJenkinsSuite extends AbstractTestNGCucumberTests {
}
