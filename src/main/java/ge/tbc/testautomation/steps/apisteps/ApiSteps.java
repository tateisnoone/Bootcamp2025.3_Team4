package ge.tbc.testautomation.steps.apisteps;

import ge.tbc.testautomation.Constants;
import ge.tbc.testautomation.api.PageApiCards;
import ge.tbc.testautomation.models.response.PageResponse;
import ge.tbc.testautomation.models.response.SectionComponent;
import io.qameta.allure.Step;
import org.testng.Assert;

import java.util.List;

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
                Constants.SECTION_COMPONENTS_NOT_NULL);

        return response;
    }

    private SectionComponent getSection(PageResponse response, String type) {
        return response.sectionComponents()
                .stream()
                .filter(s -> type.equals(s.type()))
                .findFirst()
                .orElseThrow(() -> new RuntimeException(Constants.SECTION_NOT_FOUND + type));
    }

    @Step("Get CTA list from API")
    public List<String> getCtaList(PageResponse r) {
        return getSection(r, "ctaSection")
                .inputs()
                .list()
                .stream()
                .map(item -> item.label())
                .toList();
    }

    @Step("Get CTA title from API")
    public String getCtaTitle(PageResponse r) {
        return getSection(r, "ctaSection").inputs().title();
    }

    @Step("Get CTA button from API")
    public String getCtaButton(PageResponse r) {
        return getSection(r, "ctaSection").inputs().buttons().get(0).label();
    }


    @Step("Validate CTA title")
    public void validateCtaTitle(String pageId, String uiTitle) {
        PageResponse r = getPageAndValidate200(pageId);
        Assert.assertEquals(getCtaTitle(r).trim(), uiTitle.trim(), Constants.CTA_TITLE_MISMATCH);
    }


    @Step("Validate CTA button")
    public void validateCtaButton(String pageId, String uiButton) {
        PageResponse r = getPageAndValidate200(pageId);
        Assert.assertEquals(getCtaButton(r).trim(), uiButton.trim(), Constants.CTA_BUTTON_MISMATCH);
    }

    @Step("Validate CTA list")
    public void validateCtaList(String pageId, List<String> uiList) {
        PageResponse r = getPageAndValidate200(pageId);
        Assert.assertEquals(getCtaList(r), uiList, Constants.CTA_LIST_MISMATCH);
    }

    @Step("Get cards from API")
    public List<String> getCards(PageResponse r) {
        return getSection(r, "cardsGridCarousel")
                .inputs()
                .slides()
                .get(0)
                .cards()
                .stream()
                .map(c -> c.title())
                .toList();
    }


    @Step("Validate cards content")
    public void validateCardsContent(String pageId, List<String> uiCards) {
        PageResponse r = getPageAndValidate200(pageId);
        Assert.assertEquals(getCards(r), uiCards, Constants.CARDS_MISMATCH);
    }


    @Step("Get old cards from API")
    public List<String> getOldCards(PageResponse r) {
        return getSection(r, "cardsCarousel")
                .inputs()
                .cards()
                .stream()
                .map(c -> c.title())
                .toList();
    }


    @Step("Validate old cards content")
    public void validateOldCardsContent(String pageId, List<String> uiCards) {
        PageResponse r = getPageAndValidate200(pageId);
        Assert.assertEquals(getOldCards(r), uiCards, Constants.OLD_CARDS_MISMATCH);
    }


    @Step("Get banner title from API")
    public String getBannerTitle(PageResponse r) {
        return getSection(r, "iconBannerSection").inputs().title();
    }

    @Step("Validate banner title")
    public void validateBannerTitle(String pageId, String uiTitle) {
        PageResponse r = getPageAndValidate200(pageId);
        Assert.assertEquals(getBannerTitle(r).trim(), uiTitle.trim(), Constants.BANNER_MISMATCH);
    }



}
