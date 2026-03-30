package ge.tbc.testautomation.tests.apitests;

import ge.tbc.testautomation.Constants;
import ge.tbc.testautomation.steps.CardsSteps;
import ge.tbc.testautomation.steps.apisteps.ApiSteps;
import ge.tbc.testautomation.tests.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@Epic("API Integration")
@Feature("Cards Page Validation")
public class CardsApiUiTests extends BaseTest {

    private CardsSteps cardSteps;
    private ApiSteps apiSteps;


    private static final String PAGE_ID = Constants.VALID_PAGE_ID;

    @BeforeClass
    public void initSteps() {
        apiSteps = new ApiSteps();
        cardSteps = new CardsSteps(page);
    }

    @Test(priority = 1)
    @Description("Verify cards API returns HTTP 200 for valid page ID.")
    public void shouldReturnCardsPageSuccessfully() {
        apiSteps.getPageAndValidate200(PAGE_ID);
    }

    @Test(priority = 2)
    @Description("Validate CTA title from API matches UI.")
    public void validateCtaTitleApiVsUi() {

        String uiTitle = cardSteps.getMainTitle();

        apiSteps.validateCtaTitle(PAGE_ID, uiTitle);
    }

    @Test(priority = 3)
    @Description("Validate CTA button from API matches UI.")
    public void validateCtaButtonApiVsUi() {

        String uiButton = cardSteps.getApplyButtonText();

        apiSteps.validateCtaButton(PAGE_ID, uiButton);
    }

    @Test(priority = 4)
    @Description("Validate CTA list from API matches UI.")
    public void validateCtaListApiVsUi() {

        apiSteps.validateCtaList(PAGE_ID, cardSteps.getCtaList());
    }

    @Test(priority = 5)
    @Description("Validate cards grid from API matches UI.")
    public void validateCardsApiVsUi() {

        apiSteps.validateCardsContent(PAGE_ID, cardSteps.getAllCardTitles());
    }

    @Test(priority = 6)
    @Description("Validate old cards from API matches UI.")
    public void validateOldCardsApiVsUi() {

        apiSteps.validateOldCardsContent(PAGE_ID, cardSteps.getOldCardTitles());
    }

    @Test(priority = 7)
    @Description("Validate banner title from API matches UI.")
    public void validateBannerTitleApiVsUi() {

        String uiBanner = cardSteps.getBannerTitle();

        apiSteps.validateBannerTitle(PAGE_ID, uiBanner);
    }




}
