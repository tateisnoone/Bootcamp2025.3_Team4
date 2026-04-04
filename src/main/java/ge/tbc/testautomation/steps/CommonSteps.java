package ge.tbc.testautomation.steps;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import ge.tbc.testautomation.pages.CommonPage;
import io.qameta.allure.Step;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static ge.tbc.testautomation.data.Constants.*;

public class CommonSteps {
    public final CommonPage commonPage;

    public CommonSteps(Page page) {
        this.commonPage = new CommonPage(page);
    }

    @Step
    public CommonSteps openForMe() {
        commonPage.forMeBtn.click();
        return this;
    }

    @Step
    public CommonSteps goToCards() {
        assertThat(commonPage.cardsBtn).isVisible();
        commonPage.cardsBtn.click();
        return this;
    }

    // Mobile Flow

    @Step
    public CommonSteps openBurgerMenu() {
        commonPage.burgerMenu.click();
        return this;
    }

    @Step
    public CommonSteps goToCardsFromCardsGroupMobile() {
        commonPage.mobileCardsBtn.click();
        return this;
    }


    @Step
    public CommonSteps openCardsGroupMobile() {
        commonPage.mobileMenuGroupTitle(CARDS_TXT).click();
        return this;
    }

    @Step
    public CommonSteps assertCardsLinkVisibleMobile() {
        assertThat(commonPage.mobileCardsBtn).isVisible();
        return this;
    }

    public boolean isCardsBtnVisibleMobile() {
        return commonPage.mobileCardsBtn.isVisible(new Locator.IsVisibleOptions().setTimeout(1500));
    }
}