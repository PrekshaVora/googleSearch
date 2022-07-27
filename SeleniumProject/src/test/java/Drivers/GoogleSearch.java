package Drivers;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;




public class GoogleSearch {

	public static WebDriver driver;
	public static void main(String[] args) {
	
		String path = System.getProperty("user.dir")+ "\\src\\test\\resources\\Driver\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver",path);
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.google.com");
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		//identify element
		WebElement searchTextfield = driver.findElement(By.name("q"));
		searchTextfield.sendKeys("Selenium java"); //enter text with sentKey()
		
		//Explicit wait
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul")));
		searchTextfield.submit();
		driver.close();
//		
	}

	
}
