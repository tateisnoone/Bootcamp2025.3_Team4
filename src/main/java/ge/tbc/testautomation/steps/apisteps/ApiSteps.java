package ge.tbc.testautomation.steps.apisteps;

import ge.tbc.testautomation.api.PageApiCards;
import ge.tbc.testautomation.models.response.PageResponse;
import ge.tbc.testautomation.models.response.SectionComponent;
import io.qameta.allure.Step;
import org.testng.Assert;

public class ApiSteps {
    private final PageApiCards api = new PageApiCards();

    @Step("Get page by id: {pageId} and validate status 200")
    public PageResponse getPageAndValidate200(String pageId) {

        PageResponse response =
                api.getPage(pageId)
                        .then()
                        .statusCode(200)
                        .extract()
                        .as(PageResponse.class);

        Assert.assertNotNull(response.sectionComponents(),
                "sectionComponents is null");

        return response;
    }

    @Step("Validate negative page")
    public void validateNegativePage(String pageId) {
        api.getPage(pageId)
                .then()
                .statusCode(404);
    }

    private SectionComponent getSectionByType(PageResponse response, String type) {
        return response.sectionComponents()
                .stream()
                .filter(s -> type.equals(s.type()))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Section not found: " + type));
    }

    //  TITLE
    public String extractCtaTitle(PageResponse response) {
        return getSectionByType(response, "ctaSection")
                .inputs()
                .title();
    }

    //  BUTTON
    public String extractCtaButtonLabel(PageResponse response) {
        return getSectionByType(response, "ctaSection")
                .inputs()
                .buttons()
                .get(0)
                .label();
    }

    // FIRST CARD TITLE
    public String extractFirstCardTitle(PageResponse response) {
        return getSectionByType(response, "cardsGridCarousel")
                .inputs()
                .slides()
                .get(0)
                .cards()
                .get(0)
                .title();
    }

    //  VALIDATIONS

    @Step("Validate CTA title matches UI")
    public void validateCtaTitleMatchesUi(String pageId, String uiTitle) {
        PageResponse response = getPageAndValidate200(pageId);

        Assert.assertEquals(
                extractCtaTitle(response).trim(),
                uiTitle.trim(),
                "CTA title mismatch"
        );
    }

    @Step("Validate CTA button matches UI")
    public void validateCtaButtonMatchesUi(String pageId, String uiLabel) {
        PageResponse response = getPageAndValidate200(pageId);

        Assert.assertEquals(
                extractCtaButtonLabel(response).trim(),
                uiLabel.trim(),
                "CTA button mismatch"
        );
    }

    @Step("Validate first card title matches UI")
    public void validateFirstCardMatchesUi(String pageId, String uiTitle) {
        PageResponse response = getPageAndValidate200(pageId);

        Assert.assertEquals(
                extractFirstCardTitle(response).trim(),
                uiTitle.trim(),
                "Card title mismatch"
        );
    }
}
