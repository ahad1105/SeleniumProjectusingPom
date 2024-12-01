package base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.configuration.Theme;
import java.lang.reflect.Method;
import io.github.bonigarcia.wdm.WebDriverManager;
import utils.Constants;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import java.io.File;
import java.time.Duration;

public class BaseTest {

	public static WebDriver driver;
	public static ExtentSparkReporter sparkReporter;
	public static ExtentReports extent;
	public  static ExtentTest logger;
	
	
	//@BeforeSuite(alwaysRun = true)
	@BeforeSuite
	public void setupExtentReports() {
		if (extent == null) { // Ensure only one instance of ExtentReports
            sparkReporter = new ExtentSparkReporter(
                System.getProperty("user.dir") + File.separator + "reports" + File.separator + "AutomationResults.html"
            );
            extent = new ExtentReports();
            extent.attachReporter(sparkReporter);

            sparkReporter.config().setTheme(Theme.DARK);
            sparkReporter.config().setDocumentTitle("Automation Report");
            sparkReporter.config().setReportName("Automation Tests Results by Ahad Khan");

            extent.setSystemInfo("Host Name", "RHELB");
            extent.setSystemInfo("Username", "root");
    }
	}

	@BeforeTest
	@Parameters("browser")
	public void beforeTestMethod(@Optional("chrome") String browser) {  // Default to "chrome" if not provided
	    // Initialize the browser once before all tests
	    setupDriver(browser);
	    driver.manage().window().maximize();
	    driver.get(Constants.url);
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	public void setupDriver(String browser) {
	    if (browser.equalsIgnoreCase("chrome")) {
	        WebDriverManager.chromedriver().setup();
	        driver = new ChromeDriver();
	    } else if (browser.equalsIgnoreCase("firefox")) {
	        WebDriverManager.firefoxdriver().setup();
	        driver = new FirefoxDriver();
	    } else if (browser.equalsIgnoreCase("edge")) {
	        WebDriverManager.edgedriver().setup();
	        driver = new EdgeDriver();
	    }
	}

	@BeforeMethod
	public void beforeMethod(Method testMethod) {
		
		if (extent == null) {
            throw new IllegalStateException("ExtentReports is not initialized. Please check @BeforeSuite setup.");
        }
	    logger = extent.createTest(testMethod.getName());
	}
	
	
	

	@AfterMethod
	public void afterMethod(ITestResult result) {
	    if (result.getStatus() == ITestResult.FAILURE) {
	        logger.log(Status.FAIL,
	                MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
	        logger.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable().getMessage(), ExtentColor.RED));
	    } else if (result.getStatus() == ITestResult.SKIP) {
	        logger.log(Status.SKIP,
	                MarkupHelper.createLabel(result.getName() + " - Test Case Skipped", ExtentColor.ORANGE));
	    } else if (result.getStatus() == ITestResult.SUCCESS) {
	        logger.log(Status.PASS,
	                MarkupHelper.createLabel(result.getName() + " - Test Case PASS", ExtentColor.GREEN));
	    }
	}

	@AfterTest
	public void afterTest() {
	    extent.flush();
	    driver.quit();  // Close the browser after all tests
	}
}