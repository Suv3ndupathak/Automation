package StepDefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class loginStepDefinitions 
{
	WebDriver driver;
	
	
	@When("User is on login page")
	public void user_is_on_login_page() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.gillette.co.uk/");
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Reject All Cookies')]")));
		WebElement cookies=driver.findElement(By.xpath("//button[contains(text(),'Reject All Cookies')]"));
		if(cookies.isDisplayed())
		{
			cookies.click();
		}
		else
		{
			System.out.println("");
		}

			WebElement account=driver.findElement(By.xpath("//span[contains(text(),'Account')]"));
			account.click();
		
	}

	@Then("User enters correct username and password")
	public void user_enters_correct_username_and_password() 
	{
		WebElement Email=driver.findElement(By.xpath("//input[@name='Email address']"));
		Email.sendKeys("johndee099@gmail.com");
		
		WebElement Password=driver.findElement(By.xpath("//input[@name='Password']"));
		Password.sendKeys("Sparrow101#");
	}

	@And("User click on submit button")
	public void user_click_on_submit_button() 
	{

		WebElement Submit=driver.findElement(By.xpath("//button[contains(text(),'Login to your account')]"));
		Submit.click();
	}
	@Then("User should be on home page")
	public void user_should_be_on_home_page() throws InterruptedException 
	{
		
		String url=driver.getCurrentUrl();
		
	    if(url=="https://www.gillette.co.uk/accountHome.account")
	    {
	    	System.out.println("Login Successful");
	    }
	    else
	    {
	    	System.out.println("Login Unsuccessful");
	    }
	    WebElement homePage=driver.findElement(By.xpath("//a[@href='https://www.gillette.co.uk/']"));
	    homePage.click();
    
	}

	@And("Close the browser")
	public void close_the_browser() 
	{
	   driver.close();
	}
}
