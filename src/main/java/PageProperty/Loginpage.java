package PageProperty;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import Driver.Capabilitiesdevice;


public class Loginpage extends Capabilitiesdevice

{

   
	public Loginpage(AppiumDriver<WebElement> driver) {
		
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		// TODO Auto-generated constructor stub
	}

	
	
	@AndroidFindBy(id="com.liv.android:id/ItemOptionTitleTextView")
    public WebElement ItemOptionTitleTextView;

	@AndroidFindBy(id="com.liv.android:id/arrowImageView")
    public WebElement loginarrageImageView;
	
	@AndroidFindBy(id="com.liv.android:id/signIn")
    public WebElement loginsignIn;
	
	@AndroidFindBy(xpath="(//*[@resource-id='com.liv.android:id/edittext'])[1]")
    public WebElement loginusername;
	
	
	@AndroidFindBy(xpath="(//*[@resource-id='com.liv.android:id/edittext'])[2]")
    public WebElement loginpassword;	
	
	
	@AndroidFindBy(id="com.liv.android:id/next")
    public WebElement loginnext;
	
	
	@AndroidFindBy(id="com.liv.android:id/tvTitle")
	public WebElement tvTitle;

	
	@AndroidFindBy(id="com.liv.android:id/btnPositive")
	public WebElement btnPositive;
	
	@AndroidFindBy(id="com.liv.android:id/btnNegative")
	public WebElement btnNegative1;

	
	@AndroidFindBy(id="com.liv.android:id/button2")
	public WebElement button2;
	
	
	@AndroidFindBy(id="com.liv.android:id/smallLabel")
	public WebElement smallLabel;
	
	
	
	public Loginpage loginarrageImageView1()
	{
		
		Capabilitiesdevice.click((MobileElement) loginarrageImageView,30);
		return this;
		
	}
	
	public Loginpage loginarrageImageView()
	{
		
		Capabilitiesdevice.click((MobileElement) loginarrageImageView,1);
		return this;
		
	}
	
	public Loginpage loginsignIn()
	{
		
		Capabilitiesdevice.click((MobileElement) loginsignIn,1);
		return this;
		
	}
	
	
	
	
	public Loginpage loginusernameclick()
	{
		
		Capabilitiesdevice.click((MobileElement) loginusername,1);
		return this;
		
	}
		
	
	public Loginpage loginusername(String username)
	{
		
		Capabilitiesdevice.sendKeys((MobileElement) loginusername, username,1);
		return this;
		
	}
	
	
	public Loginpage loginpasswordclick()
	{
		
		Capabilitiesdevice.click((MobileElement) loginpassword,1);
		return this;
		
	}
	
	public Loginpage loginpassword(String password)
	{
		
		Capabilitiesdevice.sendKeys((MobileElement) loginpassword, password,1);
		return this;
		
	}
	
	
	public Loginpage loginnext()
	{
		
		Capabilitiesdevice.click((MobileElement) loginnext,1);
		return this;
		
	}
	
	public Loginpage tvTitle()
	{
		
		Capabilitiesdevice.click((MobileElement) tvTitle,60);
		return this;
		
	}
	
	public Loginpage btnPositive()
	{
		
		Capabilitiesdevice.click((MobileElement) btnPositive,1);
		return this;
		
	}
	
	

	public Loginpage btnNegative()
	{
		
		Capabilitiesdevice.click((MobileElement) btnNegative1,1);
		return this;
		
	}
	
	
	public Loginpage button2()
	{
		
		Capabilitiesdevice.click((MobileElement) button2,30);
		return this;
		
	}
	
	

	
	
	

	public Loginpage smallLabel()
	{
		
		Capabilitiesdevice.click((MobileElement) smallLabel,1);
		return this;
		
	}

	public String getsmallLabel() {
		// TODO Auto-generated method stub
		String Text;
		Text=Capabilitiesdevice.gettext((MobileElement) smallLabel,1);
		return Text;
	}


	
	
}	



/*@AndroidFindBy(id="com.liv.android:id/next")
    public WebElement loginnext;
	
	
	@AndroidFindBy(id="com.liv.android:id/tvTitle")
	public WebElement tvTitle;

	
	@AndroidFindBy(id="com.liv.android:id/btnPositive")
	public WebElement btnPositive;
	
	@AndroidFindBy(id="com.liv.android:id/btnNegative")
	public WebElement btnNegative1;

	
	@AndroidFindBy(id="com.liv.android:id/button2")
	public WebElement button2;
	
	
	@AndroidFindBy(id="com.liv.android:id/smallLabel")
	public WebElement smallLabel;
	
	*/

