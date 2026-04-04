package ge.tbc.testautomation.factory;

import com.microsoft.playwright.*;

import java.util.List;

public final class BrowserFactory {

    private BrowserFactory() {
    }

    public static Browser launch(Playwright playwright, String browserType, boolean isCi) {
        return switch (browserType.toLowerCase()) {
            case "webkit" -> playwright.webkit().launch(buildLaunchOptions(isCi, null));
            case "edge", "msedge" -> playwright.chromium().launch(buildLaunchOptions(isCi, "msedge"));
            case "chromium", "chrome" -> playwright.chromium().launch(buildLaunchOptions(isCi, null));
            default -> throw new IllegalArgumentException("Unsupported browserType: " + browserType);
        };
    }

    private static BrowserType.LaunchOptions buildLaunchOptions(boolean isCi, String channel) {
        BrowserType.LaunchOptions options = new BrowserType.LaunchOptions();

        if (channel != null) {
            options.setChannel(channel);
        }

        if (isCi) {
            options.setHeadless(true);
            options.setArgs(List.of(
                    "--headless=new",
                    "--no-sandbox",
                    "--disable-dev-shm-usage"
            ));
        } else {
            options.setHeadless(false);
        }

        return options;
    }
}