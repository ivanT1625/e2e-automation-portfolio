package com.qa.showcase.tests.api;

import com.qa.showcase.api.clients.BookingClient;
import com.qa.showcase.api.models.Booking;
import com.qa.showcase.api.models.BookingDates;
import com.qa.showcase.api.models.BookingResponse;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import net.datafaker.Faker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@Epic("API Тесты")
@Feature("Управление бронированиями")
public class BookingApiTest {
    private final BookingClient bookingClient = new BookingClient();
    private final Faker faker = new Faker();

    @Test
    @Story("Успешное создание бронирования")
    public void testCreateBooking(){
        BookingDates dates = new BookingDates("2024-05-01", "2024-05-10");
        Booking newBooking = new Booking(
                faker.name().firstName(),
                faker.name().lastName(),
                faker.number().numberBetween(100, 5000),
                true,
                dates,
                "Breakfast"
        );

        BookingResponse createdResponse = bookingClient.createBooking(newBooking);

        Assertions.assertTrue(createdResponse.bookingid() > 0);
        Assertions.assertEquals(newBooking.firstname(), createdResponse.booking().firstname(), "Имя не совпадает");

        Booking fetchedBooking = bookingClient.getBooking(createdResponse.bookingid());
        Assertions.assertEquals(newBooking.lastname(), fetchedBooking.lastname(), "Фамилия в сохраненном бронировании не совпадает");
    }
}
