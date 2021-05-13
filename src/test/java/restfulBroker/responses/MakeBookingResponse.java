package restfulBroker.responses;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.junit.Assert;
import restfulBroker.requests.Booking;

@Getter @Setter @Builder
public class MakeBookingResponse {

    private int bookingid;
    private Booking booking;

    public void assertThatBookingIdIsPresent(){
        Assert.assertTrue(bookingid>0);
    }

}
