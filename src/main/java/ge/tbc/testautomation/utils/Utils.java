package ge.tbc.testautomation.utils;

import com.microsoft.playwright.Page;

import java.math.BigDecimal;
import java.math.RoundingMode;


import static org.testng.Assert.assertTrue;

public class Utils {
    protected Page page;

    public Utils(Page page) {
        this.page = page;
    }

    public Utils bottomScroll() {
        page.evaluate("window.scrollTo(0, document.body.scrollHeight)");
        return this;
    }

    public static BigDecimal extractNumber(String text) {
        String cleaned = text.replaceAll("[^0-9.]", "");
        return new BigDecimal(cleaned);
    }

    public static void verifyConversion(BigDecimal input, BigDecimal output) {

        BigDecimal effectiveRate =
                output.divide(input, 6, RoundingMode.HALF_UP);

        assertTrue(output.compareTo(BigDecimal.ZERO) > 0,
                "Output amount must be positive");
    }
}