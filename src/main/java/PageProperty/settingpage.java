package PageProperty;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class settingpage {
	
	
public settingpage(AppiumDriver<WebElement> driver) {
		
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		// TODO Auto-generated constructor stub
	}
	

   @AndroidFindBy(xpath="((//*[@resource-id='com.liv.android:id/smallLabel' and @text='Settings']))")
   public WebElement setting;
   
   @AndroidFindBy(id="com.liv.android:id/tvChangeDetails")
   public WebElement tvChangeDetails;
   
   @AndroidFindBy(xpath="((//*[@resource-id='android:id/text1' and @text='Emirates ID']))")
   public WebElement Emirates;
   
   @AndroidFindBy(id="com.liv.android:id/validateEIDIA")
   public WebElement validateEIDIA;
   
   @AndroidFindBy(id="com.liv.android:id/drawing")
   public WebElement drawing;
   


			
			
}


