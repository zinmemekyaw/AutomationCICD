package AProject.tests;

import java.io.IOException;
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
import org.testng.annotations.Test;

import AProject.TestComponents.BaseTest;
import AProject.pageobjects.CartPage;
import AProject.pageobjects.LandingPage;
import AProject.pageobjects.ProductCatalogue;
import AProject.pageobjects.CheckoutPage;
import AProject.pageobjects.ConfirmationPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SubmitOrderTest extends BaseTest{

	@Test
	public void submitOrder() throws IOException, InterruptedException
	{
			String productName = "ZARA COAT 3";
			LandingPage landingPage = lunchApplication();
			
			ProductCatalogue productCatalogue = landingPage.loginApplication("zinmemekyaw209@gmail.com", "Zmmk@193110");
			List<WebElement> products = productCatalogue.getProductList();
			productCatalogue.addProductToCart(productName);
			CartPage cartPage = productCatalogue.goToCartPage();
			
			Boolean match = cartPage.VerifyProductDisplay(productName);
			Assert.assertTrue(match);
			CheckoutPage checkoutPage = cartPage.goToCheckout();
			checkoutPage.selectCountry("india");
			
			ConfirmationPage confirmationPage = checkoutPage.submitOrder();
			String confirmMessage = confirmationPage.getConfirmationMessage();
			Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
			driver.close();

	}
}
