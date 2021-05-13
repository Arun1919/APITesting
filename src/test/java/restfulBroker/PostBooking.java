package restfulBroker;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.mapper.ObjectMapper;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PostBooking {

    private BookingRequest bookingRequest;
    private  BookingDatesRequest bookingDatesRequest;

   @Test
    public void makePostBooking(){

        RestAssured.baseURI = "https://restful-booker.herokuapp.com/booking";

        RequestSpecification request = RestAssured.given();

        request.body(bookingRequest, (ObjectMapper) bookingDatesRequest);

        Response response = request.request(Method.POST);

        String responseBody = response.getBody().asString();
        System.out.println(responseBody);

        //Validation
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode,200);

    }

}
