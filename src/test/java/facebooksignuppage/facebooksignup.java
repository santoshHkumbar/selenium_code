package facebooksignuppage;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class facebooksignup {
	WebDriver driver;
	
	
	 @BeforeTest
	 public void bt() {
		 //open the website 
		 WebDriverManager.chromedriver().setup();
		 //open with Chrome browser
		 driver = new ChromeDriver();
		 //Visiting the applications
		 driver.get("https://www.facebook.com/signup");
		 //window to be maximize
		 driver.manage().window().maximize();	

}
	 
	 @Test(alwaysRun = true)
	 public void signup() throws InterruptedException {
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 //enter the firstname
		 driver.findElement(By.name("firstname")).sendKeys("masai");
		 //enter the lastname
		 driver.findElement(By.name("lastname")).sendKeys("school");
		 //enter the phonenumber
		 driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("7411849060");
		 //enter the phonenumber
		 driver.findElement(By.xpath("//input[@name='reg_passwd__']")).sendKeys("masaitest@gmail.com");
		 //data select birthdate
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 	WebElement birth	=		driver.findElement(By.name("birthday_day"));
		 	Select sc = new Select(birth);
		 	sc.selectByValue("30");
		 	//data select birthmonth
			 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			 	WebElement month	=		driver.findElement(By.name("birthday_month"));
			 	Select sc1 = new Select(month);
			 	sc1.selectByValue("4");
			 	//data select birthyear
				 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				 	WebElement year	=driver.findElement(By.name("birthday_year"));
				 	Select sc2 = new Select(year);
				 	sc2.selectByValue("1997");
		  //mutipleradiobutton
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement radio= driver.findElement(By.xpath("(//input[@value='2'])"));
		radio.click();
		//signup
		driver.findElement(By.name("websubmit")).click();
		
		 	
		 
	 }
	 @AfterTest
	 public void colse() {
		 driver.close();
	 }
}
