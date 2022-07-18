package BusinessLogic;

import java.io.FileInputStream;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.openqa.selenium.WebElement;

import Driver.Capabilitiesdevice;
import PageProperty.Loginpage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;


public class AndroiddLogin extends Loginpage


{

	public AndroiddLogin(AppiumDriver<WebElement> driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

private static String platformName = "Android";

//public static void AndLogin(String username,String password) throws InterruptedException,IOException
//public static void main(String[] args) throws InterruptedException,IOException
public void AndroidvalidLogin() throws Exception

{   
	FileInputStream jsonloingdata = new FileInputStream("./src/main/resources/Loginuser.json");
	JSONTokener tokener=new JSONTokener(jsonloingdata);
	JSONObject loginusers=new JSONObject(tokener);
	
	  
	   Loginpage loginpage = new Loginpage(Capabilitiesdevice.DeviceCapabilities(platformName));  //create a login page object
	   //System.out.println("Driver is success");// logger
	   AndroidDriver<WebElement> logindriver=(AndroidDriver<WebElement>)Capabilitiesdevice.getDriver();	//create a driver instance
	   loginpage.loginarrageImageView1(); //splash screen click , defined in login page class
	   loginpage.loginarrageImageView(); //splash screen click , defined in login page class
	   loginpage.loginarrageImageView(); //splash screen click , defined in login page class
	   loginpage.loginsignIn();  //splash screen click , defined in login page class
	   loginpage.loginusernameclick();//user name text defined in login page class
	   loginpage.loginusername(loginusers.getJSONObject("validuser").getString("username"));//user name - send keys in login page class
	   logindriver.hideKeyboard();// Hide keyboard with driver
	   loginpage.loginpasswordclick(); //password text defined in login page class
	   loginpage.loginpassword(loginusers.getJSONObject("validuser").getString("password"));//password text defined in login page class
	   logindriver.hideKeyboard();  // Hide keyboard with driver
	   loginpage.loginnext();// sign in - definition in login page
	   loginpage.button2(); // successful login - 35 secs wait time
	   log().info("Login is successful");

	   

	   
}




	  
	   
}














/*	   
for(int i=0;i<3;i++)
{
logingpage.loginarrageImageView.click();
Thread.sleep(1000);
}

logingpage.loginsignIn.click();
Thread.sleep(1000);


//logingpage.loginusername.sendKeys(username);
logingpage.loginusername.click();
logingpage.loginusername.sendKeys("sijoarunachalam2@gmail.com");
logindriver.hideKeyboard();




Thread.sleep(1000);
// System.out.println("userName is "+userName);

//logingpage.loginpassword.sendKeys(password);
logingpage.loginpassword.click();
logingpage.loginpassword.sendKeys("Test@54321");
logindriver.hideKeyboard();
Thread.sleep(1000);
// System.out.println("password is" +passWord);

logingpage.loginnext.click();
Thread.sleep(30000);


//WebDriverWait wait=new WebDriverWait(Capabilitiesdevice.getDriver(), 30000);
//wait.until(ExpectedConditions.presenceOfElementLocated((By) logingpage.btnPositive));


// if("logingpage.tvTitle".equalsIgnoreCase("Error"))
//{
//logingpage.btnPositive.click();	
//Thread.sleep(1000);
//}

//logingpage.btnNegative1.click();
//Thread.sleep(1000);



logingpage.button2.click();
Thread.sleep(1000);
System.out.println("Login is succesful");

logingpage.smallLabel.click();
Thread.sleep(1000);


//String src = Capabilitiesdevice.DeviceCapabilities(platformName).getPageSource();
//System.out.println(src);



*/






	    
