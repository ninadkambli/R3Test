package awesomecucumber.context;


import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.openqa.selenium.WebDriver;

public class TestContext {
    private RequestSpecification reqSpec;
    private Response res;

    public RequestSpecification get_reqSpec(){
        return this.reqSpec;
    }

    public void set_reqSpec(RequestSpecification reqSpec){
        this.reqSpec = reqSpec;
    }

    public Response get_res(){
        return this.res;
    }

    public void set_res(Response res){
        this.res = res;
    }
}
