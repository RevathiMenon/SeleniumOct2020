package week4.day2.assignments;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
public class LearnWinHandleAssignment {

	public static void main(String[] args) throws InterruptedException {
		
				WebDriverManager.chromedriver().setup();
				ChromeDriver driver=new ChromeDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
				
		//Click do not close me button -  Close all except this window
				driver.get("http://leafground.com/pages/Window.html");
				driver.findElementByXPath("//button[@onclick='openWindows();']").click();
				Thread.sleep(5000);
				
				Set<String> windowHandles = driver.getWindowHandles();
				List<String> listHandles=new ArrayList<String>(windowHandles);
				
		// To get count of open windows
				 int size=listHandles.size(); 
				 System.out.println("Total open windows on clicking 'do not close me' button : "+size);
				 System.out.println("===========================================================");

				
			     for (String handle: listHandles)
			     {
			    	if (handle.equals(listHandles.get(0)))
			    	{
			    			driver.switchTo().window(listHandles.get(0));
			    			driver.close();
			        }
			     }
		// To get count of open windows
			     
			    driver.switchTo().window(listHandles.get(1));
			    
			    Set<String> windowHandles1 = driver.getWindowHandles();
				List<String> listHandles1=new ArrayList<String>(windowHandles1);
			 int size1=listHandles1.size(); 
			 System.out.println("Total open windows on closing parent window : "+size1);
			 driver.close(); 
			 System.out.println("===========================================================");
			 
			    }
	}
