package ge.tbc.testautomation.tests;

import com.microsoft.playwright.*;
import ge.tbc.testautomation.steps.*;
import ge.tbc.testautomation.steps.apisteps.ApiSteps;
import ge.tbc.testautomation.utils.CookieUtils;
import ge.tbc.testautomation.utils.NavigationFlows;
import ge.tbc.testautomation.utils.PageManager;
import org.testng.annotations.*;

import java.util.List;

import static ge.tbc.testautomation.Constants.BASE_URL;
import static ge.tbc.testautomation.Constants.MOBILE;

@Listeners({
        io.qameta.allure.testng.AllureTestNg.class,
        ge.tbc.testautomation.utils.CustomTestListener.class
})
public class BaseTest {
    Playwright playwright;
    Browser browser;
    BrowserContext context;
    Page page;
    String view;

    CommonSteps commonSteps;
    CardsSteps cardsSteps;
    ErtguliCreditCardSteps ertguliCreditCardSteps;
    TbcCardSteps tbcCardSteps;
    ApiSteps apiSteps;

    @BeforeClass(alwaysRun = true)
    @Parameters({"browserType", "view"})
    public void setup(@Optional("chromium") String browserType,
                      @Optional("desktop") String view) {
        this.view = view;
        boolean isCi = "true".equalsIgnoreCase(System.getenv("CI"));

        playwright = Playwright.create();
        browser = launchBrowser(browserType, isCi);

        context = browser.newContext(buildContextOptions(view));
        context.setDefaultTimeout(10_000);
        context.setDefaultNavigationTimeout(30_000);

        page = context.newPage();
        PageManager.setPage(page);
        page.navigate(BASE_URL);

        commonSteps = new CommonSteps(page);
        cardsSteps = new CardsSteps(page);
        ertguliCreditCardSteps = new ErtguliCreditCardSteps(page);
        tbcCardSteps = new TbcCardSteps(page);
        apiSteps = new ApiSteps();

        CookieUtils.acceptIfVisible(page);
        new NavigationFlows(commonSteps, view).openCardsFromHome();
    }

    private Browser launchBrowser(String browserType, boolean isCi) {
        BrowserType.LaunchOptions launchOptions = new BrowserType.LaunchOptions();
    launchOptions.setSlowMo(3000);
        if (isCi) {
            launchOptions
                    .setHeadless(true)
                    .setArgs(List.of(
                            "--headless=new",
                            "--no-sandbox",
                            "--disable-dev-shm-usage"
                    ));
        } else {
            launchOptions.setHeadless(false);
        }

        return switch (browserType.toLowerCase()) {
            case "webkit" -> playwright.webkit().launch(launchOptions);
            case "edge", "msedge" -> {
                BrowserType.LaunchOptions edgeOptions = new BrowserType.LaunchOptions()
                        .setChannel("msedge");
                if (isCi) {
                    edgeOptions
                            .setHeadless(true)
                            .setArgs(List.of(
                                    "--headless=new",
                                    "--no-sandbox",
                                    "--disable-dev-shm-usage"
                            ));
                } else {
                    edgeOptions.setHeadless(false);
                }

                yield playwright.chromium().launch(edgeOptions);
            }

            case "chromium", "chrome" -> playwright.chromium().launch(launchOptions);

            default -> throw new IllegalArgumentException("Unsupported browserType: " + browserType);
        };
    }

    private Browser.NewContextOptions buildContextOptions(String view) {
        Browser.NewContextOptions options = new Browser.NewContextOptions()
                .setPermissions(List.of("clipboard-read", "clipboard-write"));

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

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        if (page != null) page.close();
        if (context != null) context.close();
        if (browser != null) browser.close();
        if (playwright != null) playwright.close();
        PageManager.clear();
    }
}