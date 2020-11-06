package week4.day2.assignments;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateIncidentServiceNow {

	public static void main(String[] args) throws InterruptedException {
//		WebDriverManager.chromedriver().setup();
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\sabari\\Desktop\\Maven\\MavenProject\\drivers\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("https://dev68594.service-now.com/");
		driver.switchTo().frame("gsft_main");
		driver.findElementById("user_name").sendKeys("admin");
		driver.findElementByName("user_password").sendKeys("India@123");
		driver.findElementById("sysverb_login").click();
		driver.switchTo().defaultContent();
		driver.findElementById("filter").sendKeys("incident");
		Thread.sleep(6000);
		WebElement selectAllOption = driver.findElementByXPath("(//div[@class='sn-widget-list-content']/div[text()='All'])[2]");
		selectAllOption.click();
		Thread.sleep(6000);
		driver.switchTo().frame("gsft_main");
		driver.findElementById("sysverb_new").click();
		driver.findElementById("lookup.incident.caller_id").click();
		Set<String> windowHandle = driver.getWindowHandles(); 
		List<String> handles=new ArrayList<String>(windowHandle);
		driver.switchTo().window(handles.get(1));
//		System.out.println(driver.getTitle());
		WebElement searchBox =driver.findElementByXPath("//label[text()='Search']/following-sibling::input");
		searchBox.sendKeys("Abraham"); 
		searchBox.sendKeys(Keys.ENTER);
		Thread.sleep(6000);
		driver.findElementByXPath("(//table[@id='sys_user_table']//tbody//td/a[@class='glide_ref_item_link'])[1]").click();
		driver.switchTo().window(handles.get(0));
//		System.out.println(driver.getTitle());
		driver.switchTo().frame("gsft_main");
		driver.findElementByXPath("//input[@id='incident.short_description']").sendKeys("Test");
		String incidentNo = driver.findElementById("incident.number").getAttribute("value");
		driver.findElementByXPath("(//button[text()='Submit'])[1]").click();
		WebElement searchBox1 =driver.findElementByXPath("//label[text()='Search']/following-sibling::input");
		searchBox1.sendKeys(incidentNo); 
		searchBox1.sendKeys(Keys.ENTER);
		String verifyIncident = driver.findElementByXPath("(//table[@id='incident_table']//tr/td[@class='vt']/a)[1]").getText();
		if(verifyIncident.equals(incidentNo))
		{
			System.out.println("Incident "+incidentNo+" is created Successfully");
		}
		else
		System.out.println("Incident creation failed");
		
	}

}
