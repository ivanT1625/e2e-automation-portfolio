package com.qa.showcase.api.clients;

import com.qa.showcase.api.models.AuthRequest;
import com.qa.showcase.api.models.AuthResponse;
import com.qa.showcase.api.models.Booking;
import com.qa.showcase.api.models.BookingResponse;
import io.qameta.allure.Step;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class BookingClient extends BaseApiClient
{
    @Step("Получение токена авторизации для пользователя: {username}")
    public String getToken(String username, String password) {
        AuthRequest authRequest = new AuthRequest(username, password);

        return given()
                .spec(baseRequestSpec())
                .body(authRequest)
                .when()
                .post("/auth")
                .then()
                .spec(baseResponseSpec())
                .statusCode(200)
                .extract()
                .as(AuthResponse.class)
                .token();
    }

    @Step("Создания нового бронирования")
    public BookingResponse createBooking(Booking booking){
        return given()
                .spec(baseRequestSpec())
                .body(booking)
                .when()
                .post("/booking")
                .then()
                .spec(baseResponseSpec())
                .statusCode(200)
                .extract()
                .as(BookingResponse.class);
    }

    @Step("Получение бронирования по ID: {bookingId}")
    public Booking getBooking(int bookingId){
        return given()
                .spec(baseRequestSpec())
                .pathParam("id", bookingId)
                .when()
                .get("/booking/{id}")
                .then()
                .spec(baseResponseSpec())
                .statusCode(200)
                .extract()
                .as(Booking.class);
    }
}
