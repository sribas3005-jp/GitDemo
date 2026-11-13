package files;

import io.restassured.path.json.JsonPath;

public class Reusablemethods {
	
	public static JsonPath rawToJson(String getresponse)
	{
		JsonPath js1= new JsonPath(getresponse);
		return js1;
	}

}
