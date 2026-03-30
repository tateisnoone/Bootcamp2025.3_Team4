package ge.tbc.testautomation.api;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class PageApiCards extends BaseApiCards{
    public Response getPage(String pageId) {
        return given()
                .spec(REQ_SPEC)
                .basePath("/api/v1/sites/pages/{pageId}")
                .pathParam("pageId", pageId)
                .queryParam("locale", "ka-GE")
                .when()
                .get();
    }
}
