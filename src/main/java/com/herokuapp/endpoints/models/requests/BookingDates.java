package com.herokuapp.endpoints.models.requests;

import lombok.*;

@Getter @Setter @Builder
@NoArgsConstructor@AllArgsConstructor
public class BookingDates {

    private String checkin = "2018-01-01";

    private String checkout = "2019-01-01";
}
