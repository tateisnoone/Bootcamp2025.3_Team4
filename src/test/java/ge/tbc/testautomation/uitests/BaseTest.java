package ge.tbc.testautomation.uitests;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.Geolocation;
import ge.tbc.testautomation.utils.MobileDevice;
import ge.tbc.testautomation.steps.*;
import ge.tbc.testautomation.utils.Utils;
import org.testng.annotations.*;

import static ge.tbc.testautomation.data.Constants.*;

public class BaseTest {

    protected Playwright playwright;
    protected Browser browser;
    protected BrowserContext context;
    protected Page page;
    protected boolean isMobile;
    protected String browserName;

    protected Utils utils;
    protected ChatBotSteps chatBotSteps;
    protected MainSteps mainSteps;
    protected AnonymousTipSteps anonymousTipSteps;

    @BeforeClass
    @Parameters({"browser", "device"})
    public void setUp(
            @Optional("chrome") String browserName,
            @Optional("desktop") String device
    ) {
        this.browserName = browserName;
        playwright = Playwright.create();

        BrowserType.LaunchOptions launchOptions = new BrowserType.LaunchOptions()
                .setHeadless(false);

        if (device.equalsIgnoreCase("desktop") && browserName.equalsIgnoreCase("chrome")) {
            launchOptions.setArgs(java.util.List.of("--start-maximized"));
        }

        browser = switch (browserName.toLowerCase()) {
            case "firefox" -> playwright.firefox().launch(launchOptions);
            case "webkit" -> playwright.webkit().launch(launchOptions);
            default -> playwright.chromium().launch(launchOptions);
        };

        Browser.NewContextOptions contextOptions;

        if (device.equalsIgnoreCase("mobile") && !browserName.equalsIgnoreCase("firefox")) {
            isMobile = true;
            contextOptions = new Browser.NewContextOptions()
                    .setViewportSize(MobileDevice.IPHONE_12_PRO.width, MobileDevice.IPHONE_12_PRO.height)
                    .setUserAgent(MobileDevice.IPHONE_12_PRO.userAgent)
                    .setDeviceScaleFactor(MobileDevice.IPHONE_12_PRO.scaleFactor)
                    .setIsMobile(true)
                    .setHasTouch(true);
        } else {
            isMobile = false;
            contextOptions = new Browser.NewContextOptions();

            switch (browserName.toLowerCase()) {
                case "webkit" ->
                        contextOptions.setViewportSize(1920, 1080);
                default ->
                        contextOptions.setViewportSize(null);
            }
        }

        context = browser.newContext(contextOptions);
        page = context.newPage();

        if (browserName.equalsIgnoreCase("firefox") && device.equalsIgnoreCase("desktop")) {
            page.evaluate("window.moveTo(0,0); window.resizeTo(screen.width, screen.height);");
        }

        page.navigate(TBC_URL);

        utils = new Utils(page);
        chatBotSteps = new ChatBotSteps(page);
        mainSteps = new MainSteps(page, isMobile);
        anonymousTipSteps = new AnonymousTipSteps(page);
    }

    @AfterClass
    public void tearDown() {
        if (context != null) context.close();
        if (browser != null) browser.close();
        if (playwright != null) playwright.close();
    }
}