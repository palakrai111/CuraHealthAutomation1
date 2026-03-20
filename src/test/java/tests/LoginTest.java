package tests;

import base.BaseTest;
import pages.LoginPage;
import utils.ExcelUtil;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
	
	@DataProvider(name = "loginData")
	public Object[][] getLoginData() {
	    return ExcelUtil.getData("login");
	}
//(dataProvider = "loginData", groups = "regression")
 @Test(dataProvider = "loginData",groups = "regression")
 public void validLoginTest(String username, String password) {
   LoginPage login = new LoginPage(driver);
   login.openLoginPage();
   //login.login("John Doe", "ThisIsNotAPassword");
   login.login(username, password);
   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
   String header =  wait.until(
           ExpectedConditions.visibilityOfElementLocated(By.tagName("h2"))
   ).getText();
		   
		   //driver.findElement(By.tagName("h2")).getText();
   Assert.assertEquals(header, "Make Appointment","Login failed or unexpected page");
   Assert.assertTrue(driver.getCurrentUrl().contains("appointment"));
 }
 @Test(dataProvider = "loginData")
 public void invalidLoginTest(String username, String password) {
   LoginPage login = new LoginPage(driver);
   login.openLoginPage();
   login.login(username, password);
   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
   String actualtext =  wait.until(
           ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(),'Login failed!')]"))
   ).getText();
		   
		   //driver.findElement(By.tagName("h2")).getText();
   Assert.assertEquals(actualtext, "Login failed! Please ensure the username and password are valid.","Unexpected error message");
  // Assert.assertTrue(driver.getCurrentUrl().contains("appointment"));
 }
 
 
}
