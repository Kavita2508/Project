package test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class NewTest {
	public static WebDriver driver;
	 
	@Test
	  public void rediffTest() throws InterruptedException, IOException {
		Thread.sleep(5000);
	 
		String []portfolioName = excelData.readXL1();
		
		for(int counter =1; counter<portfolioName.length;counter++)
		{
		    driver.findElement(By.xpath("//*[@id=\'createPortfolio\']/img")).click();
			driver.findElement(By.xpath("//*[@id=\'create\']")).clear();
			driver.findElement(By.xpath("//*[@id=\'create\']")).sendKeys(portfolioName[counter]);
			driver.findElement(By.xpath("//*[@id=\'createPortfolioButton\']")).click();
			Thread.sleep(5000);
		}
	 
			
	  }
	  @BeforeTest
	  public void beforeTest() {
		  System.setProperty("webdriver.chrome.driver","C:\\Drivers\\chromedriver_win32\\chromedriver.exe");
	       WebDriver driver=new ChromeDriver();	
driver.get("https://portfolio.rediff.com/portfolio-login");
		
		WebElement uname = driver.findElement(By.id("useremail"));
		uname.sendKeys("kavitakhajure606@gmail.com");
		
		driver.findElement(By.id("userpass")).sendKeys("Kavita@2508");
		
		driver.findElement(By.id("loginsubmit")).click();
	   	
	 }

	  @AfterTest
	  public void afterTest() throws InterruptedException {
		  Thread.sleep(5000);
		  driver.quit();
		  
	  }

	}