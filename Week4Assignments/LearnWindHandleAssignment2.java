package week4.day2.assignments;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnWindHandleAssignment2 {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
//Click Wait for 5 seconds button -  Wait for 2 new Windows to open
		driver.get("http://leafground.com/pages/Window.html");
		driver.findElementByXPath("//button[@onclick='openWindowsWithWait();']").click();
		System.out.println("Parent window title: "+driver.getTitle());
//		Thread.sleep(5000);
        Set<String> windowHandles = driver.getWindowHandles();
        List<String> handles=new ArrayList<String>(windowHandles);
        String parentWindow = handles.get(0);
        String firstChildWindow = handles.get(1);
        String secondChildWindow = handles.get(2);
        driver.switchTo().window(firstChildWindow);
        System.out.println("First child window title: "+driver.getTitle());
        driver.switchTo().window(secondChildWindow);
        System.out.println("Second child window title: "+driver.getTitle());
        driver.quit();
	}

}
