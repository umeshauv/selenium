package newpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class LoginTestClass {
	public static void main(String[] args) throws InterruptedException {
		// System.setProperty("webdriver.gecko.driver", "C:\\\\Users\\\\User\\\\geckodriver-v0.27.0-win64\\\\geckodriver.exe");
		// WebDriver driver = new FirefoxDriver();
		System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\User\\\\ChromeDriver\\\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		String baseUrl = "http://www.demo.guru99.com/V4/";
		
		// Launch chrome and open Base URL
		driver.get(baseUrl);
		
		
		// Send Username and Password
		WebElement uid = driver.findElement(By.name("uid"));
		WebElement passwd = driver.findElement(By.name("password"));
		WebElement login = driver.findElement(By.name("btnLogin"));

		uid.sendKeys("mngr285664");
		passwd.sendKeys("jyzepAs");
		login.click();
		
		
		// Validate if login is successful

		String expectedUrl = "http://www.demo.guru99.com/V4/manager/Managerhomepage.php";
		String actualUrl = driver.getCurrentUrl();
		if (actualUrl.equalsIgnoreCase(expectedUrl)) { 
				System.out.println("Test passed"); 
		} else { 
				System.out.println("Test failed"); 
		} 
		WebElement textDemo = driver.findElement(By.xpath("//td[contains(text(), 'mngr285664')]"));
		 
		if(textDemo.isDisplayed())
		{
			System.out.println("Element found using text");
		} else {
			System.out.println("Element not found");
		}

		// Logout from site.
		driver.findElement(By.xpath("//a[@href='Logout.php']")).click();

		// Close driver and quit browser.
		driver.quit();
	}
}
