package testclass;

import java.io.IOException;

import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.base.BaseClass;

import com.pom.CreditCard;
import com.pom.FRC;
import com.pom.LoanPayment;
import com.pom.LoginPage;

import utility.ExcelSheet;
import utility.Screenshot;

public class TestScript {

	WebDriver driver;
	
	@BeforeTest ()
	@Parameters({"Browser"})
	   public void Launchbrowser(String Browser) throws InterruptedException {
		   if(Browser.equalsIgnoreCase("chrome")){
		   
		   driver=BaseClass.launchbrowser();
		   }
		   else if(Browser.equalsIgnoreCase("edge")){
			   driver=BaseClass.openedge();
		   }
		   else if(Browser.equalsIgnoreCase("firefox")) {
			  driver=BaseClass.openfirefox();
		   }
	}
		   @BeforeClass
		   public void hittheurl() {

			   driver.get("https://www.sincerepay.co.in/Login");    

			   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			   driver.manage().window().maximize();
	   }
	
	   
	    @BeforeMethod
	    public void verifylogin() throws EncryptedDocumentException, IOException {
	    	LoginPage lp = new LoginPage(driver);
	    	String username = ExcelSheet.getDatafromExcel(0, 0);
	    	lp.clickonusername(username);
	    	String pass = ExcelSheet.getDatafromExcel(1, 0);
	    	lp.pass(pass);
	    	lp.loggin();
			  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	    	
	    }
	    
	    @Test(priority=1)
	    public void loanpayment()  {
	    	LoanPayment lpay = new LoanPayment(driver);
	    	  lpay.loanpayment();
	    	  lpay.selectoperator();
	    	  Actions a = new Actions(driver);
	    	
	    	   for(int i=93;i>=1;i--) {
	    		   a.sendKeys(Keys.ARROW_DOWN).build().perform();
	    	   }
	    	   lpay.consumernumber();
	    	   lpay.amount();
	    	   lpay.reset();
	    	   lpay.paybutton();
	    	   
	    	   driver.navigate().to("https://www.sincerepay.co.in/RetailerDashboard");
	    	   
	    	   
	    }
	    
	   @Test(priority=2)
	   public void creditcard() {
		   CreditCard cc = new CreditCard(driver);
		   cc.creditcard();
		   cc.selectnetwork();
		   Actions b = new Actions(driver);
		   for(int i=2;i>=1;i--) {
			   b.sendKeys(Keys.ARROW_DOWN).build().perform();
		   }
		   cc.cardholdername();
		   cc.cardnumber();
		   cc.mobilenumber();
		   cc.amount();
		   cc.resetbutton();
		   cc.proceedbutton();
		   driver.navigate().to("https://www.sincerepay.co.in/RetailerDashboard");

	   }
	   
	   @Test(priority=3)
	   public void frc() {
		   FRC fr = new FRC(driver);
		  fr.frc();
		   fr.selectoperatorr();
		   Actions c = new Actions(driver);
		   for(int i=6;i>=1;i--) {
			   c.sendKeys(Keys.ARROW_DOWN).build().perform();
		   }
		   fr.consumernumberr();
		   fr.selectamount();
		   fr.reset();
		   fr.recharge();
	   }
	   
	   @AfterMethod
	   public  void signout(ITestResult result) throws IOException   {
		   if(ITestResult.SUCCESS==result.getStatus()) {
			 Screenshot.takeFailedScreeshot(driver);
		   }else {
			   if(ITestResult.FAILURE==result.getStatus()) {
			   System.out.println("failscreenshot");

			   }
//		  if(ITestResult.FAILURE==result.getStatus()) {
//			  Screenshot.takeFailedScreeshot(driver);
	  }
		  
		  
		 WebElement a= driver.findElement(By.xpath("//button[@aria-controls='primary-search-account-menu']"));
		Select s = new Select(a);
		s.selectByIndex(10);
		
		   
			   }
	   
	   @AfterTest 
	   public void quit() {
		   driver.quit();
	   }
}
