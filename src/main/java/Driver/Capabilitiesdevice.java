package Driver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.ThreadContext;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;



public class Capabilitiesdevice {


protected static AppiumDriver<WebElement> driver;
public static AppiumDriver<WebElement> DeviceCapabilities(String platformName) throws Exception
		
{
	switch(platformName) 
	
	{
	case "Android":
	 {
	         
		   FileInputStream AndroidPropertyFile = new FileInputStream("./src/main/resources/samsungs8.properties");	 
		   Properties properties=new Properties();
		   properties.load(AndroidPropertyFile);  
	        String deviceName=properties.getProperty("AndroiddeviceName");
	        String appPackage=properties.getProperty("AndroidappPackage");
	        String appActivity=properties.getProperty("AndroidappActivity");
	        DesiredCapabilities capabilities = new DesiredCapabilities();
	        capabilities.setCapability("deviceName",deviceName);
	        capabilities.setCapability("platformName",platformName); 
	        capabilities.setCapability("appPackage",appPackage);
	        capabilities.setCapability("appActivity",appActivity);
	        capabilities.setCapability("autoAcceptAlerts",true);
	        capabilities.setCapability("autoDismissAlerts", true);
	        capabilities.setCapability("autoGrantPermissions",true);
			driver= new AndroidDriver<>(new URL("http://192.168.1.194:4723/wd/hub"),capabilities);
	        Thread.sleep(7000);
	        log().info("Driver is successful");
	        break;
	 }
	case "IOS":
	 {
	         
		 FileInputStream AndroidPropertyFile = new FileInputStream("./src/main/resources/samsungs8.properties");	 
	     Properties properties=new Properties();
	     properties.load(AndroidPropertyFile);
			      
	        
	        String IOSdeviceName=properties.getProperty("IOSdeviceName");
	        String IOSappPackage=properties.getProperty("IOSappPackage");
	        String IOSappActivity=properties.getProperty("IOSappActivity");
	        DesiredCapabilities capabilities = new DesiredCapabilities();
	        capabilities.setCapability("deviceName",IOSdeviceName);
	        capabilities.setCapability("platformName",platformName); 
	        capabilities.setCapability("appPackage",IOSappPackage);
	        capabilities.setCapability("appActivity",IOSappActivity);
	      //  capabilities.setCapability("autoAcceptAlerts",true);
	       // capabilities.setCapability("autoDismissAlerts", true);
	       // capabilities.setCapability("autoGrantPermissions",true);
			driver= new AndroidDriver<>(new URL("http://192.168.1.194:4724/wd/hub"),capabilities);
	        break;
	 } 
	 
	 
	  default: 
	  {
		    driver=null;
		    System.out.println("Driver not found");
		    break;   
	  }
	}
	return driver;
	
	
	
	  
	  
	 
	         
		}

public static AppiumDriver<WebElement> getDriver() {
	return driver;
	
}

public static  String DateTime() {
	DateFormat dateformat=new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
	Date date=new Date();
	return dateformat.format(date);
	
}

public static Logger log() {

return  (Logger) LogManager.getLogger(Capabilitiesdevice.class.getName());

}

public static void waitforvisibility(MobileElement e,int waittiming)
{

WebDriverWait waitelement =new WebDriverWait(driver,waittiming);//(driver,fileutils.wait)
waitelement.until(ExpectedConditions.visibilityOf(e));
}
	
public static void click(MobileElement e, int wait)
{

	waitforvisibility(e,wait);
	e.click();
}

public static void sendKeys(MobileElement e,String Text, int wait)
{

	waitforvisibility(e,wait);
	e.sendKeys(Text);
}


public static String getAttribute(MobileElement e,String Attribute, int wait)
{
   String value= null;
	waitforvisibility(e,1);
	value = e.getAttribute(Attribute);
	return value;
	
}

public static String gettext(MobileElement e, int wait)
{
    String Text=null;
	waitforvisibility(e,wait);
	Text=e.getText();
	return Text;
}



public static AppiumDriverLocalService getAppiumService() {
	HashMap<String, String> environment = new HashMap<String, String>();
	environment.put("PATH", "/Library/Internet Plug-Ins/JavaAppletPlugin.plugin/Contents/Home/bin:Users/sijo/Library/Android/sdk/platform-tools:"
			+ "Users/sijo/Library/Android/sdk/tools:/usr/local/bin:/usr/bin:/bin:/usr/sbin:/sbin:/Library/Apple/usr/bin" + System.getenv("PATH"));
	environment.put("ANDROID_HOME", "/Users/sijo/Library/Android/sdk");
	environment.put("PATH", "/usr/local/bin:" + System.getenv("PATH"));
	log().info("Server call");
	return AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
		    .usingDriverExecutable(new File("/usr/local/bin/node"))
		 	.withAppiumJS(new File("/opt/homebrew/bin/appium"))
			.withIPAddress("192.168.1.194")
			.usingPort(4723)
			.withArgument(GeneralServerFlag.SESSION_OVERRIDE)
			.withArgument(() -> "--allow-insecure","chromedriver_autodownload")
			.withEnvironment(environment));
			//.withLogFile(new File("ServerLogs/server.log")));
}

public static boolean checkIfAppiumServerIsRunnning(int port) throws Exception {
    boolean isAppiumServerRunning = false;
    ServerSocket socket;
    try {
        socket = new ServerSocket(port);
        socket.close();
    } catch (IOException e) {
    	System.out.println("1");
        isAppiumServerRunning = true;
    } finally {
        socket = null;
    }
	return isAppiumServerRunning;
	
}
}


			
		


	