package ge.tbc.testautomation.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import ge.tbc.testautomation.Constants;

public class CardsPage {

    public Locator cardDetailsButton,
            header,
            otherCards,
            ertguliCardLink,
            studentsCardLink,
            pupilsCardLink,
            oldCardsTitle,
            cardSecurityBanner,
            oldCardsList,
            ertguliCardTitle,
            studentsCardTitle,
            pupilsCardTitle,
            ctaListItems;

    public CardsPage(Page page) {
        this.cardDetailsButton = page.locator("button:has-text('დეტალურად')");
        this.header = page.locator(".tbcx-pw-cta-section__info__title").first();
        this.otherCards = page.getByText(Constants.OTHER_CARDS);
        this.ertguliCardLink = page.getByRole(AriaRole.LINK,
                new Page.GetByRoleOptions().setName(Constants.LOYAL_CARD));
        this.studentsCardLink = page.getByRole(AriaRole.LINK,
                new Page.GetByRoleOptions().setName(Constants.STUDENTS_CARD));
        this.pupilsCardLink = page.getByRole(AriaRole.LINK,
                new Page.GetByRoleOptions().setName(Constants.PUPILS_CARD));
        this.oldCardsTitle = page.getByText(Constants.OLD_CARDS);
        this.cardSecurityBanner = page.getByText(Constants.CARD_SAFETY_SERVICES);
        this.oldCardsList = page.locator(".tbcx-pw-carousel__card h2.tbcx-pw-card__title");
        this.ertguliCardTitle = ertguliCardLink.locator("h2");
        this.studentsCardTitle = studentsCardLink.locator("h2");
        this.pupilsCardTitle = pupilsCardLink.locator("h2");
        this.ctaListItems = page.locator(".tbcx-pw-list")
                .first()
                .locator(".tbcx-list-item__text");
    }
}

