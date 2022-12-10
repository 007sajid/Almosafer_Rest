package tests;

import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import endpoints.APIConstants;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class PostPricePolicy extends BaseTest {
	
	/*
	 * This test is created in another way than the Getflight.java one. 
	 * This test has separate assertions to it. 
	 * Check in and Check out dates are coming from a file at the moment
	 * But we can change it to variables or from API responses as per our needs.
	 */

	private static Logger Log = LogManager.getLogger(PostPricePolicy.class.getName());
	String expected,checkIn,checkOut;
	@Test()
	@Owner("Sajid")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Verify that Status code is 200 when we try to check policy of coming dates")
	public void postPricePolicy() {
		
		Response response = RestAssured.given().spec(spec).when().
				body(requestPayload.createPayLoad(APIConstants.checkIn,APIConstants.checkOut)).
				post(APIConstants.postPricePolicy);
		
		
		  expected = apiActions.getDataFromJsonPath(response, "unitPriceDetails.currency");
		  
		  assertions.verifyResponseBody(expected,"SAR","Verify currency name");
		  assertions.verifyStatusCode(response);
		  assertions.verifyResponseBody((float)apiActions.getDataFromJsonPath(response, "unitPriceDetails.totalPrice"), 2150.0, "Verify Total Price");
		  assertions.verifyResponseBody((boolean)apiActions.getDataFromJsonPath(response, "unitPriceDetails.hostPreApprovalRequired"), false, "Verify Total Price");
		  
		  Log.info("Test ran successfully.");
		  Log.error("Error appeared.");
		  
		  
}
	@Test()
	@Owner("Sajid")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Verify that Status code is 400 when we try to check policy of previous dates")
	public void postPricePolicyOldDate() {
		
		checkIn="2022-12-09";
		checkOut= "2022-12-10";
		
		Response response = RestAssured.given().
				spec(spec).
				when().
				body(requestPayload.createPayLoad(checkIn,checkOut)).
				post(APIConstants.postPricePolicy);
		 
		assertions.verifyBadRequest(response);
		Log.info("Test ran successfully.");
		  Log.error("Error appeared.");  
		  
		  
}


}
