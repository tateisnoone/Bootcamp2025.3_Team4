package ge.tbc.testautomation.tests;

import com.microsoft.playwright.*;
import ge.tbc.testautomation.factory.BrowserFactory;
import ge.tbc.testautomation.factory.ContextOptionsFactory;
import ge.tbc.testautomation.steps.*;
import ge.tbc.testautomation.steps.apisteps.ApiSteps;
import ge.tbc.testautomation.utils.CookieUtils;
import ge.tbc.testautomation.utils.NavigationFlows;
import ge.tbc.testautomation.utils.PageManager;
import org.testng.annotations.*;

import static ge.tbc.testautomation.Constants.BASE_URL;

@Listeners({
        io.qameta.allure.testng.AllureTestNg.class,
        ge.tbc.testautomation.utils.CustomTestListener.class
})
public class BaseTest {
    protected Playwright playwright;
    protected Browser browser;
    protected BrowserContext context;
    protected Page page;
    protected String view;
    protected String browserType;

    protected CommonSteps commonSteps;
    protected CardsSteps cardsSteps;
    protected ErtguliCreditCardSteps ertguliCreditCardSteps;
    protected TbcCardSteps tbcCardSteps;
    protected ApiSteps apiSteps;

    @BeforeClass(alwaysRun = true)
    @Parameters({"browserType", "view"})
    public void setup(@Optional("chromium") String browserType,
                      @Optional("desktop") String view) {
        this.browserType = browserType;
        this.view = view;

        boolean isCi = "true".equalsIgnoreCase(System.getenv("CI"));

        try {
            playwright = Playwright.create();
            browser = BrowserFactory.launch(playwright, browserType, isCi);
            context = browser.newContext(ContextOptionsFactory.create(view, browserType));

            context.setDefaultTimeout(10_000);
            context.setDefaultNavigationTimeout(30_000);

            page = context.newPage();
            PageManager.setPage(page);
            page.navigate(BASE_URL);

            initSteps();

            CookieUtils.acceptIfVisible(page);
            new NavigationFlows(commonSteps, view).openCardsFromHome();
        } catch (Exception e) {
            tearDown();
            throw e;
        }
    }

    protected void initSteps() {
        commonSteps = new CommonSteps(page);
        cardsSteps = new CardsSteps(page);
        ertguliCreditCardSteps = new ErtguliCreditCardSteps(page);
        tbcCardSteps = new TbcCardSteps(page);
        apiSteps = new ApiSteps();
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