package CucumberFramework.steps;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.*;

public class StepsFile {

	WebDriver driver;
	private String login = "antonovdmitry90@gmail.com";
	private String password = "Dd52544754Dd!";

	@Before
	public void setup() {
		System.setProperty("webdriver.gecko.driver", "src\\test\\java\\CucumberFramework\\resources\\geckodriver.exe");
		this.driver = new FirefoxDriver();
		this.driver.manage().window().maximize();
		this.driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
	}
	
	@After
	public void shutDown() {
		driver.close();
	}

	@Given("^User navigates to stackoverflow website$")
	public void user_navigates_to_stackoverflow_website() throws Throwable {
		driver.get("https://stackoverflow.com/");
	}

	@Given("^User clicks on the login button$")
	public void user_clicks_on_the_login_button() throws Throwable {
		driver.findElement(By.cssSelector("li a[class='login-link s-btn s-btn__filled py8 js-gps-track']")).click();
	}

	@Given("^User enters a valid username$")
	public void user_enters_a_valid_username() throws Throwable {
		driver.findElement(By.cssSelector("input#email")).sendKeys(login);
	}

	@Given("^User enters a valid password$")
	public void user_enters_a_valid_password() throws Throwable {
		driver.findElement(By.cssSelector("input#password")).sendKeys(password);
	}

	@When("^User ckicks on the login button$")
	public void user_ckicks_on_the_login_button() throws Throwable {
		driver.findElement(By.cssSelector("button#submit-button")).click();
	}

	@Then("^User should be moved to the succesfull login page$")
	public void user_should_be_moved_to_the_succesfull_login_page() throws Throwable {
		WebElement homeLink = driver.findElement(By.cssSelector("li[class=' youarehere'] div[class='grid ai-center']>div[class=\"grid--cell truncate\"]"));
		Assert.assertEquals(true, homeLink.isDisplayed());
	}
}
