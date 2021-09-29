package api.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.jupiter.api.Tag;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/apisc.feature",
        glue = {"api.steps"},
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
@Tag("RunnerApi")
public class RunnerTest {
}