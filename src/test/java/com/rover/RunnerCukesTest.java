package com.rover;


import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        dryRun = false,
        monochrome = true,
        features = ("src/test/resources"),
        glue = "com.rover.steps",
        plugin = {
                "pretty",
                "html:reports/cucumber/cucmberTestReport-html",
                "json:reports/cucumber/cucmberTestReportJson.json",
                "junit:reports/cucumber/cucmberTestReportJunit-xml.xml"},
        strict = false,
        snippets = SnippetType.CAMELCASE
)
public class RunnerCukesTest {
}
