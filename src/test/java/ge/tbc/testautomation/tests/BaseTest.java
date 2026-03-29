package ge.tbc.testautomation.tests;

import com.microsoft.playwright.*;
import ge.tbc.testautomation.steps.*;
import ge.tbc.testautomation.utils.CookieUtils;
import org.testng.annotations.*;

import static ge.tbc.testautomation.Constants.BASE_URL;


@Listeners({io.qameta.allure.testng.AllureTestNg.class})
public class BaseTest {
    Playwright playwright;
    Browser browser;
    BrowserContext context;
    Page page;
    CommonSteps commonSteps;

    @BeforeClass(alwaysRun = true)
    @Parameters({"browserType"})
    public void setup(@Optional("chromium") String browserType,
                      @Optional("desktop") String view) {
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
        context = browser.newContext();
        context.setDefaultTimeout(10_000);
        context.setDefaultNavigationTimeout(30_000);
        page = context.newPage();
        page.navigate(BASE_URL);
        commonSteps = new CommonSteps(page);
        CookieUtils.acceptIfVisible(page);
    }

    @AfterClass
    public void tearDown() {
        context.close();
        page.close();
        browser.close();
        playwright.close();
    }
}
