package runners;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"classpath:features"},
        plugin = {"pretty","html:target/site/cucumber-pretty","json:target/cucumber.json"}
        //      dryRun = true,
        //monochrome = true
)
public class CucumberTest  {
}
