package BusinessLogic;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;

public class LoginTestCases extends AndroiddLogin {
	
public LoginTestCases(AppiumDriver<WebElement> driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

@Test
public void Androidloginwithvalidcredential() throws InterruptedException, IOException 
{

	//AndroiddLogin.AndLogin("sijo43@liv.com","Test1234");

}
/*
@Test
public void Androidloginwithinvalidcredential() throws InterruptedException 
{

	AndroiddLogin.AndLogin("sijo999@liv.com","Test1234");

}*/

}