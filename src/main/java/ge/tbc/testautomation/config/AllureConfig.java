package ge.tbc.testautomation.config;

import io.qameta.allure.restassured.AllureRestAssured;

import static ge.tbc.testautomation.data.Constants.*;

public class AllureConfig {
    public static final AllureRestAssured ALLURE_FILTER = new AllureRestAssured()
            .setRequestAttachmentName(REQUEST)
            .setResponseAttachmentName(RESPONSE);
}
