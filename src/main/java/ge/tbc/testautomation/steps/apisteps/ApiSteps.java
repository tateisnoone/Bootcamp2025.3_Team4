package ge.tbc.testautomation.steps.apisteps;

import ge.tbc.testautomation.Constants;
import ge.tbc.testautomation.api.PageApiCards;
import ge.tbc.testautomation.models.apiResponse.Card;
import ge.tbc.testautomation.models.apiResponse.ListItem;
import ge.tbc.testautomation.models.apiResponse.PageResponse;
import ge.tbc.testautomation.models.apiResponse.SectionComponent;
import io.qameta.allure.Step;
import org.testng.Assert;

import java.util.List;

import static ge.tbc.testautomation.Constants.*;

public class ApiSteps {

    private final PageApiCards api = new PageApiCards();

    @Step("Get page by id: {pageId}")
    public PageResponse getPage(String pageId) {

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
    @Step
    private SectionComponent getSection(PageResponse response, String type) {
        return response.sectionComponents()
                .stream()
                .filter(s -> type.equals(s.type()))
                .findFirst()
                .orElseThrow(() -> new RuntimeException(Constants.SECTION_NOT_FOUND + type));
    }

    @Step("Get CTA list from API")
    public List<String> getCtaList(PageResponse r) {
        return getSection(r, CTA_SECTION)
                .inputs()
                .list()
                .stream()
                .map(ListItem::label)
                .toList();
    }

    @Step("Get CTA title from API")
    public String getCtaTitle(PageResponse r) {
        return getSection(r, CTA_SECTION).inputs().title();
    }

    @Step("Get CTA button from API")
    public String getCtaButton(PageResponse r) {
        return getSection(r, CTA_SECTION).inputs().buttons().get(0).label();
    }

    @Step("Validate CTA title")
    public void validateCtaTitle(PageResponse r, String uiTitle) {
        Assert.assertEquals(
                normalize(getCtaTitle(r)),
                normalize(uiTitle),
                Constants.CTA_TITLE_MISMATCH
        );
    }

    @Step("Validate CTA button")
    public void validateCtaButton(PageResponse r, String uiButton) {
        Assert.assertEquals(
                normalize(getCtaButton(r)),
                normalize(uiButton),
                Constants.CTA_BUTTON_MISMATCH
        );
    }

    @Step("Validate CTA list")
    public void validateCtaList(PageResponse r, List<String> uiList) {
        Assert.assertEquals(
                getCtaList(r),
                uiList,
                Constants.CTA_LIST_MISMATCH
        );
    }

    @Step("Get cards from API")
    public List<String> getCards(PageResponse r) {
        return getSection(r, CARDS_GRID_CAROUSEL)
                .inputs()
                .slides()
                .getFirst()
                .cards()
                .stream()
                .map(Card::title)
                .toList();
    }

    @Step("Validate cards content")
    public void validateCardsContent(PageResponse r, List<String> uiCards) {
        Assert.assertEquals(
                getCards(r),
                uiCards,
                Constants.CARDS_MISMATCH
        );
    }

    @Step("Get old cards from API")
    public List<String> getOldCards(PageResponse r) {
        return getSection(r, Constants.CARDS_CAROUSEL)
                .inputs()
                .cards()
                .stream()
                .map(Card::title)
                .toList();
    }

    @Step("Validate old cards content")
    public void validateOldCardsContent(PageResponse r, List<String> uiCards) {
        Assert.assertEquals(getOldCards(r), uiCards, OLD_CARDS_MISMATCH);
    }

    @Step("Get banner title from API")
    public String getBannerTitle(PageResponse r) {
        return getSection(r, ICON_BANNER).inputs().title();
    }

    @Step("Validate banner title")
    public void validateBannerTitle(PageResponse r, String uiTitle) {
        Assert.assertEquals(normalize(getBannerTitle(r)), normalize(uiTitle), BANNER_MISMATCH);
    }

    private String normalize(String text) {
        return text == null ? null : text.trim();
    }
}