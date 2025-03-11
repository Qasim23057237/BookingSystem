public class Appointment {

    private int bookingid;
    private String treatmentname;
    private String datetime;
    private String status;

    public int getBookingid() {
        return bookingid;
    }

    public String getTreatmentname() {
        return treatmentname;
    }

    public String getDatetime() {
        return datetime;
    }

    public String getStatus() {
        return status;
    }

    public Appointment(int bookingid, String treatmentname, String datetime, String status) {
        this.bookingid = bookingid;
        this.treatmentname = treatmentname;
        this.datetime = datetime;
        this.status = "booked";
    }

    public String getDetails() {
        return "Appointment ID: " + bookingid + "\n" +
                "Treatment: " + treatmentname + "\n" +
                "Date & Time: " + datetime + "\n" +
                "Status: " + status;

    }
}
