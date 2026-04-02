package ge.tbc.testautomation.tests;

import org.testng.annotations.Test;

@Test(groups = {"Apply for TBC Card QR code should contain correct URL T4-T1"})
public class QRCodeTest extends BaseTest {

    @Test(priority = 1)
    public void viewCardDetails(){
        cardsSteps.openCardDetails();
    }

    @Test(priority = 2)
    public void applyForTbcCard() {
        tbcCardSteps.clickOrderCardButton();
    }

    @Test(priority = 3)
    public void scanQRCode() throws Exception{
        tbcCardSteps.validateQrCode();
    }
}
