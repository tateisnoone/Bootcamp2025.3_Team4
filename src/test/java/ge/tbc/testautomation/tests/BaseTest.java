package ge.tbc.testautomation.tests;

import com.microsoft.playwright.*;
import ge.tbc.testautomation.steps.*;
import ge.tbc.testautomation.steps.apisteps.ApiSteps;
import ge.tbc.testautomation.utils.CookieUtils;
import ge.tbc.testautomation.utils.NavigationFlows;
import org.testng.annotations.*;

import static ge.tbc.testautomation.Constants.BASE_URL;
import static ge.tbc.testautomation.Constants.MOBILE;


@Listeners({io.qameta.allure.testng.AllureTestNg.class})
public class BaseTest {
    Playwright playwright;
    Browser browser;
    BrowserContext context;
    Page page;
    String view;
    //STEPS
    CommonSteps commonSteps;
    CardsSteps cardsSteps;
    TbcCardSteps tbcCardSteps;
    ApiSteps apiSteps;

    @BeforeClass(alwaysRun = true)
    @Parameters({"browserType", "view"})
    public void setup(@Optional("chromium") String browserType,
                      @Optional("desktop") String view) {
        this.view = view;
        playwright = Playwright.create();
        BrowserType.LaunchOptions launchOptions = new BrowserType.LaunchOptions()
                .setHeadless(false);
        browser = switch (browserType.toLowerCase()) {
            case "webkit" -> playwright.webkit().launch(launchOptions);
            case "edge", "msedge" -> playwright.chromium().launch(
                    new BrowserType.LaunchOptions()
                            .setHeadless(false)
                            .setChannel("msedge")
            );
            case "chrome", "chromium" -> playwright.chromium().launch(launchOptions);
            default -> throw new IllegalArgumentException("Unsupported browserType: " + browserType);
        };
        context = browser.newContext(buildContextOptions(view));
        context.setDefaultTimeout(10_000);
        context.setDefaultNavigationTimeout(30_000);
        page = context.newPage();
        page.navigate(BASE_URL);

        commonSteps = new CommonSteps(page);
        cardsSteps = new CardsSteps(page);
        tbcCardSteps = new TbcCardSteps(page);
        apiSteps = new ApiSteps();
        CookieUtils.acceptIfVisible(page);
        new NavigationFlows(commonSteps, view).openCardsFromHome();
    }

    private Browser.NewContextOptions buildContextOptions(String view) {
        Browser.NewContextOptions options = new Browser.NewContextOptions();

        if (MOBILE.equalsIgnoreCase(view)) {
            options
                    .setViewportSize(390, 844)
                    .setDeviceScaleFactor(3)
                    .setIsMobile(true)
                    .setHasTouch(true)
                    .setUserAgent("Mozilla/5.0 (iPhone; CPU iPhone OS 16_0 like Mac OS X) " +
                            "AppleWebKit/605.1.15 (KHTML, like Gecko) Version/16.0 " +
                            "Mobile/15E148 Safari/604.1");
        } else {
            options.setViewportSize(1920, 1080);
        }

        return options;
    }


    @AfterClass
    public void tearDown() {
        context.close();
        page.close();
        browser.close();
        playwright.close();
    }
}
