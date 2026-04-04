package ge.tbc.testautomation.factory;

import com.microsoft.playwright.Browser;

import java.util.ArrayList;
import java.util.List;

import static ge.tbc.testautomation.Constants.MOBILE;

public final class ContextOptionsFactory {

    private ContextOptionsFactory() {
    }

    public static Browser.NewContextOptions create(String view, String browserType) {
        Browser.NewContextOptions options = new Browser.NewContextOptions()
                .setPermissions(resolvePermissions(browserType));

        if (MOBILE.equalsIgnoreCase(view)) {
            options
                    .setViewportSize(390, 844)
                    .setDeviceScaleFactor(3)
                    .setIsMobile(true)
                    .setHasTouch(true)
                    .setUserAgent(
                            "Mozilla/5.0 (iPhone; CPU iPhone OS 16_0 like Mac OS X) " +
                                    "AppleWebKit/605.1.15 (KHTML, like Gecko) Version/16.0 " +
                                    "Mobile/15E148 Safari/604.1"
                    );
        } else {
            options.setViewportSize(1920, 1080);
        }

        return options;
    }

    private static List<String> resolvePermissions(String browserType) {
        List<String> permissions = new ArrayList<>();
        permissions.add("clipboard-read");

        if (supportsClipboardWrite(browserType)) {
            permissions.add("clipboard-write");
        }

        return permissions;
    }

    private static boolean supportsClipboardWrite(String browserType) {
        String normalized = browserType.toLowerCase();
        return normalized.equals("chromium")
                || normalized.equals("chrome")
                || normalized.equals("edge")
                || normalized.equals("msedge");
    }
}