package ge.tbc.testautomation.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class TbcCardPage {

    public Locator orderCardButton, qrCode, faqDropdowns, faqDropdownContent;

    public TbcCardPage(Page page){
        this.orderCardButton = page.locator("tbcx-pw-cta")
                .getByRole(AriaRole.BUTTON, new Locator.GetByRoleOptions().setName("აიღე ბარათი"));

        this.faqDropdowns = page.locator("tbcx-pw-accordion div.tbc-accordion__title");
        this.faqDropdownContent = page.locator("tbcx-pw-accordion div.tbc-accordion__wrapper");
        //DESKTOP ONLY
        this.qrCode = page.locator("canvas.tbcx-pw-app-download-banner-popup__qr");
    }
}
