package week4.day2.assignments;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeLeads {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.findElementById("username").sendKeys("demosalesmanager");
		driver.findElementById("password").sendKeys("crmsfa");
		driver.findElementByClassName("decorativeSubmit").click();
		driver.findElementByLinkText("CRM/SFA").click();
		driver.findElementByLinkText("Leads").click();
		driver.findElementByLinkText("Merge Leads").click();
		driver.findElementByXPath("(//img[@alt='Lookup'])[1]").click();
		
		Set<String> windowHandles1 = driver.getWindowHandles();
		Iterator<String> iterator1 = windowHandles1.iterator();
		String firstParentWindow=iterator1.next();
		String firstChildWindow=iterator1.next();
		driver.switchTo().window(firstChildWindow);
		
		driver.findElementByName("id").sendKeys("13819");
		driver.findElementByXPath("//button[text()='Find Leads']").click();
		Thread.sleep(5000);
		driver.findElementByLinkText("13819").click();
		driver.switchTo().window(firstParentWindow);
		driver.findElementByXPath("(//img[@alt='Lookup'])[2]").click();
		Set<String> windowHandles2 = driver.getWindowHandles();
		Iterator<String> iterator2 = windowHandles2.iterator();
		String secondParentWindow=iterator2.next();
		String secondchildWindow=iterator2.next();
		driver.switchTo().window(secondchildWindow);
		driver.findElementByName("id").sendKeys("13821");
		driver.findElementByXPath("//button[text()='Find Leads']").click();
		Thread.sleep(5000);
		driver.findElementByLinkText("13821").click();
		driver.switchTo().window(secondParentWindow);
		driver.findElementByLinkText("Merge").click();
		driver.switchTo().alert().accept();
		driver.findElementByLinkText("Find Leads").click();
		driver.findElementByName("id").sendKeys("13819");
		driver.findElementByXPath("//button[text()='Find Leads']").click();
		Thread.sleep(5000);
		String text = driver.findElementByXPath("//div[text()='No records to display']").getText();
		if(text.contentEquals("No records to display"))
		{
			System.out.println("Merged successfully");
		}
		
		else
		{
			System.out.println("Not merged successfully");
		}
		
	}

}
