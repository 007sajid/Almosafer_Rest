package tests;

import static io.restassured.config.LogConfig.logConfig;
import static io.restassured.config.RestAssuredConfig.newConfig;

import org.testng.annotations.BeforeMethod;

import actions.APIActions;
import actions.Assertions;
import endpoints.APIConstants;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import payload.Payload;

public class BaseTest {

	protected RequestSpecification spec;
	protected Assertions assertions = new Assertions();
	protected APIActions apiActions = new APIActions();
	protected Payload requestPayload = new Payload();

	@BeforeMethod

	protected void setUpConfiguration() {

		spec = new RequestSpecBuilder().setBaseUri(APIConstants.baseUrl)
				.setConfig(newConfig().logConfig(logConfig().blacklistHeader("Authorization")))
				.addHeader("x-authorization", APIConstants.token).setAccept("application/json")
				.setContentType("application/json").build().log().all();
	}
}
