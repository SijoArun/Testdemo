package BusinessLogic;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import Driver.Capabilitiesdevice;
import PageProperty.settingpage;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import net.sourceforge.tess4j.Tesseract;
import static io.appium.java_client.touch.WaitOptions.waitOptions;
import io.appium.java_client.android.AndroidDriver;



public class AndroidSettings
{
	
	public static void main(String[] args) throws InterruptedException, IOException
	
	{
		
		String product="Update your details";
		
		AndroidSettings AndroidSettings=new AndroidSettings();
		//AndroidSettings.AndroidLoginnew();
		
		AndroidDriver<WebElement> settingdriver=(AndroidDriver<WebElement>)Capabilitiesdevice.getDriver();	
		settingpage settingpage=new settingpage(settingdriver);
		
		settingpage.setting.click();
		Thread.sleep(15000);
		
		TouchAction t=new TouchAction(settingdriver);
		t.press(PointOption.point(983,556)).waitAction(waitOptions(Duration.ofSeconds(1))).moveTo(PointOption.point(116,556)).release().perform();
		
		
		Thread.sleep(3000);
		
		settingdriver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))"
				+".scrollIntoView(new UiSelector().textContains(\""+product+"\"))");
		
		Thread.sleep(1000);
		
		settingpage.tvChangeDetails.click();
		Thread.sleep(1000);
		
		settingpage.Emirates.click();
		Thread.sleep(1000);
		
		settingpage.validateEIDIA.click();
		Thread.sleep(1000);
		

	
		
		System.out.println(settingpage.drawing.getLocation());
		Thread.sleep(1000);
		
		File EIDA=new File("./src/main/resources/EIDAFront.jpg");	
		
       		
		Map<String, Object> argss = new HashMap<>();
		argss.put("width", 1080);
		argss.put("height", 1920);
		argss.put("considerRotation", true);
		argss.put("quality", 45);
		argss.put("bitRate", 500000);
		settingdriver.executeScript("mobile: startScreenStreaming", argss);
		
		settingdriver.executeScript("mobile: stopScreenStreaming");
	    
		
		
		//settingdriver.executeScript("action","cameraImageInjection");
		
		//System.out.println(settingdriver.executeScript("action","cameraImageInjection"));
		
		
	}


	

}
