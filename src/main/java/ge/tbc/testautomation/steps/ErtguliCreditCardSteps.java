package ge.tbc.testautomation.steps;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import ge.tbc.testautomation.pages.ErtguliCreditCardPage;
import io.qameta.allure.Step;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class ErtguliCreditCardSteps {
    ErtguliCreditCardPage ertguliCreditCardPage;

    public ErtguliCreditCardSteps(Page page) {
        this.ertguliCreditCardPage = new ErtguliCreditCardPage(page);
    }

    @Step
    public ErtguliCreditCardSteps openCardOrderForm() {
        ertguliCreditCardPage.orderCardBtn.click();
        return this;
    }

    @Step
    public ErtguliCreditCardSteps typeNameAndSurname(String fullName) {
        ertguliCreditCardPage.nameAndSurnameInput.fill(fullName);
        return this;
    }

    @Step
    public ErtguliCreditCardSteps typePersonalNumber(String numbers) {
        ertguliCreditCardPage.personalNumberInput.fill(numbers);
        return this;
    }

    @Step
    public ErtguliCreditCardSteps typePhoneNumber(String phoneNumber) {
        ertguliCreditCardPage.phoneNumberInput.fill(phoneNumber);
        return this;
    }

    @Step
    public ErtguliCreditCardSteps clearNameAndSurnameInput() {
        ertguliCreditCardPage.nameAndSurnameInput.clear();
        return this;
    }

    @Step
    public ErtguliCreditCardSteps clearPersonalNumberInput() {
        ertguliCreditCardPage.personalNumberInput.clear();
        return this;
    }

    @Step
    public ErtguliCreditCardSteps clearPhoneNumberInput() {
        ertguliCreditCardPage.phoneNumberInput.clear();
        return this;
    }

    @Step
    private ErtguliCreditCardSteps pasteInto(Locator locator, String value) {
        locator.click();

        ertguliCreditCardPage.page.evaluate(
                "text => navigator.clipboard.writeText(text)", value
        );

        String pasteShortcut = System.getProperty("os.name").toLowerCase().contains("mac")
                ? "Meta+V"
                : "Control+V";

        ertguliCreditCardPage.page.keyboard().press(pasteShortcut);

        return this;
    }

    @Step
    public ErtguliCreditCardSteps pasteNameAndSurname(String fullName) {
        return pasteInto(ertguliCreditCardPage.nameAndSurnameInput, fullName);
    }

    @Step
    public ErtguliCreditCardSteps pastePersonalNumber(String numbers) {
        return pasteInto(ertguliCreditCardPage.personalNumberInput, numbers);
    }

    @Step
    public ErtguliCreditCardSteps pastePhoneNumber(String phoneNumber) {
        return pasteInto(ertguliCreditCardPage.phoneNumberInput, phoneNumber);
    }

    @Step
    public ErtguliCreditCardSteps assertErrorMessageIsVisible(String expectedText) {
        assertThat(ertguliCreditCardPage.getErrorMessageByText(expectedText)).isVisible();
        assertThat(ertguliCreditCardPage.getErrorMessageByText(expectedText)).hasText(expectedText);
        return this;
    }

    @Step
    public ErtguliCreditCardSteps assertSubmitButtonIsEnabled() {
        assertThat(ertguliCreditCardPage.submitBtn).isEnabled();
        return this;
    }
}
