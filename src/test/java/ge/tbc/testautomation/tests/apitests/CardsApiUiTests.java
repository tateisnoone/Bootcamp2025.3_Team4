package ge.tbc.testautomation.tests.apitests;

import ge.tbc.testautomation.steps.apisteps.ApiSteps;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;

@Epic("API Integration")
@Feature("Cards Page Validation")
public class CardsApiUiTests extends BaseForApi {
    private final ApiSteps apiSteps = new ApiSteps();

    private static final String PAGE_ID = "42QIbP7GGWzmhrXpSV3iA4";

    @Test
    @Description("Verify cards API returns 200")
    public void shouldReturnCardsPageSuccessfully() {
        apiSteps.getPageAndValidate200(PAGE_ID);
    }

    @Test
    @Description("Validate CTA title API vs UI")
    public void validateCtaTitleApiVsUi() {
        cardSteps.openCardsPage();
        String uiTitle = cardSteps.getMainTitle();

        apiSteps.validateCtaTitleMatchesUi(PAGE_ID, uiTitle);
    }

    @Test
    @Description("Validate CTA button API vs UI")
    public void validateCtaButtonApiVsUi() {
        cardSteps.openCardsPage();
        String uiLabel = cardSteps.getApplyButtonText();

        apiSteps.validateCtaButtonMatchesUi(PAGE_ID, uiLabel);
    }

    @Test
    @Description("Validate first card title API vs UI")
    public void validateFirstCardApiVsUi() {
        cardSteps.openCardsPage();
        String uiTitle = cardSteps.getFirstCardTitle();

        apiSteps.validateFirstCardMatchesUi(PAGE_ID, uiTitle);
    }

    @Test
    @Description("Validate 404 for invalid page")
    public void shouldReturn404ForInvalidPage() {
        apiSteps.validateNegativePage("invalid-id");
    }

}
