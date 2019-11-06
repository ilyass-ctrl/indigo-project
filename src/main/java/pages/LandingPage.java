package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LandingPage extends BasePage {

	

	public LandingPage(WebDriver driver) {
		super(driver);
	}

	@FindBy (css ="[aria-label='Close Popup']")
	WebElement closePopUp_Btn;

	@FindBy (css ="#oo_tab")
	WebElement feedBack_Btn;

	@FindBy (css ="#waypoint_icons > a:nth-child(1)")
	WebElement webSite_feedBack_Btn;


	public String getTitle() {
		return driver.getTitle();
	}

	public void popUpClosing() {
		if(closePopUp_Btn.isDisplayed()) {
			closePopUp_Btn.click();
		} 
	}

	public void select_webStite_feedBack() {

		feedBack_Btn.click();
		webSite_feedBack_Btn.click();
	}
}
