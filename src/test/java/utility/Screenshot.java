package utility;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshot {

public static void takeFailedScreeshot(WebDriver driver) throws IOException {
		
    Date currentdate=new Date();
    String ss=currentdate.toString().replace(":","");


		File s= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File d = new File("C:/Users/DELL/eclipse-workspace/sicerepay/SincerePay/Screenshot/"+ss+".jpg");
		FileUtils.copyFile(s,d);
		
	}
}
