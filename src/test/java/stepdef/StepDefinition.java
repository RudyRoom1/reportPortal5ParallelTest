package stepdef;

import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.BeforeStep;
import cucumber.api.java.en.And;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StepDefinition {
	
	private String scenDesc;
	Logger logger = LoggerFactory.getLogger(StepDefinition.class);


	@Before
	public void before(Scenario scenario) {
		this.scenDesc = scenario.getName();
	}
	
	@BeforeStep
	public void beforeStep() throws InterruptedException {
		Thread.sleep(2000);
	}
	
	@And("this is {string} step")
	public void step(String stepNum) {
		logger.info("Thread {} -> {} - {} STEP\n",Thread.currentThread().getId(), scenDesc, stepNum);
		System.out.format("Thread %2d -> %18s - %-6s STEP\n", Thread.currentThread().getId(), scenDesc, stepNum);
	}
}