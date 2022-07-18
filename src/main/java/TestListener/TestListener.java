package TestListener;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.testng.ITestContext;
import org.testng.ITestListener ;		
import org.testng.ITestResult ;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import Driver.Capabilitiesdevice;
import io.appium.java_client.AppiumDriver;
import qareport.ExtentReport;


public class TestListener implements ITestListener{
	
	public static AppiumDriver<WebElement> driver;
	
	  public void onTestFailure(ITestResult result) {					
	        // TODO Auto-generated method stub	
		  if(result.getThrowable()!=null)
		  {
			  StringWriter SW= new StringWriter();
			  PrintWriter PW= new PrintWriter(SW);
			  result.getThrowable().printStackTrace(PW);
			  System.out.println(SW.toString());	  
				  
		  }
		  
		  driver=Capabilitiesdevice.getDriver();
		  File file=driver.getScreenshotAs(OutputType.FILE);
		  
		  byte[] encoded = null;
			try {
				encoded = Base64.encodeBase64(FileUtils.readFileToByteArray(file));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		  
		  String imagepath="Screenshot"+File.separator+Capabilitiesdevice.DateTime()+File.separator+result.getTestClass().getRealClass().getSimpleName();
		  
		  try {
			FileUtils.copyFileToDirectory(file,new File("./test-output/Screenshot/"+imagepath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
		  ExtentReport.getTest().fail("Test Failed",MediaEntityBuilder.createScreenCaptureFromPath(imagepath).build());
		  ExtentReport.getTest().fail("Test Failed",MediaEntityBuilder.createScreenCaptureFromBase64String(new String(encoded, StandardCharsets.US_ASCII)).build());
		  ExtentReport.getTest().fail(result.getThrowable());
			  
		  	}
	        
	  
	  public void onTestStart(ITestResult result) {
			
			ExtentReport.startTest(result.getName(), result.getMethod().getDescription());		
		}

		@Override
		public void onTestSuccess(ITestResult result) {
			ExtentReport.getTest().log(Status.PASS, "Test Passed");
			
		}

		@Override
		public void onTestSkipped(ITestResult result) {
			ExtentReport.getTest().log(Status.SKIP, "Test Skipped");
			
		}

		@Override
		public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onStart(ITestContext context) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onFinish(ITestContext context) {
			ExtentReport.getReporter().flush();		
		}
	  
	  
	    }	


