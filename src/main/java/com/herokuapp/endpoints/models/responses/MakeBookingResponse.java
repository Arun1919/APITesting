package com.herokuapp.endpoints.models.responses;

import com.herokuapp.endpoints.models.requests.Booking;
import lombok.*;
import org.testng.Assert;

@Getter @Setter @Builder
@NoArgsConstructor
@AllArgsConstructor
public class MakeBookingResponse {

    private int bookingid;
    private Booking booking;

    public void assertThatBookingIdIsPresent(){
        Assert.assertTrue(bookingid>0);
    }

    public void verifyStatusCode(int statusCode){
        Assert.assertEquals(statusCode,200);
    }

}
