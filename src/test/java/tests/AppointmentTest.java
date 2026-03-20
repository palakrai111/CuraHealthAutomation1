package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.Appointment;
import pages.LoginPage;
import utils.ExcelUtil;

public class AppointmentTest extends BaseTest {
	@DataProvider(name = "appointmentdata")
	public Object[][] getLoginData() {
	    return ExcelUtil.getData("appointment");
	}
	
	@Test(dataProvider = "appointmentdata",groups = "regression")
	public void makeAppointmentTest(String facilty,String date, String comment) {
			LoginPage login = new LoginPage(driver);
			login.openLoginPage();
			login.login("John Doe", "ThisIsNotAPassword");
			Appointment ap = new Appointment(driver);
		ap.bookAppointment(facilty, date, comment);
		Assert.assertTrue(ap.isAppointmentConfirmed());
	}

}
