package Test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class IncubyteTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\LENOVO\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.gmail.com/");
		//Enter valid email & password
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("abc@gmail.com");
		System.out.println("Entered email");
		driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
		System.out.println("Next clicked");
		driver.findElement(By.cssSelector("input[name='password']")).sendKeys("xyz");
		System.out.println("Password clicked");
		driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
		System.out.println("Next clicked");
		WebElement homePageHeader = driver.findElement(By.xpath("//h1[contains(text(),'Welcome')]"));
		boolean b = homePageHeader.isDisplayed();
		System.out.println("Header in gmail home page present: " + b); // click on menu
		// :: section to navigate to gmail app
		driver.findElement(By.cssSelector("svg.gb_Ue")).click();
		System.out.println("Menu clicked");
		// click on gmail to navigate to gmail home
		driver.findElement(By.xpath("//span[contains(text(),'Gmail')]")).click();
		System.out.println("Gmail app clicked");
		//gmail home page opens in new window so navigating to new window
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> it=handles.iterator();
		String parentId=it.next();
		String childId=it.next();
		driver.switchTo().window(childId);	
		WebElement composeBtn = driver.findElement(By.xpath("//div[contains(text(),'Compose')]"));
		boolean c = composeBtn.isDisplayed();
		System.out.println("Compose present in gmail home page: " + c);
		composeBtn.click();
		System.out.println("Clicked compose button");
		WebElement composeHeader = driver.findElement(By.xpath("//span[contains(text(),'New Message')]"));
		boolean h = composeHeader.isDisplayed();
		System.out.println("Compose popup opened: " + h);
		driver.findElement(By.xpath("//div[contains(text(),'Recipients')]")).sendKeys("pooja@incubyte.co");
		driver.findElement(By.xpath("//input[@name='subjectbox']")).sendKeys("Incubyte Test");
		driver.findElement(By.xpath("//div[@aria-label='Message Body']")).sendKeys("Hi, Checking Sign In & compose functionality in gmail.");
		System.out.println("mail drafted");
		driver.findElement(By.xpath("//div[@class='dC']")).click();
		System.out.println("Mail sent");
		//logout
		driver.findElement(By.xpath("//img[@class='gb_Ba gbii']")).click();
		driver.findElement(By.xpath("//div[contains(text(),'Sign out')]")).click();
		//close all browsers
		driver.quit();
	}

}
