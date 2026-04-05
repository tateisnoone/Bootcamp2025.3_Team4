package ge.tbc.testautomation.factory;

import com.microsoft.playwright.*;

import java.util.List;

public final class BrowserFactory {

    private BrowserFactory() {
    }

    public static Browser launch(Playwright playwright, String browserType, boolean isCi) {
        String normalized = browserType.toLowerCase();

        return switch (normalized) {
            case "edge", "msedge" ->
                    playwright.chromium().launch(buildChromiumOptions(isCi, "msedge"));
            case "chromium", "chrome" ->
                    playwright.chromium().launch(buildChromiumOptions(isCi, null));
            case "webkit", "safari" ->
                    playwright.webkit().launch(buildGenericOptions(isCi));
            default -> throw new IllegalArgumentException("Unsupported browserType: " + browserType);
        };
    }

    private static BrowserType.LaunchOptions buildChromiumOptions(boolean isCi, String channel) {
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

    private static BrowserType.LaunchOptions buildGenericOptions(boolean isCi) {
        return new BrowserType.LaunchOptions()
                .setHeadless(isCi);
    }
}