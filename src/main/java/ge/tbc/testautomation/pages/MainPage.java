package ge.tbc.testautomation.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class MainPage {

    private final Page page;

    public Locator chatBotLocator, forMeHover, moneyTransferPage, loansPage, loanPageNavigate,
            branchesPage, anonTipPage, anonTbcPage, burgerMenu, otherProducts,
            moneyTransferPageMobile, loansPageMobile, loansPageButton
            ;


    public MainPage(Page page) {
        this.page = page;
        this.chatBotLocator = page.getByText("ჩატბოტი");
        this.forMeHover = page.locator("div[tbcxpwlinklabel]").getByText("ჩემთვის");
        this.moneyTransferPage = page.locator("a[href*='money-transfers']").first();
        this.loansPage = page.getByText("სამომხმარებლო");
        this.loanPageNavigate = page.locator("a[href*='consumer-loan/digital']");
        this.branchesPage = page.locator("//a[contains(text(), 'მისამართები')]");
        this.anonTipPage = page.locator("//a[contains(text(), ' ანონიმური მხილება ')]");
        this.anonTbcPage = page.locator("a[href*='anonymous-hotline']")
                .filter(new Locator.FilterOptions()
                        .setHasText("დაცული ვებ გვერდი"));
        this.burgerMenu = page.locator("tbcx-pw-hamburger-menu button");
        this.otherProducts = page.getByText("სხვა პროდუქტები").last();
        this.moneyTransferPageMobile = page.getByText("ფულადი გზავნილები").last();
        this.loansPageMobile = page.locator("span.tbcx-pw-mega-menu-sub-item__title:text-is('სესხები')").last();
        this.loansPageButton = page.locator("span.tbcx-pw-mega-menu-sub-item__title:text-is('სამომხმარებლო')").last();
    }
}