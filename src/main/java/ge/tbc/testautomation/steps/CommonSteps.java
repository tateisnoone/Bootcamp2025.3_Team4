package ge.tbc.testautomation.steps;

import com.microsoft.playwright.Page;
import ge.tbc.testautomation.pages.CommonPage;
import io.qameta.allure.Step;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class CommonSteps {
    public final CommonPage commonPage;

    public CommonSteps(Page page) {
        this.commonPage = new CommonPage(page);
    }

    @Step
    public CommonSteps goToHome() {
        commonPage.tbcLogo.click();
        return this;
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
}