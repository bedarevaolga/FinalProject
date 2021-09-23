package steps;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/apisc.feature",
        glue = {"steps"},
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class RunnerTest {
}