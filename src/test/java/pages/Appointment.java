package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Appointment {
	WebDriver driver;
	WebDriverWait wait;
	
	 private By facility = By.id("combo_facility");
	    private By readmission = By.id("chk_hospotal_readmission");
	    private By medicare = By.id("radio_program_medicare");
	    private By visitDate = By.id("txt_visit_date");
	    private By comment = By.id("txt_comment");
	    private By bookBtn = By.id("btn-book-appointment");
	  //  private By confirmation = By.xpath("//h2[text()='Appointment Confirmation']");
	    private By confirmation = By.id("summary");
	public Appointment(WebDriver driver) {
		   this.driver = driver;
		   wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 }
	private void click(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    private void type(By locator, String text) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).sendKeys(text);
    }

	private void selectFacility(String facilityName) {
		Select s = new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(facility)));
		s.selectByVisibleText(facilityName);
	}
	

	public void enterDate(String date) {

	    WebElement dateField = wait.until(
	        ExpectedConditions.elementToBeClickable(visitDate)
	    );

	        JavascriptExecutor js = (JavascriptExecutor) driver;

	        // 🔥 Force set value
	        js.executeScript("arguments[0].value='" + date + "';", dateField);

	        // 🔥 Trigger input + change event (VERY IMPORTANT)
	        js.executeScript(
	            "arguments[0].dispatchEvent(new Event('input')); " +
	            "arguments[0].dispatchEvent(new Event('change'));",
	            dateField
	        );

	        // ✅ VERIFY
	        String value = dateField.getAttribute("value");
	        System.out.println("Date set = " + value);
	    
	}
	
	public void clickBookAppointment() {

	    WebElement button = wait.until(
	        ExpectedConditions.presenceOfElementLocated(bookBtn)
	    );

	    // Scroll into view (VERY IMPORTANT)
	    ((JavascriptExecutor) driver).executeScript(
	        "arguments[0].scrollIntoView(true);", button
	    );

	    // Small wait (UI stabilize)
	    try { Thread.sleep(500); } catch (Exception e) {}

	    // JS Click (force click)
	    ((JavascriptExecutor) driver).executeScript(
	        "arguments[0].click();", button
	    );

	    System.out.println("Clicked Book Appointment");
	}
	public void bookAppointment(String facilityName, String date, String commentText) {
		selectFacility(facilityName);
		click(readmission);
		click(medicare);
		enterDate(date);
		type(comment, commentText);
		//click(bookBtn);
		clickBookAppointment();
	}

	public boolean isAppointmentConfirmed() {
		 wait.until(ExpectedConditions.urlContains("summary"));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(confirmation)).isDisplayed();
	}
	
}
