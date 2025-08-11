package AProject.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AProject.AbstractComponents.AbstractComponent;
import AProject.pageobjects.ProductCatalogue;

public class LandingPage extends AbstractComponent{

		WebDriver driver;

		public LandingPage(WebDriver driver) 
		{
			//initialization
			super(driver);
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}
		
		//PageFactory
		
		@FindBy(id = "userEmail")
		WebElement userEmail;
		
		@FindBy(id = "userPassword")
		WebElement passwordEle;
		
		@FindBy(id = "login")
		WebElement submit;
		
		public ProductCatalogue loginApplication(String email,String password)
		{
			userEmail.sendKeys(email);
			passwordEle.sendKeys(password);
			submit.click();
			ProductCatalogue productCatalogue = new ProductCatalogue(driver);
			return productCatalogue;
		}
		
		public void goTo() 
		{
			driver.get("https://rahulshettyacademy.com/client/");			
		}
		
		
}
