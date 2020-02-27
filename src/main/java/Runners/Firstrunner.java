package Runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;



@RunWith(Cucumber.class)
@CucumberOptions(
        strict = true,
        features= {"C:\\Users\\gmt\\selenium-base-framework\\src\\test\\java\\Features"},
        glue={"stepdefinitions"},
        plugin = {"json:/target/cucumber-reports/CucumberTestReport.json"}


)
public class Firstrunner {



}
