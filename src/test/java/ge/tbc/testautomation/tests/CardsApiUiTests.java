package ge.tbc.testautomation.tests;

import ge.tbc.testautomation.models.apiResponse.PageResponse;
import ge.tbc.testautomation.utils.RetryCount;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;

import static ge.tbc.testautomation.Constants.VALID_PAGE_ID;

@Epic("API Integration")
@Feature("Cards Page")
@Test(groups = {"E2E - Details from API matches displayed information - T4-T4"})
@RetryCount(count = 2)
public class CardsApiUiTests extends BaseTest {
    private PageResponse pageResponse;

    @Test(priority = 1)
    public void setUpApiResponse() {
        pageResponse = apiSteps.getPage(VALID_PAGE_ID);
    }

    @Test(priority = 2)
    @Description("Validate CTA title from API matches UI.")
    public void validateCtaTitleApiVsUi() {
        apiSteps.validateCtaTitle(pageResponse, cardsSteps.getMainTitle());
    }

    @Test(priority = 3)
    @Description("Validate CTA button from API matches UI.")
    public void validateCtaButtonApiVsUi() {
        apiSteps.validateCtaButton(pageResponse, cardsSteps.getApplyButtonText());
    }

    @Test(priority = 4)
    @Description("Validate CTA list from API matches UI.")
    public void validateCtaListApiVsUi() {
        apiSteps.validateCtaList(pageResponse, cardsSteps.getCtaList());
    }

    @Test(priority = 5)
    @Description("Validate cards grid from API matches UI.")
    public void validateCardsApiVsUi() {
        apiSteps.validateCardsContent(pageResponse, cardsSteps.getAllCardTitles());
    }

    @Test(priority = 6)
    @Description("Validate old cards from API matches UI.")
    public void validateOldCardsApiVsUi() {
        apiSteps.validateOldCardsContent(pageResponse, cardsSteps.getOldCardTitles());
    }

    @Test(priority = 7)
    @Description("Validate banner title from API matches UI.")
    public void validateBannerTitleApiVsUi() {
        apiSteps.validateBannerTitle(pageResponse, "test");
    }
}
