package ge.tbc.testautomation.api;

import ge.tbc.testautomation.config.AllureConfig;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static ge.tbc.testautomation.data.Constants.BASE_URI;

public class BaseApiCards {

    protected static final RequestSpecification REQ_SPEC =
            new RequestSpecBuilder()
                    .setBaseUri(BASE_URI)
                    .setContentType(ContentType.JSON)
                    .addFilter(AllureConfig.ALLURE_FILTER)
                    .log(LogDetail.ALL)
                    .build();
}
