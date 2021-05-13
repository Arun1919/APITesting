package restfulBroker.requests;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @Builder
public class BookingDates {

    private String checkin = "2018-01-01";

    private String checkout = "2019-01-01";
}
