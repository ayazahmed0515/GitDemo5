import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HandlingwindowsfileuploadUsingAutoIt {
	
	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub	
		String downloadPath= System.getProperty("user.dir");		
		System.setProperty("webdriver.chrome.driver", 
				System.getProperty("user.dir") + "\\resources\\chromedriver.exe");
		HashMap<String, Object> ChromePrefs=new HashMap<String, Object>();
		ChromePrefs.put("profile.default_content_settings.popups",0);
		ChromePrefs.put("download.default_directory", downloadPath);
		ChromeOptions options=new ChromeOptions();
		options.setExperimentalOption("prefs", ChromePrefs);
		
		WebDriver driver=new ChromeDriver(options);
		driver.get("https://www.ilovepdf.com/pdf_to_jpg");
		
		driver.findElement(By.id("pickfiles")).click();
		Thread.sleep(3000);
		Runtime.getRuntime().exec("C:\\Users\\ahmad\\OneDrive\\Desktop\\AutoIt\\fileupload.exe");
		WebDriverWait wait=new WebDriverWait(driver,25);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("processTask")));
		driver.findElement(By.id("processTask")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\'pickfiles\']")));
		driver.findElement(By.xpath("//*[@id=\'pickfiles\']")).click();
		Thread.sleep(5000);
		File F=new File(downloadPath+"/ilovepdf_pages-to-jpg.zip");
				if(F.exists())
		{
			System.out.println("File Found");
					/*if(F.delete())
			{
				System.out.println("File is deleted");
			} */
			
		}
		else
		{
			System.out.println("File not Found");
		}
		driver.close();
	}
	
}
