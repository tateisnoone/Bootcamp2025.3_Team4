package ge.tbc.testautomation.steps;

import com.microsoft.playwright.Page;
import ge.tbc.testautomation.pages.AnonymousTipPage;
import io.qameta.allure.Step;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class AnonymousTipSteps {

    private final AnonymousTipPage anonymousTipPage;

    public AnonymousTipSteps(Page page) {
        this.anonymousTipPage = new AnonymousTipPage(page);
    }

    @Step("Select 'Stay Anonymous' option")
    public AnonymousTipSteps clickOnStayAnonymous() {
        anonymousTipPage.anonymousRequest.click();
        return this;
    }

    @Step("Enter reporter email: '{email}'")
    public AnonymousTipSteps inputEmail(String email) {
        anonymousTipPage.emailInput.fill(email);
        return this;
    }

    @Step("Select TBC Bank branch location")
    public AnonymousTipSteps selectLocation() {
        anonymousTipPage.location.click();
        return this;
    }

    @Step("Select first {count} incident type checkboxes")
    public AnonymousTipSteps clickOnIncidents(int count) {
        int total = anonymousTipPage.incidentType.count();
        for (int i = 0; i < count && i < total; i++) {
            anonymousTipPage.incidentByIndex(i).click();
        }
        return this;
    }

    @Step("Fill in incident details: '{details}'")
    public AnonymousTipSteps inputDetails(String details) {
        anonymousTipPage.incidentDetails.fill(details);
        return this;
    }

    @Step("Submit anonymous tip form")
    public AnonymousTipSteps submit() {
        anonymousTipPage.submitButton.click();
        return this;
    }

    @Step("Verify submission confirmation message is visible")
    public AnonymousTipSteps submissionValidation() {
        assertThat(anonymousTipPage.validationMessage).isVisible();
        return this;
    }
}