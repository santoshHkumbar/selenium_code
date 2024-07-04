package automationtesting;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class datapickers {
	WebDriver driver;
	
	
	 @BeforeTest
	 public void bt() {
		 //open the website 
		 WebDriverManager.chromedriver().setup();
		 //open with Chrome browser
		 driver = new ChromeDriver();
		 //Visiting the applications
		 driver.get("https://demo.automationtesting.in/Datepicker.html");
		 //window to be maximize
		 driver.manage().window().maximize();	

}
	 @Test
	 public void t1() {
	 	driver.findElement(By.id("datepicker1")).click();
	 	WebDriverWait wait = new WebDriverWait(driver,30);

	 	wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.className("ui-datepicker-calendar"))));

	 	String actualmonth = driver.findElement(By.className("ui-datepicker-month")).getText();
	 	
	 	String actualyear = driver.findElement(By.className("ui-datepicker-year")).getText();
	 	
	 	
	 	while(!(actualmonth.equals("September")&&actualyear.equals("2020"))) {
	 		
	 		driver.findElement(By.xpath("//a[@data-handler='next']")).click();
	 		
	 		
	 		 actualmonth = driver.findElement(By.className("ui-datepicker-month")).getText();
	 		
	 		 actualyear = driver.findElement(By.className("ui-datepicker-year")).getText();
	 }

	 }
	 @Test
	 public void t2() {
	 	driver.findElement(By.id("datepicker2")).click();
	 	WebElement month=driver.findElement(By.cssSelector("[title=\"Change the month\"]"));

	 	Select sc=new Select(month);
	 	sc.selectByVisibleText("August");
	 	WebElement year= driver.findElement(By.cssSelector("[title=\"Change the year\"]"));
	 	Select sc1= new Select(year);
	 	sc1.selectByVisibleText("2024");;
	 }
	 
	 
	 
	 
	 
	 
	 @AfterTest
	 public void colse() {
		 //driver.close();
	 }
}
