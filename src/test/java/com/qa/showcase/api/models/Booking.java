package com.qa.showcase.api.models;

public record Booking(
        String firstname,
        String lastname,
        int totalprice,
        boolean depositpaid,
        BookingDates bookingdates,
        String additionalneeds
) {
}