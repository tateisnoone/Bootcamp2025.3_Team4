package ge.tbc.testautomation.steps;

import com.microsoft.playwright.Page;
import ge.tbc.testautomation.pages.ErtguliCreditCardPage;

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

    public ErtguliCreditCardSteps typeNameAndSurname(String fullName){
        ertguliCreditCardPage.nameAndSurnameInput.fill(fullName);
        return this;
    }

    public ErtguliCreditCardSteps typePersonalNumber(String numbers){
        ertguliCreditCardPage.personalNumberInput.pressSequentially(numbers);
        return this;
    }

    public ErtguliCreditCardSteps typePhoneNumber(String phoneNumber) {
        ertguliCreditCardPage.phoneNumberInput.pressSequentially(phoneNumber);
        return this;
    }

    public ErtguliCreditCardSteps assertErrorMessageIsVisible(String expectedText){
        assertThat(ertguliCreditCardPage.getErrorMessageByText(expectedText)).isVisible();
        assertThat(ertguliCreditCardPage.getErrorMessageByText(expectedText)).hasText(expectedText);
        return this;
    }
}
