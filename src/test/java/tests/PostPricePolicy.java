package tests;

import org.testng.annotations.Test;
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

public class PostPricePolicy extends BaseTest {

	private static Logger Log = LogManager.getLogger(PostPricePolicy.class.getName());
	String expected,checkIn,checkOut;
	@Test()
	@Owner("Sajid")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Verify that Status code is 200 when we try to check policy of coming dates")
	public void postPricePolicy() {
		
		checkIn="2022-12-15";
		checkOut= "2022-12-16";
		
		Response response = RestAssured.given().spec(spec).when().body(requestPayload.createPayLoad(APIConstants.checkIn,APIConstants.checkOut))
				.post(APIConstants.postPricePolicy);
		
		
		  expected = apiActions.getDataFromJsonPath(response, "unitPriceDetails.currency");
		  
		  assertions.verifyResponseBody(expected,"SAR","Verify currency name");
		  assertions.verifyStatusCode(response);
		  
		  
		  
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
		  
		  
		  
}


}
