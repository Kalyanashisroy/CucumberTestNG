package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginStepDefinition {
	WebDriver driver;
	@Given("^user is already on Login Page$")
	public void user_is_already_on_Login_Page(){
	   System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
	   driver=new ChromeDriver();
	   driver.manage().window().maximize();
	   driver.get("https://ui.freecrm.com/");
	}
	
	@When("^title of login page is Free CRM$")
	public void title_of_login_page_is_Free_CRM(){
		String title=driver.getTitle();
		System.out.println(title);
		Assert.assertEquals("Free CRM #1 cloud software for any business large or small", title);
	   
	}

	@Then("^user enters \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_enters_and(String username, String password) throws Throwable {
	    driver.findElement(By.name("email")).sendKeys(username);
	    driver.findElement(By.name("password")).sendKeys(password);
	}

	@Then("^user clicks on login button$")
	public void user_clicks_on_login_button() throws Throwable {
	    WebElement loginBtn=driver.findElement(By.xpath("//div[@class='ui fluid large blue submit button']"));
	    JavascriptExecutor js=(JavascriptExecutor)driver;
	    js.executeScript("arguments[0].click();", loginBtn);
	}

	@Then("^user is on home page$")
	public void user_is_on_home_page() throws Throwable {
	   String title=driver.getTitle();
	   System.out.println("Home Page Title:"+title);
	   Assert.assertEquals("Cogmento CRM", title);
	}

	@Then("^close the browser$")
	public void close_the_browser() throws Throwable {
	    driver.quit();
	}

}
