package ge.tbc.testautomation.steps;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import ge.tbc.testautomation.pages.ErtguliCreditCardPage;
import jdk.jfr.Enabled;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class ErtguliCreditCardSteps {
    ErtguliCreditCardPage ertguliCreditCardPage;

    public ErtguliCreditCardSteps(Page page) {
        this.ertguliCreditCardPage = new ErtguliCreditCardPage(page);
    }

    public ErtguliCreditCardSteps openCardOrderForm(){
        ertguliCreditCardPage.orderCardBtn.click();
        return this;
    }

    public ErtguliCreditCardSteps clickSubmitBtn(){
        ertguliCreditCardPage.submitBtn.click();
        return this;
    }

    public ErtguliCreditCardSteps typeNameAndSurname(String fullName){
        ertguliCreditCardPage.nameAndSurnameInput.fill(fullName);
        return this;
    }

    public ErtguliCreditCardSteps typePersonalNumber(String numbers){
        ertguliCreditCardPage.personalNumberInput.fill(numbers);
        return this;
    }

    public ErtguliCreditCardSteps typePhoneNumber(String phoneNumber) {
        ertguliCreditCardPage.phoneNumberInput.fill(phoneNumber);
        return this;
    }

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

    public ErtguliCreditCardSteps pasteNameAndSurname(String fullName) {
        return pasteInto(ertguliCreditCardPage.nameAndSurnameInput, fullName);
    }

    public ErtguliCreditCardSteps pastePersonalNumber(String numbers) {
        return pasteInto(ertguliCreditCardPage.personalNumberInput, numbers);
    }

    public ErtguliCreditCardSteps pastePhoneNumber(String phoneNumber) {
        return pasteInto(ertguliCreditCardPage.phoneNumberInput, phoneNumber);
    }

    public ErtguliCreditCardSteps assertErrorMessageIsVisible(String expectedText){
        assertThat(ertguliCreditCardPage.getErrorMessageByText(expectedText)).isVisible();
        assertThat(ertguliCreditCardPage.getErrorMessageByText(expectedText)).hasText(expectedText);
        return this;
    }

    public ErtguliCreditCardSteps assertSubmitButtonIsEnabled(){
        assertThat(ertguliCreditCardPage.submitBtn).isEnabled();
        return this;
    }
}
