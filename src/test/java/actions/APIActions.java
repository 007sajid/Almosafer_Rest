package actions;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class APIActions {
	//Gets a response body and returns required value from JSON.  
    public <T> T getDataFromJsonPath(Response response, String jsonPath) {

        JsonPath jpath = response.jsonPath();
        return jpath.get(jsonPath);
    }
}
