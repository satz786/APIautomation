package stepdefination;

import static org.testng.Assert.assertEquals;

import java.net.http.HttpRequest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Product {
	public RequestSpecification httpRequest;
	public Response response; 
	@Given("I hit the Getincident API")
	public void I_hit_the_Getincident_API()
	{
		RestAssured.baseURI = "https://dev190011.service-now.com/api/now/table/incident";
		//RestAssured.given();
		
		
	}

	

@When("I pass the URL")
public void i_pass_the_url() {
    // Write code here that turns the phrase above into concrete actions
	 httpRequest = RestAssured.given().auth().basic("admin", "Q/lt5JFzbV5=");
	 response = httpRequest.get();
	 //response.prettyPrint();
}

@Then("I need to get status code as {int}")
public void i_need_to_get_status_code_as(Integer int1) {
    // Write code here that turns the phrase above into concrete actions
	int statusCode = response.getStatusCode();
	assertEquals(statusCode, 200);
	
}


	
	
	
}
