package ge.tbc.testautomation.steps;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitForSelectorState;
import ge.tbc.testautomation.pages.MainPage;
import io.qameta.allure.Step;

public class MainSteps {

    private final MainPage mainPage;
    private final boolean isMobile;

    public MainSteps(Page page, boolean isMobile) {
        this.mainPage = new MainPage(page);
        this.isMobile = isMobile;
    }

    @Step("Click on Chatbot button")
    public MainSteps clickChatBot() {
        mainPage.chatBotLocator.click();
        return this;
    }

    @Step("Hover on 'For Me' menu")
    public MainSteps hoverOnForMe() {
        if (isMobile) {
            mainPage.burgerMenu.click();
        } else {
            for (int i = 0; i < 3; i++) {
                mainPage.forMeHover.hover();
                if (mainPage.moneyTransferPage.isVisible()) break;
            }
        }
        return this;
    }

    @Step("Navigate to Money Transfer page")
    public MainSteps moneyTransferPage() {
        if (isMobile) {
            mainPage.otherProducts.click();
            mainPage.moneyTransferPageMobile.click();
        } else {
            mainPage.moneyTransferPage.waitFor(new Locator.WaitForOptions()
                    .setState(WaitForSelectorState.VISIBLE));
            mainPage.moneyTransferPage.click();
        }
        return this;
    }

    @Step("Navigate to Loans page")
    public MainSteps navigateToLoansPage() {
        if (isMobile) {
            mainPage.loansPageMobile.click();
            mainPage.loansPageButton.click();
        } else {
            mainPage.loansPage.click();
        }
        return this;
    }

    @Step("Click on Consumer Loan page link")
    public MainSteps clickOnLoansPage() {
        mainPage.loanPageNavigate.click();
        return this;
    }

    @Step("Navigate to Branches page")
    public MainSteps clickBranchesPage() {
        mainPage.branchesPage.click();
        return this;
    }

    @Step("Navigate to Anonymous Tip page")
    public MainSteps AnonTipPage() {
        mainPage.anonTipPage.click();
        return this;
    }

    @Step("Click on TBC Anonymous Tip protected page link")
    public MainSteps clickTbcAnonPage() {
        mainPage.anonTbcPage.click();
        return this;
    }
}