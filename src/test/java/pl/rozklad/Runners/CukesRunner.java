package pl.rozklad.Runners;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"json:target/cucumber.json",
                "html:target/default-html-reports",
                "rerun:target/rerun.txt"},
        features = "src/test/resources/Features",
        glue = "pl/rozklad/Steps",
        dryRun =false,
        tags = "@wip"

        /*
           NOTE: This webpage has critical bugs bigger than major which effects many functions,
           its not working stable, my test %95 passed but sometimes with the same values failed
           which can not be figured out. I used dynamic waits mostly according to my internet speed.
           Tests are effect by many situation even from test environment.

           It was pleasure to work on this case, I have learned many city names :)
           Thank you, regards.

        */

)
public class CukesRunner {
}
