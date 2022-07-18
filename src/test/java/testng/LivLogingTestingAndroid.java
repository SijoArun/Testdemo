package testng;
import org.testng.annotations.Test;
import BusinessLogic.AndroiddLogin;
import Driver.Capabilitiesdevice;
import PageProperty.Loginpage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServerHasNotBeenStartedLocallyException;
import utils.StringUtils;
import org.testng.annotations.BeforeClass;
import java.io.FileInputStream;
import java.util.HashMap;

import org.apache.logging.log4j.ThreadContext;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;



public class LivLogingTestingAndroid
{	
	
	AndroiddLogin Al;
	public static HashMap<String, String> strings = new HashMap<String, String>();
	private static AppiumDriverLocalService server;
	
	
	
	@BeforeSuite
	public void beforeSuite() throws Exception, Exception {
		ThreadContext.put("ROUTINGKEY", "ServerLogs");

		server = Capabilitiesdevice.getAppiumService(); // -> If using Windows, uncomment this statement and comment above statement
		//if(!Capabilitiesdevice.checkIfAppiumServerIsRunnning(4723)) {
		//server.stop();
		Thread.sleep(2000);
		server.start();
		Thread.sleep(3000);
		//server.clearOutPutStreams(); // -> Comment this if you don't want to see server logs in the console
			Capabilitiesdevice.log().info("Appium server started");
		//}
		//	else 
		// {
		//	Capabilitiesdevice.log().info("Appium server already running");
		//}	
	}
	
@Test
public void validlogin() throws Exception
{ 
	
	Al=new AndroiddLogin(null);
	Al.AndroidvalidLogin();
	AndroidDriver<WebElement> logindriver=(AndroidDriver<WebElement>)Capabilitiesdevice.getDriver();
	Loginpage loginpage = new Loginpage(logindriver);
	String actualtext=loginpage.getsmallLabel();//pop up closed
	FileInputStream XMLStringFile = new FileInputStream("./src/main/resources/Strings.xml");
	StringUtils utils = new StringUtils();
	strings=utils.parseStringXML(XMLStringFile);
	String ExpectedText=strings.get("product_title");
	Capabilitiesdevice.log().info("ActualText: " +actualtext);
	Capabilitiesdevice.log().info("ExpectedText: " +ExpectedText);
	Assert.assertEquals(actualtext, ExpectedText);
	
}


@BeforeClass
  public void beforeClass() {
  }

  @AfterClass
  public void afterClass() {
  }

  @BeforeTest
  public void beforeTest() {
  }
  
  
  @AfterTest
  public void afterTest() {
	
	  AndroidDriver<WebElement> driver=(AndroidDriver<WebElement>)Capabilitiesdevice.getDriver();
	  driver.quit();
	  
  }

  
  @AfterSuite
  public void afterSuite() {
	  
	  server.start();
  }

}
