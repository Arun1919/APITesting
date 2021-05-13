package restfulBroker.requests;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.testng.Assert;

@Getter @Setter @Builder
public class Booking {

    private String firstname = "Jim";
    private String lastname = "Brown";
    private int totalprice = 111;
    private boolean depositpaid = true;
    private BookingDates bookingdates;
    private String additionalneeds = "Breakfast";

    public void assertThatBookingIsPresent(Booking booking){
        Assert.assertEquals(this.firstname,booking.firstname);
        Assert.assertEquals(booking.totalprice, this.totalprice);
    }
}

