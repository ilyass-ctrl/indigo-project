package tests;

import org.testng.annotations.Test;
import pages.LandingPage;
import pages.OpinionLabPage;

import org.testng.annotations.BeforeTest;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class FeedBack_SideBar_Test {

	WebDriver driver;
	LandingPage landingPage;
	OpinionLabPage opinionLabPage;
	String winHandle = null;
	String parentHandle;

	@BeforeTest
	public void setUp() {

		File file = new File("C:\\Users\\Saighi Ilyass\\Desktop\\Web Automation\\WebDrivers\\chromedriver.exe");
		System.setProperty("webdriver.chrome.driver",file.getAbsolutePath() );

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		//options.addArguments("--headless");

		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get("https://www.chapters.indigo.ca/en-ca/");
		landingPage = PageFactory.initElements(driver, LandingPage.class);

		parentHandle = driver.getWindowHandle();

	}

	@AfterTest
	public void tearDown() {
		driver.close();
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
