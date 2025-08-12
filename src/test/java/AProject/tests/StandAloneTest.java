package AProject.tests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import AProject.pageobjects.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAloneTest {

	public static void main(String[] args) {

			String productName = "ZARA COAT 3";
			WebDriverManager.firefoxdriver().setup();
			WebDriver driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.manage().window().maximize();
			driver.get("https://rahulshettyacademy.com/client/");
			LandingPage landingPage = new LandingPage(driver);
			
			driver.findElement(By.id("userEmail")).sendKeys("zinmemekyaw209@gmail.com");
			driver.findElement(By.id("userPassword")).sendKeys("Zmmk@193110");
			driver.findElement(By.id("login")).click();
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".col-lg-4")));
			
			List<WebElement> products = driver.findElements(By.cssSelector(".col-lg-4"));
			
			WebElement prod = products.stream().filter(product -> 
			product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
			prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".toast-container")));
			//ng-animating
			wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
			
			//button[@routerlink='/dashboard/cart']
			driver.findElement(By.xpath("//button[@routerlink='/dashboard/cart']")).click();
			
			List<WebElement> cartProducts = driver.findElements(By.cssSelector(".cartSection h3"));
			Boolean match = cartProducts.stream().anyMatch(cartProduct-> cartProduct.getText().equalsIgnoreCase(productName));
			Assert.assertTrue(match);
			
			driver.findElement(By.cssSelector(".totalRow button")).click();
			
			Actions a = new Actions(driver);
			a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")),"india").build().perform();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
			
			driver.findElement(By.cssSelector(".ta-item:nth-of-type(2)")).click();
			driver.findElement(By.cssSelector(".action__submit ")).click();
			
			driver.findElement(By.cssSelector(".hero-primary")).getText().equalsIgnoreCase("THANKYOU FOR THE ORDER.");
			driver.close();
		
<<<<<<< HEAD
=======
			//Git Testing
			System.out.println("Updated");
>>>>>>> f266d9e (updated pom.xml file)
			
	}

}
