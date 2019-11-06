package tests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.LandingPage;
import pages.OpinionLabPage;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class FeedBack_SideBar_Test {
	
	protected WebDriver driver;
	protected LandingPage landingPage;
	protected OpinionLabPage opinionLabPage;
	protected String parentHandle;

	@BeforeTest
	public void setUp() throws Exception  {

		Properties browserConfigProps = new Properties();

		FileInputStream file = new FileInputStream("config.cfg");

		browserConfigProps.load(file);
		
		String browserType = browserConfigProps.getProperty("browser");

		if (browserType.equalsIgnoreCase("CHROME")) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--start-maximized");
			//options.addArguments("--headless");
			
			File chromeDriver_Directory = new File("C:\\Users\\Saighi Ilyass\\Desktop\\Web Automation\\WebDrivers\\chromedriver.exe");
			System.setProperty("webdriver.chrome.driver", chromeDriver_Directory.getAbsolutePath());
			driver = new ChromeDriver(options);
			
		
		}else if(browserType.equalsIgnoreCase("FIREFOX")) {
			
			File firefoxDriver_Directory = new File("C:\\Users\\Saighi Ilyass\\Desktop\\Web Automation\\WebDrivers\\geckodriver.exe");
			System.setProperty("webdriver.gecko.driver", firefoxDriver_Directory.getAbsolutePath());
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
		}
		
		driver.get("https://www.chapters.indigo.ca/en-ca/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		landingPage = PageFactory.initElements(driver, LandingPage.class);
		parentHandle = driver.getWindowHandle();
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}


	@Test(priority = 1, groups = {"Regression", "Smoke", "Sanity"})
	public void websiteFeedBack_opening() {

		String actualLandingP_Title = landingPage.getTitle();
		Assert.assertEquals(actualLandingP_Title,"Canada's Biggest Bookstore: Buy Books, Toys, Electronics, Paper Stationery, Home Decor & More | chapters.indigo.ca");

		landingPage.popUpClosing();
		landingPage.select_webStite_feedBack();

		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}

		opinionLabPage = PageFactory.initElements(driver, OpinionLabPage.class);

		String actualOpinionLabP_Title = opinionLabPage.getTitle();
		Assert.assertEquals(actualOpinionLabP_Title,"OpinionLab: Please Provide Your Feedback");
	}

	@Test(priority = 2,dependsOnMethods = "websiteFeedBack_opening", groups = {"Regression", "Smoke", "Sanity"})
	public void websiteFeedBack_sending() {

		opinionLabPage = PageFactory.initElements(driver, OpinionLabPage.class);

		opinionLabPage.feedback_webStore();

		driver.switchTo().window(parentHandle);

	}

}
