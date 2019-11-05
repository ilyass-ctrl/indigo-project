package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LandingPage {
	
	protected WebDriver driver = null;

	public LandingPage(WebDriver driver) {
		this.driver = driver; 
	}
	
	
	@FindBy (css ="")
	WebElement feedBack_Btn;
	
	@FindBy (css ="")
	WebElement webSite_feedBack_Btn;
	
	
	public String getTitle() {
		return driver.getTitle();
	}
	
	public void click_btn() {
		feedBack_Btn.click();
		webSite_feedBack_Btn.click();
	}
}
