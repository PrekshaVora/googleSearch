package Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.xmlbeans.impl.xb.xsdschema.ListDocument.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;




public class GoogleSearch {

	@Test
	public void google_Serach() throws FileNotFoundException {
		
		WebDriver driver;
		String url;
		YamlFileHandler obj = new YamlFileHandler();
		url=obj.readData();
		
		String path = System.getProperty("user.dir")+ "\\src\\test\\resources\\Driver\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver",path);
		driver = new ChromeDriver();
		driver.get(url);
		Assert.assertEquals("Google",driver.getTitle());
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		//identify element
		WebElement searchTextfield = driver.findElement(By.name("q"));
		searchTextfield.sendKeys("Selenium java"); //enter text with sentKey()
		
		
		//Explicit wait
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul")));
		searchTextfield.submit();
		driver.close();		
	}

}

	
