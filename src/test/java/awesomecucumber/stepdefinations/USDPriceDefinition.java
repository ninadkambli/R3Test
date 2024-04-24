package awesomecucumber.stepdefinations;

import awesomecucumber.context.TestContext;

import awesomecucumber.utils.ConfigLoader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.testng.Assert;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class USDPriceDefinition {
    private final TestContext context;
    RequestSpecification reqSpec;
    Response res;
    public String endPoint = "/"+ConfigLoader.getInstance().getVersion()  + "/latest/USD";

    public USDPriceDefinition(TestContext context){
        this.context = context;

    }

    @Given("test")
    public void test() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Test");
    }
    @Given("USD Rates API is running.")
    public void usd_rates_api_is_running() {
        // Write code here that turns the phrase above into concrete actions
        reqSpec= given().baseUri(ConfigLoader.getInstance().getBaseUrl());
    }

    @When("Send {string} USD Rates request to a server.")
    public void send_request_to_a_server(String reqType) {
        // Write code here that turns the phrase above into concrete actions
        if(reqType.equals("Invalid")){
             endPoint =  "/invalid/USD";
        }
        res = reqSpec.get(endPoint);
    }
    @Then("Validate response status code should be successful.")
    public void validate_response_status_code_should_be_successful() {
        // Write code here that turns the phrase above into concrete actions
        List<Integer> validaStatusCodes = Arrays.asList(200,201,202,204);
        assertThat(validaStatusCodes, hasItem(res.getStatusCode()));
    }

    @Then("Validate {string} prince between {string}.")
    public void validate_prince_between(String currency, String priceRange) {
        // Write code here that turns the phrase above into concrete actions
        HashMap curValue = res.path("rates");
        List listCurr = new ArrayList(curValue.keySet()) ;
        Assert.assertTrue(listCurr.contains(currency),"Currency " + currency + " is not found in the currency list from API");
        float lowerValue = Float.parseFloat(priceRange.split("-")[0]);
        float higherValue = Float.parseFloat(priceRange.split("-")[1]);
        assertThat("Values should match",res.path("rates."+currency),greaterThan(lowerValue));
        assertThat("Values should match",res.path("rates."+currency),lessThan(higherValue));
    }

/*
    @Given("playground")
    public void playGround(){
        given().baseUri(ConfigLoader.getInstance().getBaseUrl()).when().get("/invalid/USD").then().log().all().assertThat().statusCode(404);
    }
    */


    @Then("Validate response status code should be unsuccessful.")
    public void validate_response_status_code_should_be_unsuccessful() {
        // Write code here that turns the phrase above into concrete actions
        List<Integer> validateStatusCodes = Arrays.asList(400,401,402,403,404);
        assertThat(validateStatusCodes, hasItem(res.getStatusCode()));
    }
    @Then("Validate {int} currency pairs.")
    public void validate_currency_pairs(Integer int1) {
        HashMap curValue = res.path("rates");
       assertThat("Total currency pairs",curValue.size(),equalTo(162));
    }

    @Then("Validate usdPriceSchema")
    public void validate_usd_price_schema() {
       res.then().body(matchesJsonSchemaInClasspath("jsonSchema/usdPriceSchema.json"));
    }

}
