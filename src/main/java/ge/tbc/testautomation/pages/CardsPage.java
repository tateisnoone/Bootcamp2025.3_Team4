package ge.tbc.testautomation.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class CardsPage {

    public Locator cardDetailsButton,
    header,
    otherCards,
    ertguliCardLink,
    studentsCardLink,
    pupilsCardLink,
    oldCardsTitle,
    cardSecurityBanner,
    oldCardsList;

    public CardsPage(Page page){
        this.cardDetailsButton = page.locator("button:has-text('დეტალურად')");
        this.header = page.locator(".tbcx-pw-cta-section__info__title").first();
        this.otherCards = page.getByText("სხვა ბარათები");
        this.ertguliCardLink = page.getByRole(AriaRole.LINK,
                new Page.GetByRoleOptions().setName("ერთგული საკრედიტო ბარათი"));
        this.studentsCardLink = page.getByRole(AriaRole.LINK,
                new Page.GetByRoleOptions().setName("თიბისი ბარათი სტუდენტებისთვის"));
        this.pupilsCardLink = page.getByRole(AriaRole.LINK,
                new Page.GetByRoleOptions().setName("მოსწავლის ბარათი"));
        this.oldCardsTitle = page.getByText("ძველი ბარათები");
        this.cardSecurityBanner = page.getByText("ბარათის უსაფრთხოების სერვისი");
        this.oldCardsList = page.locator(".tbcx-pw-carousel__card h2.tbcx-pw-card__title");
    }
}
