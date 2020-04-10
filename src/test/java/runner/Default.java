package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(glue = "stepdef",
    plugin = {
    "pretty", "com.epam.reportportal.cucumber.ScenarioReporter",
    },
    features = "src/test/resources/features/")
public class Default {

  private static long duration;

  @BeforeClass
  public static void before() {
    duration = System.currentTimeMillis();
    System.out.println("Thread Id  | Scenario Num       | Step Count");
  }

  @AfterClass
  public static void after() {
    duration = System.currentTimeMillis() - duration;
    System.out.println("DURATION - " + duration);
  }
}
