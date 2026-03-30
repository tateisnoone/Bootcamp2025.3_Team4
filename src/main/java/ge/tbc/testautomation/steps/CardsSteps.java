package ge.tbc.testautomation.steps;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import ge.tbc.testautomation.pages.CardsPage;
import io.qameta.allure.Step;
import java.util.List;
import java.util.stream.Collectors;


public class CardsSteps {
    CardsPage cardsPage;
    Page page;

    public CardsSteps(Page page) {
        cardsPage = new CardsPage(page);
        this.page = page;
    }
  
    @Step
    public CardsSteps openCardDetails(){
        cardsPage.cardDetailsButton.click();
        return this;
    }

    @Step("Get CTA title")
    public String getMainTitle() {
        return cardsPage.header.innerText().trim();
    }

    @Step("Get CTA button")
    public String getApplyButtonText() {
        return cardsPage.cardDetailsButton.innerText().trim();
    }

    @Step("Get CTA list")
    public List<String> getCtaList() {
        return page.locator(".tbcx-pw-list")
                .first()
                .locator(".tbcx-list-item__text")
                .allInnerTexts()
                .stream()
                .map(String::trim)
                .toList();
    }


    @Step("Get cards")
    public List<String> getAllCardTitles() {
        return List.of(
                cardsPage.ertguliCardLink.locator("h2").innerText().trim(),
                cardsPage.studentsCardLink.locator("h2").innerText().trim(),
                cardsPage.pupilsCardLink.locator("h2").innerText().trim()
        );
    }

    @Step("Get old cards")
    public List<String> getOldCardTitles() {

        cardsPage.oldCardsList.first().scrollIntoViewIfNeeded();

        return cardsPage.oldCardsList.allInnerTexts()
                .stream()
                .map(String::trim)
                .collect(Collectors.toList());
    }

    @Step("Get banner title")
    public String getBannerTitle() {
        return cardsPage.cardSecurityBanner.innerText().trim();
    }}
}
