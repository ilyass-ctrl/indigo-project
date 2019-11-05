package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OpinionLabPage {
	
	protected WebDriver driver = null;
	protected String comment;
	
	public OpinionLabPage (WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy (css = "")
	WebElement overAll_rating_elem;
	
	@FindBy (css = "")
	WebElement comments_field;
	
	@FindBy (css = "")
	WebElement question_DD;
	
	@FindBy (css = "")
	WebElement answers_DD;
	
	@FindBy (css = "")
	WebElement description_field;
	
	@FindBy (css = "")
	WebElement recommend_rating_elem;
	
	@FindBy (css = "")
	WebElement submit_btn;
	
	@FindBy (css = "")
	WebElement thanking_text;
	
	@FindBy (css = "")
	WebElement closing_btn;
	
	public String getTitle() {
		return driver.getTitle();
	}
	
	public void feedback_webStore() {
		overAll_rating_elem.click();
		comments_field.sendKeys(comment);
		question_DD.click();
		answers_DD.click();
		recommend_rating_elem.click();
		submit_btn.click();
		thanking_text.getText();
		closing_btn.click();
	}

}
