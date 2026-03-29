package ge.tbc.testautomation.utils;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitForSelectorState;
import ge.tbc.testautomation.pages.CommonPage;

public final class CookieUtils {
    private CookieUtils() {}

    public static void acceptIfVisible(Page page) {
        CommonPage common = new CommonPage(page);
        try {
            common.cookieBanner.waitFor(new com.microsoft.playwright.Locator.WaitForOptions()
                    .setState(WaitForSelectorState.VISIBLE)
                    .setTimeout(3_000));
            common.cookieAcceptBtn.click();
        } catch (RuntimeException ignored) {
        }
    }
}