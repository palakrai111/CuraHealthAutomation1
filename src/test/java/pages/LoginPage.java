package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

 WebDriver driver;
 WebDriverWait wait;

 private By menu = By.id("menu-toggle");
 private By loginLink = By.linkText("Login");
 private By username = By.id("txt-username");
 private By password = By.id("txt-password");
 private By loginBtn = By.id("btn-login");

 public LoginPage(WebDriver driver) {
   this.driver = driver;
   wait = new WebDriverWait(driver, Duration.ofSeconds(10));
 }

 public void openLoginPage() {
	 
	// wait.until(
            // ExpectedConditions.visibilityOfElementLocated(menu)).click();
  // driver.findElement(menu).click();
   //driver.findElement(loginLink).click();
	// wait.until(
         //    ExpectedConditions.visibilityOfElementLocated(loginLink)).click();
             wait.until(ExpectedConditions.elementToBeClickable(menu)).click();
             wait.until(ExpectedConditions.elementToBeClickable(loginLink)).click();
             
 }

 public void login(String user, String pass) {
   //driver.findElement(username).sendKeys(user);
   //driver.findElement(password).sendKeys(pass);
   //driver.findElement(loginBtn).click();
	wait.until(ExpectedConditions.visibilityOfElementLocated(username)).sendKeys(user);
	wait.until(ExpectedConditions.visibilityOfElementLocated(password)).sendKeys(pass);
	wait.until(ExpectedConditions.elementToBeClickable(loginBtn)).click();
 }
}
