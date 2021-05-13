package restfulBroker;

public class BookingRequest {

    private String firstname;

    private String lastname;

    private int totalprice;

    private String depositpaid;

    private String additionalneeds;

    BookingDatesRequest bookingDatesRequest;

    public BookingDatesRequest getBookingDatesRequest() {
        return bookingDatesRequest;
    }

    public void setBookingDatesRequest(BookingDatesRequest bookingDatesRequest) {
        this.bookingDatesRequest = bookingDatesRequest;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(int totalprice) {
        this.totalprice = totalprice;
    }

    public String getDepositpaid() {
        return depositpaid;
    }

    public void setDepositpaid(String depositpaid) {
        this.depositpaid = depositpaid;
    }

    public String getAdditionalneeds() {
        return additionalneeds;
    }

    public void setAdditionalneeds(String additionalneeds) {
        this.additionalneeds = additionalneeds;
    }

    }

