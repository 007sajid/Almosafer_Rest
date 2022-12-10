package endpoints;

import utils.DataUtils;
//DataUtils.getTestData("TestData", "Token", "Value");;
public class APIConstants {

	//public final static String baseUrl = "https://www.almosafer.com/api/";
			
	public final static String baseUrl = DataUtils.getTestData("Sheet1", "BaseUrl", "Value");
	
	//DataUtils.getTestData("Sheet1")
	public final static String postPricePolicy = "accommodation/property/prices-policies";
	public final static String getFlight = "flight/resource/codes/RUH,JED";// + DataUtils.getTestData("TestData", "Username", "Value") + "/repos";

	public final static String token = DataUtils.getTestData("Sheet1", "Token", "Value");
	public final static String checkIn = DataUtils.getTestData("Sheet2", "CheckIn", "Value");
	public final static String checkOut = DataUtils.getTestData("Sheet2", "CheckOut", "Value");
		

}
