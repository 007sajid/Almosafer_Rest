package tests;

import org.testng.annotations.Test;
import static org.hamcrest.Matchers.lessThan;
import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import endpoints.APIConstants;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.RestAssured;


public class GetFlight extends BaseTest {
	/*
	 * This test is a basic demonstration that how simple Automation can get. 
	 * This test hits an API with required URL takes the response and verify the response
	 * All in one line of code. Thanks to RestAssured library.
	*/
	private static Logger Log = LogManager.getLogger(GetFlight.class.getName());

	@Test()
	@Owner("Sajid")
	@Severity(SeverityLevel.NORMAL)
	@Description("Verify that Status code is 200 when we get Flights from two cities")
	public void testGetFlights() {

		RestAssured.given().
					spec(spec).
					when().
					get(APIConstants.getFlight).then().
					log().
					all().
					assertThat().
					statusCode(200).
					time(lessThan(5L), TimeUnit.SECONDS);
		
		Log.info("Ran Successfully");
		
	}

}
