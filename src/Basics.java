import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;

import files.Reusablemethods;
import files.payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class Basics {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Validating Add place API
		
		//given()- Getting all inputs
		//when()-  submiting the inputs using http method and resource
		//then()- validating the response
		
		//Add place-> update place with new address -> get place to validate if new address is presnet in response
		
		RestAssured.baseURI="https://rahulshettyacademy.com";
		String response = given().relaxedHTTPSValidation().log().all().queryParam("key","qaclick123").header("Content-Type","application/json")
		.body(payload.AddPlace()).when().post("maps/api/place/add/json")
		.then().statusCode(200).body("scope",equalTo("APP")).
		header("Server","Apache/2.4.52 (Ubuntu)").extract().response().asString();
		System.out.println(response);
		JsonPath js= new JsonPath(response); //for parsing json
		String placeId = js.getString("place_id");
		System.out.println(placeId);
		
		//update place
		String newAddress= "70 Summer walk, USA";
		
		given().relaxedHTTPSValidation().log().all().queryParam("key","qaclick123").header("Content-Type","application/json")
		.body("{\r\n"
				+ "\"place_id\":\""+placeId+"\",\r\n"
				+ "\"address\":\""+newAddress+"\",\r\n"
				+ "\"key\":\"qaclick123\"\r\n"
				+ "}")
		.when().put("maps/api/place/update/json")
		.then().log().all().statusCode(200).body("msg", equalTo("Address successfully updated"));
		
		//Get place
		
		String getPlaceResponse =given().relaxedHTTPSValidation().log().all().queryParam("key","qaclick123").queryParam("place_id",placeId)
		.when().get("maps/api/place/get/json")
		.then().log().all().statusCode(200).extract().response().asString();
		
		JsonPath js1= Reusablemethods.rawToJson(getPlaceResponse);
		String actualAddress = js1.getString("address");
		System.out.println(actualAddress);
		Assert.assertEquals(newAddress, actualAddress);
			
	}
}
	
	


