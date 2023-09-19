package com.m2p.livQuik.demo.setup;

import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.hamcrest.Matchers;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RestAssuredSetup {

    @Value("${app.url}")
    public String url;

    @Step
    public void restAssuredSetupHosted() {
        RestAssured.requestSpecification = requestSpecBuilderHosted();
        RestAssured.responseSpecification = responseSpecBuilder();
    }
    @Step
    public void restAssuredSetupLocal() {
        RestAssured.requestSpecification = requestSpecBuilderLocal();
        RestAssured.responseSpecification = responseSpecBuilder();
    }
    public RequestSpecification requestSpecBuilderHosted(){
        return new RequestSpecBuilder()
                .setBaseUri(url)
                .setBasePath("/lqfleet/")
                .setContentType("application/json")
                .addHeader("Accept","application/json")
              .addHeader("TENANT","LQFLEET")
                .addHeader("tenant","lqfleet")
                .addFilter(new RequestLoggingFilter())
                .addFilter(new ResponseLoggingFilter())
                .build();
    }
    public RequestSpecification requestSpecBuilderLocal(){
        return new RequestSpecBuilder()
                .setBaseUri(url)
      //          .setPort(8080)
                .addHeader("TENANT","LQFLEET")
                .addHeader("tenant","lqfleet")
              .setBasePath("lq-middleware/lqfleet/")
                .setContentType("application/json")
                .addHeader("Accept","application/json")
                .addFilter(new RequestLoggingFilter())
                .addFilter(new ResponseLoggingFilter())
                .build();
    }


    public ResponseSpecification responseSpecBuilder(){
        return new ResponseSpecBuilder()
                .expectResponseTime(Matchers.lessThan(30000L))
                .build();
    }
}
