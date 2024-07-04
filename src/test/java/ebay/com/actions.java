package ebay.com;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.implementation.bind.annotation.RuntimeType;

public class actions {
	WebDriver driver;
	
	
	 @BeforeTest
	 public void bt() {
		 //open the website 
		 WebDriverManager.chromedriver().setup();
		 //open with Chrome browser
		 driver = new ChromeDriver();
		 //Visiting the applications
		 driver.get("https://www.ebay.com/");
		 //window to be maximize
		 driver.manage().window().maximize();	

}
	 @Test
	 public void Electronics() {
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 //
		 Actions act = new Actions(driver);
		WebElement drop=      driver.findElement(By.xpath("//li[@class='vl-flyout-nav__js-tab']"));
		act.click(drop).build().perform();
		act.sendKeys(drop,Keys.ARROW_RIGHT).build();
		
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 driver.navigate().back();
	 }
	 @Test(alwaysRun = true ,dependsOnMethods = {"Electronics"})
	 public void Fashion() {
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 //
		 Actions act = new Actions(driver);
		WebElement drop=      driver.findElement(By.xpath("//li[@class='vl-flyout-nav__js-tab'  and @data-currenttabindex='2']"));
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		act.click(drop).build().perform();
		act.sendKeys(drop,Keys.ARROW_LEFT).build();
		act.sendKeys(drop,Keys.ARROW_LEFT).build();
		act.sendKeys(drop,Keys.ARROW_LEFT).build();
		
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 driver.navigate().back();
	 }
	 @AfterTest
	 public void colse() {
		 driver.close();
	 }
	 
}
