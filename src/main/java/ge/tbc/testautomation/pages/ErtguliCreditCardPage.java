package ge.tbc.testautomation.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

import static ge.tbc.testautomation.Constants.*;

public class ErtguliCreditCardPage {
    Page page;

    public Locator
            orderCardBtn,
            nameAndSurnameInput,
            personalNumberInput,
            phoneNumberInput;

    public ErtguliCreditCardPage(Page page) {
        this.page = page;
        this.orderCardBtn = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(ORDER_CARD_TXT));
        this.nameAndSurnameInput = page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName(NAME_AND_SURNAME_TXT));
        this.personalNumberInput = page.getByRole(AriaRole.SPINBUTTON, new Page.GetByRoleOptions().setName(PERSONAL_NUMBER_TXT));
        this.phoneNumberInput = page.getByRole(AriaRole.SPINBUTTON, new Page.GetByRoleOptions().setName(PHONE_NUMBER_TXT));
    }

    public Locator getErrorMessageByText(String text) {
        return page.locator(".description.errored").filter(new Locator.FilterOptions().setHasText(text));
    }
}
