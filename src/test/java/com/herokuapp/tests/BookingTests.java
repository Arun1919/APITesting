package com.herokuapp.tests;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.herokuapp.endpoints.clients.BookingClient;
import com.herokuapp.endpoints.models.requests.Booking;
import com.herokuapp.endpoints.models.requests.LoginCred;
import com.herokuapp.endpoints.models.responses.MakeBookingResponse;

public class BookingTests {

    @Test
    public void verifyBookingIdIsGenerated(){
        String bookingId = "1";

        BookingClient getBookingClient = new BookingClient();
        Response response = getBookingClient.getBookingId(bookingId);

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

    @Test
    public void createNewBookingTest(){

        Booking booking = new Booking();
        BookingClient bookingClient = new BookingClient();
        MakeBookingResponse newBooking = bookingClient.createNewBooking(booking);

        newBooking.assertThatBookingIdIsPresent();
        newBooking.getBooking().assertThatBookingIsPresent(booking);
    }

    @Test
    public void updateBookingTest(){

        Booking booking = new Booking(); //requestBody

        BookingClient bookingClient = new BookingClient();//RestClient

        MakeBookingResponse newBooking = bookingClient.createNewBooking(booking);

        Booking updatedBooking = booking.toBuilder().firstname("Ak").build();
        Booking updatedBookingResponse = bookingClient.updateBooking(new LoginCred(),
                             String.valueOf(newBooking.getBookingid()), updatedBooking);

        updatedBookingResponse.assertThatBookingIsPresent(updatedBooking);

    }

}
