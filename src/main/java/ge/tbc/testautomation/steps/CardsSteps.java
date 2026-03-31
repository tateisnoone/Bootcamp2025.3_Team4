package ge.tbc.testautomation.steps;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import ge.tbc.testautomation.pages.CardsPage;
import io.qameta.allure.Step;

import java.util.List;


public class CardsSteps {
    CardsPage cardsPage;

    public CardsSteps(Page page) {
        cardsPage = new CardsPage(page);
    }

    @Step("Open card details")
    public CardsSteps openCardDetails() {
        cardsPage.cardDetailsButton.click();
        return this;
    }

    @Step("Navigate to Ertguli Credit Card page")
    public CardsSteps navigateToErtguliCreditCardPage(){
        cardsPage.ertguliCardLink.click();
        return this;
    }

    @Step("Get CTA title")
    public String getMainTitle() {
        return getTrimmedText(cardsPage.header);
    }

    @Step("Get CTA button")
    public String getApplyButtonText() {
        return getTrimmedText(cardsPage.cardDetailsButton);
    }

    @Step("Get CTA list")
    public List<String> getCtaList() {
        return getTrimmedTexts(cardsPage.ctaListItems);
    }

    @Step("Get cards")
    public List<String> getAllCardTitles() {
        return List.of(
                getTrimmedText(cardsPage.ertguliCardTitle),
                getTrimmedText(cardsPage.studentsCardTitle),
                getTrimmedText(cardsPage.pupilsCardTitle)
        );
    }

    @Step("Get old cards")
    public List<String> getOldCardTitles() {
        cardsPage.oldCardsList.first().scrollIntoViewIfNeeded();
        return getTrimmedTexts(cardsPage.oldCardsList);
    }

    @Step("Get banner title")
    public String getBannerTitle() {
        return getTrimmedText(cardsPage.cardSecurityBanner);
    }

    private String getTrimmedText(Locator locator) {
        return locator.innerText().trim();
    }

    private List<String> getTrimmedTexts(Locator locator) {
        return locator.allInnerTexts()
                .stream()
                .map(String::trim)
                .toList();
    }
}
