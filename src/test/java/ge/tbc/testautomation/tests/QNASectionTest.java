package ge.tbc.testautomation.tests;

import org.testng.annotations.Test;

@Test(groups = {"Cards - Q&A section should display answers T4-T5"})
public class QNASectionTest extends BaseTest{

    @Test(priority = 1)
    public void viewCardDetails(){
        cardsSteps.openCardDetails();
    }

    @Test(priority = 2,
            description = "Expands FAQ Dropdown and Validates Inner Content for Text")
    public void validateFAQContent(){
        tbcCardSteps
                .expandFaqDropdowns()
                .verifyFaqDropdownContent();
    }
}
