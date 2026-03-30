package ge.tbc.testautomation.api;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static ge.tbc.testautomation.Constants.BASE_URI;
import static ge.tbc.testautomation.config.AllureConfig.ALLURE_FILTER;

public class BaseApiCards {

    protected static final RequestSpecification REQ_SPEC =
            new RequestSpecBuilder()
                    .setBaseUri(BASE_URI)
                    .setContentType(ContentType.JSON)
                    .addFilter(ALLURE_FILTER)
                    .log(LogDetail.ALL)
                    .build();
}
