package stepdefination;

import static org.testng.Assert.assertEquals;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GetAnIncident {
public Response response;
public JsonPath json;
	@Given("I hit the GetanIncidentAPI")
	public void I_hit_the_GetanIncidentAPI()
	{
		RestAssured.baseURI = "https://dev190011.service-now.com/api/now/table/incident/1c741bd70b2322007518478d83673af3";
		
	}
	
	
	@When("I pass the URL and authentication")
	public void I_pass_the_URL_and_authentication()
	{
		RestAssured.given().auth().basic("admin", "Q/lt5JFzbV5=");
		 response = RestAssured.get();
		 json = response.jsonPath();
		
	}
	
	
	@Then("I need to validate the sys_id number in response as{}")
	public void I_need_to_validate_the_sys_id_in_response_as(String sys_id)
	{
		Object jsonObject = json.getJsonObject("result.sys_id");
		String sysid = jsonObject.toString();
		assertEquals(sysid , sys_id);
		System.out.println("Actual Value is "+sysid);
		System.out.println("Expected value is "+sys_id);
		
	}
	
}
