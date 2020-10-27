package StepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class Login {
	
		WebDriver driver;
		
		@Before
		public void bt() {
			System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		}
		
		@After
		public void at() throws InterruptedException {
			Thread.sleep(3000);
			driver.close();
		}
		
		@Given("I am able to navigate on to login page")
		public void i_am_able_to_navigate_on_to_login_page() {
			driver.navigate().to("https://opensource-demo.orangehrmlive.com/");
		}

		@When("I update the username as {string}")
		public void i_update_the_username_as(String string) {
			driver.findElement(By.xpath("//*[@id='txtUsername']")).sendKeys(string);
		}
		
		@When("I update the password as {string}")
		public void i_update_the_password_as(String string) {
			driver.findElement(By.xpath("//*[@id='txtPassword']")).sendKeys(string);
		}
		
		@When("I click on the login button")
		public void i_click_on_the_login_button() {
			driver.findElement(By.id("btnLogin")).click();
		}
		
		@Then("I should see username as {string}")
		public void i_should_see_username_as(String string) throws InterruptedException {
		    Thread.sleep(6000);
			String expected = driver.findElement(By.xpath("//*[@id='welcome']")).getText();
		    Assert.assertEquals(expected, string);
		    Thread.sleep(3000);
			driver.findElement(By.xpath("//*[@id='welcome']")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[@id='welcome-menu']/ul/li[2]/a")).click();
		}
		
		@Then("I should see error message as {string}")
		public void i_should_see_error_message_as(String string) throws InterruptedException {
		    Thread.sleep(6000);
			String expected = driver.findElement(By.id("spanMessage")).getText();
			Assert.assertEquals(expected, string);
		}

}
