package ge.tbc.testautomation.tests;

import ge.tbc.testautomation.data.ErtguliFormUsersDataProvider;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


@Test(groups = {"Ertguli Card Contact Form - Pasted data should be filled correctly T4-T3"})
public class ContactFormEdgeCaseTest extends BaseTest{

    @BeforeClass(alwaysRun = true)
    public void setup() {
        cardsSteps.navigateToErtguliCreditCardPage();
    }

    @Test(description = "open order card form", priority = 1)
    public void openOrderCardForm() {
        ertguliCreditCardSteps.openCardOrderForm();
    }

    @Test(
            dataProvider = "validPastedFullFormData",
            dataProviderClass = ErtguliFormUsersDataProvider.class, priority = 2,
            description = "Order the Ertguli Credit Card"
    )
    public void fillFormData(String name, String personal, String phone) {
        ertguliCreditCardSteps
                .pasteNameAndSurname(name)
                .pastePersonalNumber(personal)
                .pastePhoneNumber(phone)
                .assertSubmitButtonIsEnabled();
    }
}