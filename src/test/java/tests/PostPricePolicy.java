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

	@Test()
	@Owner("Sajid")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Verify that Status code is 200 when we Create a new GitHub RequestPayloads of User")
	public void postPricePolicy() {
		Response response = RestAssured.given().spec(spec).when().body(requestPayload.createPayLoad())
				.post(APIConstants.postPricePolicy);
		
		//response.print();
	
		  Log.info(response.getBody().asString());
		//  assertions.verifyResponseBody(apiActions.getDataFromJsonPath(response,
		 // "unitPriceDetails.currency"), "SAR", "verify body data");
		  assertions.verifyStatusCode(response);
		  
		  String a = apiActions.getDataFromJsonPath(response, "unitPriceDetails.currency");
		  System.out.println(a);
		 // assertions.verifyResponseBody(apiActions.getDataFromJsonPath(response,
			//	  "unitPriceDetails.hostPreApprovalRequired"), false, "verify body data");
		  
}


}
