package com.qa.showcase.api.clients;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.openqa.selenium.devtools.v122.network.model.Request;
import org.openqa.selenium.devtools.v122.network.model.Response;

public class BaseApiClient {
    protected static final String BASE_URL = "https://restful-booker.herokuapp.com";

    protected RequestSpecification baseRequestSpec(){
        return new RequestSpecBuilder()
                .setBaseUri(BASE_URL)
                .setContentType(ContentType.JSON)
                // Этот фильтр автоматически прикрепит тело запроса и ответа в Allure отчет!
                .addFilter(new AllureRestAssured())
                .build();
    }

    protected ResponseSpecification baseResponseSpec(){
        return new ResponseSpecBuilder()
                .log(LogDetail.ALL)
                .build();
    }
}
