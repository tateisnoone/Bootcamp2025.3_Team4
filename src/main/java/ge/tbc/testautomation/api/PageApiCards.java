package ge.tbc.testautomation.api;

import ge.tbc.testautomation.data.Constants;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class PageApiCards extends BaseApiCards {
    public Response getPage(String pageId) {
        return given()
                .spec(REQ_SPEC)
                .basePath(Constants.BASE_PATH)
                .pathParam(Constants.PATH_PARAM_PAGE_ID, pageId)
                .queryParam(Constants.LOCALE, Constants.GEO_KA)
                .when()
                .get();
    }
}
