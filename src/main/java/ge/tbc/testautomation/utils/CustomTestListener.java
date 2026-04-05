package ge.tbc.testautomation.utils;

import com.microsoft.playwright.Page;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.IConfigurationListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.time.LocalDateTime;

public class CustomTestListener implements ITestListener, IConfigurationListener {
    private static final Logger logger = LogManager.getLogger(CustomTestListener.class);

    @Override
    public void onTestFailure(ITestResult result) {
        logger.error("TEST FAILED: {} at {}", result.getName(), LocalDateTime.now(), result.getThrowable());

        Page page = PageManager.getPage();
        AllureAttachments.attachStage("TEST FAILURE: " + result.getMethod().getMethodName());
        AllureAttachments.attachPageState(page, result.getThrowable());
    }

    @Override
    public void onConfigurationFailure(ITestResult result) {
        logger.error(
                "CONFIGURATION FAILED: {}.{} at {}",
                result.getTestClass().getName(),
                result.getMethod().getMethodName(),
                LocalDateTime.now(),
                result.getThrowable()
        );

        Page page = PageManager.getPage();
        AllureAttachments.attachStage("CONFIGURATION FAILURE: " + result.getMethod().getMethodName());
        AllureAttachments.attachPageState(page, result.getThrowable());
    }
}