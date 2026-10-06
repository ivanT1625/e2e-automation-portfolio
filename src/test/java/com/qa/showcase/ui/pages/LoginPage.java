package com.qa.showcase.ui.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    private final SelenideElement usernameInput = $("[data-test='username']");
    private final SelenideElement passwordInput = $("[data-test='password']");
    private final SelenideElement loginButton = $("[data-test='login-button']");
    private final SelenideElement errorMessage = $("[data-test='error']");

    @Step("Вводим логин: {username} и пароль: {password} и нажимаем Login")
    public void login(String username, String password){
        usernameInput.setValue(username);
        passwordInput.setValue(password);
        loginButton.click();
    }
}
