package ge.tbc.testautomation.utils;

import com.microsoft.playwright.Page;
import io.qameta.allure.Attachment;

public class AllureAttachments {

    @Attachment(value = "Failure screenshot", type = "image/png")
    public static byte[] attachScreenshot(byte[] screenshot) {
        return screenshot;
    }

    @Attachment(value = "Current URL", type = "text/plain")
    public static String attachUrl(String url) {
        return url;
    }

    @Attachment(value = "Failure details", type = "text/plain")
    public static String attachFailureDetails(String details) {
        return details;
    }

    public static void attachPageState(Page page, Throwable throwable) {
        if (page == null) {
            attachFailureDetails("Page was null. Throwable: " +
                    (throwable == null ? "n/a" : throwable.getMessage()));
            return;
        }

        try {
            byte[] screenshot = page.screenshot(new Page.ScreenshotOptions().setFullPage(true));
            attachScreenshot(screenshot);
        } catch (Exception e) {
            attachFailureDetails("Could not take screenshot: " + e.getMessage());
        }

        try {
            attachUrl(page.url());
        } catch (Exception e) {
            attachFailureDetails("Could not get page URL: " + e.getMessage());
        }

        if (throwable != null) {
            attachFailureDetails(throwable.toString());
        }
    }
}