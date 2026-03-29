package ge.tbc.testautomation.steps;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import ge.tbc.testautomation.pages.CardsPage;
import io.qameta.allure.Step;

public class CardsSteps {
    CardsPage cardsPage;

    public CardsSteps(Page page) {cardsPage = new CardsPage(page);}

    @Step
    public CardsSteps openCardDetails(){
        cardsPage.cardDetailsButton.click();
        return this;
    }
}
