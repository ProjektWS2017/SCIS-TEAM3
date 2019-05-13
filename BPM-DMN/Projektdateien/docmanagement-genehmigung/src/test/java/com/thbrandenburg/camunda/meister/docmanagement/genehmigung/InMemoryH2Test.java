package com.thbrandenburg.camunda.meister.docmanagement.genehmigung;

import java.sql.SQLException;

import org.apache.ibatis.logging.LogFactory;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.camunda.bpm.engine.test.ProcessEngineRule;
import org.camunda.bpm.extension.process_test_coverage.junit.rules.TestCoverageProcessEngineRuleBuilder;
import org.camunda.bpm.engine.test.Deployment;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;

import static org.camunda.bpm.engine.test.assertions.ProcessEngineTests.*;
import static org.junit.Assert.*;

/**
 * Test case starting an in-memory database-backed Process Engine.
 */
public class InMemoryH2Test {

  @ClassRule
  @Rule
  public static ProcessEngineRule rule = TestCoverageProcessEngineRuleBuilder.create().build();
    
  private static final String PROCESS_DEFINITION_KEY = "docmanagement-genehmigung";
  
  static {
    LogFactory.useSlf4jLogging(); // MyBatis
  }

  @Before
  public void setup() {
    init(rule.getProcessEngine());
  }

  /**
   * Just tests if the process definition is deployable.
   */
  @Test
  @Deployment(resources = "bpmnVorlesung2.bpmn")
  public void testParsingAndDeployment() throws SQLException {
    // nothing is done here, as we just want to check for exceptions during deployment
	  
	  ProcessInstance processInstance = processEngine().getRuntimeService().startProcessInstanceByKey(PROCESS_DEFINITION_KEY);
	  
	  
	  
	  //assertThat(processInstance).isEnded();

	  // To inspect the DB, run the following line in the debugger
	  // then connect your browser to: http://localhost:8082
	  // and enter the JDBC URL: jdbc:h2:mem:camunda
	  //org.h2.tools.Server.createWebServer("-web").start();
	
  }


}
