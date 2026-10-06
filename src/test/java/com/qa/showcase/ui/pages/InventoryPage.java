package com.qa.showcase.ui.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class InventoryPage
{
    private final SelenideElement title = $(".title");

    @Step("Проверяем, что страница товаров упешно открыты")
    public void checkPageIsOpen(){
        // Condition.visible - это умное ожидание. Selenide сам дождется появления элемента
        title.shouldHave(Condition.visible).shouldHave(Condition.text("Products"));
    }
}
