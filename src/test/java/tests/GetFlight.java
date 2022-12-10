package tests;

import org.testng.annotations.Test;
import static org.hamcrest.Matchers.lessThan;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import endpoints.APIConstants;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import utils.DataUtils;

public class GetFlight extends BaseTest {

	private static Logger Log = LogManager.getLogger(GetFlight.class.getName());

	@Test()
	@Owner("Sajid")
	@Severity(SeverityLevel.NORMAL)
	@Description("Verify that Status code is 200 when we get Flights from two cities")
	public void testGetFlights() {

		System.out.println(DataUtils.getTestData("TestData", "Token", "Value"));
		RestAssured.given().
					spec(spec).
					when().
					get(APIConstants.getFlight).then().
					log().
					all().
					assertThat().
					statusCode(200).
					time(lessThan(5L), TimeUnit.SECONDS);
		

		
	}

}
