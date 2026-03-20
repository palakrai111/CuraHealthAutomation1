package tests;

import base.BaseTest;
import pages.LoginPage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogoutTest extends BaseTest {

	@Test(groups = "regression")
	public void logoutTest() {
		/*
		 * LoginPage login = new LoginPage(driver); login.openLoginPage();
		 * login.login("John Doe", "ThisIsNotAPassword"); WebDriverWait wait = new
		 * WebDriverWait(driver, Duration.ofSeconds(10)); //
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h2")));
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("menu-toggle")
		 * ));
		 * wait.until(ExpectedConditions.elementToBeClickable(By.id("menu-toggle"))).
		 * click(); // driver.findElement(By.id("menu-toggle")).click();
		 * //driver.findElement(By.linkText("Logout")).click();
		 * wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Logout"))).
		 * click(); //Assert.assertTrue(driver.getCurrentUrl().contains("cura"));
		 * 
		 * Assert.assertTrue( driver.findElement(By.id("btn-make-appointment"))
		 * .isDisplayed());
		 */

	/*	Assert.assertTrue(
				wait.until(ExpectedConditions*///.visibilityOfElementLocated(By.id("btn-make-appointment"))).isDisplayed());
		
		LoginPage login = new LoginPage(driver);
		
		 login.openLoginPage();
		 login.login("John Doe", "ThisIsNotAPassword");

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    // ✅ Wait for successful login
	    wait.until(ExpectedConditions.urlContains("appointment"));

	    // ✅ Click menu
	    wait.until(ExpectedConditions.elementToBeClickable(By.id("menu-toggle"))).click();

	    // 🔥 Wait for menu to expand
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Logout")));

	    // ✅ Click logout
	    wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Logout"))).click();

	    // ✅ Validate logout success
	    Assert.assertTrue(
	        wait.until(ExpectedConditions
	            .visibilityOfElementLocated(By.id("btn-make-appointment")))
	            .isDisplayed()
	    );
		
		
	}
}
