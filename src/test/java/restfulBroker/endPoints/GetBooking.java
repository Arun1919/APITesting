package restfulBroker.endPoints;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetBooking {

    @Test
    public void getBookingId(){

        //Specify base URL
        RestAssured.baseURI = "https://restful-booker.herokuapp.com/booking";

        //Request object
        RequestSpecification httpRequest = RestAssured.given();

       //Response object
        Response response = httpRequest.request(Method.GET,"/1");

        String responseBody = response.getBody().asString();
        System.out.println(responseBody);

        //Validation
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode,200);

        Object firstname = response.jsonPath().get("firstname");
        Assert.assertEquals(firstname,"Susan");

        Object lastname = response.jsonPath().get("lastname");
        Assert.assertEquals(lastname,lastname);

    }
}
