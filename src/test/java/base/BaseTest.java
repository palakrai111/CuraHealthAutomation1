package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import utils.DriverFactory;

public class BaseTest {

 protected WebDriver driver;

 @BeforeMethod(alwaysRun = true)
 public void setup() {
   driver = DriverFactory.initDriver();
   driver.get("https://katalon-demo-cura.herokuapp.com/");
 }

 @AfterMethod(alwaysRun = true)
 public void tearDown() {
   driver.quit();
 }
}
// go to project folder and run below command to execute regression suite
//do the chnge in pom .xml to run regression suite
//similalary we can run testng suite
//E:\CURA-Health\cura-automation-project>mvn clean test -DsuiteXmlFile=regression.xml