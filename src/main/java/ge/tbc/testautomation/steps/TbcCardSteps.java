package ge.tbc.testautomation.steps;

import com.microsoft.playwright.Page;
import ge.tbc.testautomation.pages.TbcCardPage;
import ge.tbc.testautomation.utils.QRReader;
import io.qameta.allure.Step;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static ge.tbc.testautomation.Constants.QR_CODE_DATA;
import static org.testng.AssertJUnit.assertEquals;

public class TbcCardSteps {
    TbcCardPage tbcCardPage;
    public TbcCardSteps(Page page){tbcCardPage = new TbcCardPage(page);}

    @Step
    public TbcCardSteps clickOrderCardButton(){
        tbcCardPage.orderCardButton.click();

        return this;
    }

    //Desktop Only
    @Step
    public TbcCardSteps validateQrCode() throws Exception {
        assertThat(tbcCardPage.qrCode).isVisible();
        byte[] qrCodeScreenshot = tbcCardPage.qrCode.screenshot();
        String qrData = QRReader.readQR(qrCodeScreenshot);
        assertEquals(QR_CODE_DATA, qrData);

        return this;
    }
}
