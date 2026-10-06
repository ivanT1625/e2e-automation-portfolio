package com.qa.showcase.tests.api;

import com.qa.showcase.api.clients.BookingClient;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@Epic("API Тесты")
@Feature("Авторизация")
public class AuthApiTest {

    @Test
    public void testGetAuthToken() {
        BookingClient bookingClient = new BookingClient();
        String token = bookingClient.getToken("admin", "password123");

        Assertions.assertNotNull(token, "Токен не должен быть пустым");
    }
}
