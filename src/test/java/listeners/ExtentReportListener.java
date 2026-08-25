package listeners;

import basepackage.BaseTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class ExtentReportListener implements ITestListener {

    private ExtentReports extent;
    private ExtentTest test;

    @Override
    public void onStart(ITestContext context) {

        ExtentSparkReporter reporter =
                new ExtentSparkReporter(
                        "test-output/ExtentReport.html"
                );

        extent = new ExtentReports();

        extent.attachReporter(reporter);

        extent.setSystemInfo(
                "OS",
                System.getProperty("os.name")
        );

        extent.setSystemInfo(
                "Java",
                System.getProperty("java.version")
        );

        extent.setSystemInfo(
                "Browser",
                "Chrome"
        );
    }

    @Override
    public void onTestStart(ITestResult result) {

        test = extent.createTest(
                result.getMethod().getMethodName(),
                result.getMethod().getDescription()
        );

        test.info("Test Started");
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        test.pass("Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        test.fail("Test Failed");

        test.fail(result.getThrowable());

        System.out.println(
                "===== Test Failed: "
                        + result.getMethod().getMethodName()
                        + " ====="
        );

        try {

            // Take screenshot
            TakesScreenshot screenshot =
                    (TakesScreenshot) BaseTest.driver;

            File source =
                    screenshot.getScreenshotAs(
                            OutputType.FILE
                    );

            // Create screenshots folder
            File screenshotFolder =
                    new File("test-output/screenshots");

            if (!screenshotFolder.exists()) {
                screenshotFolder.mkdirs();
            }

            // Screenshot name
            String fileName =
                    result.getMethod().getMethodName()
                            + "_"
                            + System.currentTimeMillis()
                            + ".png";

            File destination =
                    new File(
                            screenshotFolder,
                            fileName
                    );

            // Copy screenshot
            Files.copy(
                    source.toPath(),
                    destination.toPath(),
                    StandardCopyOption.REPLACE_EXISTING
            );

            System.out.println(
                    "Screenshot saved: "
                            + destination.getAbsolutePath()
            );

            // Add screenshot to Extent Report
            test.addScreenCaptureFromPath(
                    destination.getAbsolutePath()
            );

        } catch (Exception e) {

            System.out.println(
                    "Screenshot capture failed: "
                            + e.getMessage()
            );

            test.warning(
                    "Screenshot capture failed: "
                            + e.getMessage()
            );
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {

        test.skip("Test Skipped");
    }

    @Override
    public void onFinish(ITestContext context) {

        extent.flush();

        System.out.println(
                "===== Extent Report Generated ====="
        );
    }
}