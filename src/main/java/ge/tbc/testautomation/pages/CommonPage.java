package ge.tbc.testautomation.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import static ge.tbc.testautomation.Constants.*;


public class CommonPage {
    public final Page page;

    public Locator header, desktopNav, forMeBtn, cardsBtn,
            burgerMenu, cookieAcceptBtn, cookieBanner, tbcLogo, mobileCardsBtn;

    public CommonPage(Page page) {
        this.page = page;
        this.header = page.locator(HEADER_TXT);
        this.tbcLogo = header.locator("tbcx-pw-logo");
        this.desktopNav = header.locator("tbcx-pw-navigation.show-desktop-only");
        this.forMeBtn = desktopNav.getByText(FOR_ME_TXT, new Locator.GetByTextOptions().setExact(true));
        this.cardsBtn = page.locator("a[href='/ka/cards']");
        this.cookieBanner = page.locator(".tbcx-pw-cookie-consent");
        this.cookieAcceptBtn = cookieBanner.locator(".tbcx-pw-cookie-consent__actions button").first();

        //mobile only
        this.burgerMenu = header.locator("button.tbcx-pw-hamburger-menu__button");
        this.mobileCardsBtn = page.locator(".show-until-tablet a[href='/ka/cards']:visible").first();

    }

    //MOBILE MENU
    public Locator mobileMenuGroupTitle(String title) {
        return page.locator(".show-until-tablet .tbc-accordion__title:visible")
                .filter(new Locator.FilterOptions().setHasText(title))
                .first();
    }

}