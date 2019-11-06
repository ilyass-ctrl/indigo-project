package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class OpinionLabPage extends BasePage{

	public OpinionLabPage(WebDriver driver) {
		super(driver);
	}

	@FindBy (css = "#overall-icon-5")
	WebElement overAll_rating_elem;

	@FindBy (css = "#comment-textarea")
	WebElement comments_field;

	@FindBy (css = "[id=\"4363569\"]")
	WebElement question_DD;

	@FindBy (xpath = "//*[@id='4363569']/option[8]")
	WebElement answers_DD;

	@FindBy (css = "#section_4363569 > input.hidden-field.form-control")
	WebElement description_field;

	@FindBy (css = "#answer_4363568-8")
	WebElement recommend_rating_elem;

	@FindBy (css = "div.col-sm-4.col-sm-push-8 > input")
	WebElement submit_btn;

	@FindBy (css = "#int-thankyou-heading")
	WebElement thanking_text;

	@FindBy (css = "[data-close='Close']")
	WebElement closing_btn;

	public String getTitle() {
		return driver.getTitle();
	}

	public void feedback_webStore() {
		overAll_rating_elem.click();
		comments_field.sendKeys("I like Indigo!!!");
		question_DD.click();
		answers_DD.click();
		recommend_rating_elem.click();
		submit_btn.click();
		wait.until(ExpectedConditions.elementToBeClickable(closing_btn));
	}

}
