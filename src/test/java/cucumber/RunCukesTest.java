package cucumber;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"classpath:features"},
        glue = {"classpath:cucumber.stepdefs"},
        plugin = {
                "pretty",
                "html:build/reports/cucumber",
                "json:build/reports/cucumber-tests/test.json"}
)
public class RunCukesTest {
}
