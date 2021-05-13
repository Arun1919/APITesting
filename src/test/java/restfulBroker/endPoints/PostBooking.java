package restfulBroker.endPoints;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;
import restfulBroker.requests.Booking;
import restfulBroker.requests.BookingDates;
import restfulBroker.responses.MakeBookingResponse;

public class PostBooking {

    private Booking bookingRequest;
    private BookingDates bookingDatesRequest;

   @Test
    public void makePostBooking(){

        RestAssured.baseURI = "https://restful-booker.herokuapp.com/booking";

        RequestSpecification request = RestAssured.given();

        Booking booking = new Booking();

       Response response = request.header("Content-Type","application/json")
                .body(booking)
                .post();

       MakeBookingResponse makeBookingResponse = response.as(MakeBookingResponse.class);
       makeBookingResponse.assertThatBookingIdIsPresent();
       booking.assertThatBookingIsPresent(makeBookingResponse.getBooking());

   }

}
