package base;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ConfigReader;

public class BaseTest {
	
	 public WebDriver driver;
	 public Properties prop;
	 public static ExtentReports extent;//generate visually appealing and informative HTML reports for test execution
	 public ExtentTest test;// logs test steps onto the previously generated HTML report
	 
	 @BeforeSuite//Executes once before all tests in the suite. 
	 public void setupExtent() {
		 String path = System.getProperty("user.dir") + "/ExtentReports/extentReport.html";
		 ExtentSparkReporter spark=new ExtentSparkReporter(path);
		 extent=new ExtentReports();
		 extent.attachReporter(spark);
	 }
	
  @BeforeMethod//marks a method to be executed before each test method within a class
  public void setup() {
	  		prop = ConfigReader.initProperties();
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.manage().window().maximize();
			driver.get(prop.getProperty("url"));
  }
  
  @AfterSuite//Executes once after all tests in the suite have run. 
  public void tearDownExtent() {
      extent.flush();
  }
  
	
	  @AfterMethod
	  public void tearDown() { if (driver != null) { driver.quit(); }
	  }
	 


}
