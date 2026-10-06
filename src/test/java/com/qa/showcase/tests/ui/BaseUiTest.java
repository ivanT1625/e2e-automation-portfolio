package com.qa.showcase.tests.ui;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;



public class BaseUiTest {

    @BeforeAll public  static void setUpAll(){
        Configuration.browserSize = "1920*1080";
        Configuration.pageLoadTimeout = 10000;
        Configuration.timeout = 5000;

        // GitLab-серверы не имеют мониторов, поэтому UI-тесты там упадут при попытке открыть настоящее окно браузера. Теперь браузер будет работать в фоне (без отрисовки интерфейса), что идеально подходит для CI/CD.
        Configuration.headless = true;

        SelenideLogger.addListener("allure", new AllureSelenide()
                .screenshots(true)
                .savePageSource(true));
    }
}
