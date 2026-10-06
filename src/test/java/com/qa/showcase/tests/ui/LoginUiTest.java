package com.qa.showcase.tests.ui;


import com.codeborne.selenide.Selenide;
import com.qa.showcase.ui.pages.InventoryPage;
import com.qa.showcase.ui.pages.LoginPage;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;


@Epic("UI Тесты")
@Feature("Авторизация SauceDemo")
public class LoginUiTest extends  BaseUiTest {

    @Test
    @Story("Успешный логин под стандартным пользователем")
    public  void testSuccessfulLogin(){
        Selenide.open("https://www.saucedemo.com/");

        LoginPage loginPage = new LoginPage();
        loginPage.login("standard_user", "secret_sauce");

        InventoryPage inventoryPage = new InventoryPage();
        inventoryPage.checkPageIsOpen();
    }
}
