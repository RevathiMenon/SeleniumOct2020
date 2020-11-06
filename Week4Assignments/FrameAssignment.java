package week4.day2.assignments;

import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FrameAssignment {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver=new ChromeDriver();
		
		driver.get("http://leafground.com/pages/frame.html");
//Get inside 1st frame to select its elements		
		driver.switchTo().frame(0);
		driver.findElementById("Click").click();
		
//Java Wait		
		Thread.sleep(3000);
		
//To move back to main window		
		driver.switchTo().defaultContent();
//Get inside 2nd frame to select its elements		
		driver.switchTo().frame(1);
		driver.switchTo().frame("frame2");
		driver.findElementById("Click1").click();
		
//To move back to main window		
		driver.switchTo().defaultContent();
		
//To get the count of frames in a webpage
		
		int size = driver.findElementsByTagName("iframe").size();
        System.out.println("Number of main outer frames="+size);

//To get no of frames inside the 3rd frame
        driver.switchTo().frame(2);
        int size1 = driver.findElementsByTagName("iframe").size();
        System.out.println("No of frames inside last frame="+size1);

//To get the no of nested frames in a page 

        int count=size;
        for(int i=0;i<size;i++) 
        {
        driver.switchTo().frame(i);
	    count=count+driver.findElementsByTagName("iframe").size();
	    driver.switchTo().defaultContent();
        }
        System.out.println("Total no of nested frames="+count);
	}

}
