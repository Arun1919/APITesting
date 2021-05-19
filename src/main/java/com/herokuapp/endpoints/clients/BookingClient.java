package com.herokuapp.endpoints.clients;

import com.herokuapp.endpoints.models.requests.Booking;
import com.herokuapp.endpoints.models.requests.LoginCred;
import com.herokuapp.endpoints.models.responses.MakeBookingResponse;
import com.herokuapp.flows.LoginFlow;
import com.herokuapp.properties.PropertyReader;
import io.restassured.http.Header;
import io.restassured.response.Response;

public class BookingClient extends BaseClient {

    public BookingClient() {
        super(new PropertyReader().getProperty("bookingHost"));

    }

    public Response getBookingId(String bookingId){
        Response response = get("/"+bookingId);
        return response;
    }

    public MakeBookingResponse createNewBooking(Booking booking){
        Response postResponse = post(booking);
        return postResponse.as(MakeBookingResponse.class);
    }

    public Booking updateBooking(LoginCred loginCred,String bookingId,Booking booking){
        Header token = new LoginFlow().loginAuth(loginCred);
        Response response = put(bookingId,booking,token);
        return response.as(Booking.class);
    }

}
