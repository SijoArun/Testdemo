package PageProperty;

import java.sql.Driver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CCpage {
	
public CCpage(AppiumDriver<WebElement> driver) {
		
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		// TODO Auto-generated constructor stub
	}
	

	@AndroidFindBy(xpath="(//*[@resource-id='com.liv.android.dev:id/tvName'])[4]")
	public WebElement tvName4;
	
	@AndroidFindBy(xpath="(//*[@resource-id='com.liv.android.dev:id/tvName'])[1]")
	public WebElement tvName1;
	
	@AndroidFindBy(xpath="((//*[@resource-id='com.liv.android:id/tvName' and @text='Debit card']))")
	public WebElement Debit;
	
	
	@AndroidFindBy(xpath="((//*[@resource-id='com.liv.android:id/tvName' and @text='Liv. Financial Health']))"
			+ "/following-sibling::*[@text='Start']")
	public WebElement sure;
	


			
			
}
