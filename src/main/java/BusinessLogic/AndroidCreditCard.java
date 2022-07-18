package BusinessLogic;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;

import PageProperty.CCpage;
import Driver.Capabilitiesdevice;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import static java.time.Duration.ofMillis;
import static java.time.Duration.ofSeconds;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.offset.PointOption.point;
import io.appium.java_client.MobileElement;
import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.Dimension;
import io.appium.java_client.PerformsActions;


public class AndroidCreditCard extends AndroiddLogin


{
	public AndroidCreditCard(AppiumDriver<WebElement> driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	//public void AndroidCreditCard() throws InterruptedException, IOException
	public static void main(String[] args) throws InterruptedException, IOException
	
	{
		
		String product="Liv. Financial Health";
		String producttype="Start";
		AndroidCreditCard AndroidCreditCard=new AndroidCreditCard(driver);
		//AndroidCreditCard.AndroidLoginnew();
		//AppiumDriver<WebElement> ccdriver=(Capabilitiesdevice.getDriver());	
		AndroidDriver<WebElement> ccdriver1=(AndroidDriver<WebElement>) (Capabilitiesdevice.getDriver());	
		//CCpage ccpage=new CCpage(ccdriver1);

	   
		//Dimension size=ccdriver.manage().window().getSize();
		
		//int startX=(size.width)/2;
		//int endX=startX;
		//int StartY=(int) (size.height*0.8);
		//int endY=(int) (size.height*0.2);
		
	   /*TouchActions t=new TouchActions(ccdriver);
	   t.tap(ElementOption.element(ccpage.tvName4))
	   .waitAction(waitOptions(ofSeconds(2)))
	   .moveTo(element(ccpage.tvName1))
	   .release().perform();;*/
		ccdriver1.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))"
				+".scrollIntoView(new UiSelector().textContains(\""+product+"\"))");
		ccdriver1.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))"
				+".scrollIntoView(new UiSelector().textContains(\""+producttype+"\"))");
		//ccpage.sure.click();
	   
	  
	    
		
	}



	

}
