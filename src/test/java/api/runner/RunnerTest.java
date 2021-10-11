package api.runner;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/apisc.feature",
        glue = {"api.steps"},
        snippets = CucumberOptions.SnippetType.CAMELCASE
        )

public class RunnerTest {
}