package ge.tbc.testautomation.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class AnonymousTipPage {

    private final Page page;

    public Locator
            anonymousRequest,
            emailInput,
            location,
            incidentType,
            incidentDetails,
            validationMessage,
            submitButton;

    public AnonymousTipPage(Page page) {
        this.page = page;
        this.anonymousRequest = page.getByText("მსურს დავრჩე ანონიმად").first();
        this.emailInput = page.locator("span.form-sub-label-container > input.form-textbox");
        this.location = page.getByText("თიბისი ბანკი").first();
        this.incidentType = page.locator("span.form-checkbox-item");
        this.incidentDetails = page.locator(".form-textarea");
        this.validationMessage = page.getByText("თქვენი განაცხადი გაგზავნილია.");
        this.submitButton = page.locator("#input_2");
    }

    public Locator incidentByIndex(int index) {
        return incidentType.nth(index);
    }

}