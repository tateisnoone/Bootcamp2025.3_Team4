package ge.tbc.testautomation.api;

import ge.tbc.testautomation.Constants;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class BaseApiCards {
    protected static final String BASE_URI = Constants.BASE_URI;

    protected static final RequestSpecification REQ_SPEC =
            new RequestSpecBuilder()
                    .setBaseUri(BASE_URI)
                    .setContentType(ContentType.JSON)
                    .addFilter(new AllureRestAssured())
                    .log(LogDetail.ALL)
                    .build();
}
