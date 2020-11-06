package week4.day2.assignments;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WinHanAssignment {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
//Click button to open home page in New Window
		driver.get("http://leafground.com/pages/Window.html");
		driver.findElementByXPath("//button[text()='Open Home Page']").click();
		Thread.sleep(5000);
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> listHandles=new ArrayList<String>(windowHandles);
		
		String parentWindow=listHandles.get(0);
		System.out.println("Parent Window Title : " +driver.getTitle());
		
		String firstchildWindow=listHandles.get(1);
		driver.switchTo().window(firstchildWindow);
		System.out.println("First Child Window Title : " +driver.getTitle());
		
// To get count of open windows
		int size=listHandles.size();
		System.out.println("Total open windows on clicking 'open home page' button : "+size);
		driver.close();
		System.out.println("===========================================================");
		
		/*
		 * Set<String> windowHandles = driver.getWindowHandles(); 
		 * Iterator<String> iterator = windowHandles.iterator(); 
		 * String parentWindow=iterator.next();
		 * String childWindow=iterator.next();
		 *  driver.switchTo().window(childWindow);
		 */
//Click on open multiple windows button - Find the number of opened windows
		driver.switchTo().window(parentWindow);
		System.out.println("Parent Window Title : " +driver.getTitle());
		
		driver.findElementByXPath("(//button[@onclick='openWindows()'])[1]").click();
		Thread.sleep(5000);
		
		Set<String> windowHandles1 = driver.getWindowHandles();
		List<String> listHandles1=new ArrayList<String>(windowHandles1);
		
		String firstchildWindow1=listHandles1.get(1);
		String secondchildWindow1=listHandles1.get(2);
		System.out.println("First Child Window Title : " +driver.getTitle());
		
		driver.switchTo().window(secondchildWindow1);
		System.out.println("Second Child Window Title : " +driver.getTitle());
		

// To get count of open windows
		int size1=listHandles1.size();
		System.out.println("Total open windows on clicking 'open multiple windows'button : "+size1);
		
		driver.quit();  
}
}
