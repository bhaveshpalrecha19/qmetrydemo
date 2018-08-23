package stepDefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;	
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;

public class PensionageChecker 
{
	WebDriver driver = null;

    @Given("^User navigates to \"(.*?)\"$")
    public void user_navigates_to(String arg1) throws Throwable 
	{
		System.setProperty("webdriver.chrome.driver","D://chromedriver_win32//chromedriver.exe");
		driver = new ChromeDriver(); 	
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
        driver.get(arg1);
	}

    @When("^User enters  \"(.*?)\"  and  \"(.*?)\"$")
    public void user_enters_and(String Arg1, String Arg2) throws Throwable
      {
    	  
    	  
    	  WebElement usname= driver.findElement(By.xpath("//*[@id='USER']"));
    	  usname.sendKeys(Arg1);
    	  driver.manage().timeouts().implicitlyWait(120,TimeUnit.SECONDS); 
    	  Thread.sleep(2000);
    	  WebElement upwd = driver.findElement(By.xpath("//*[@id='PASSWORD']"));
    	  upwd.sendKeys(Arg2);  	  
    	  driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
    	  Thread.sleep(100);
      }

    @When("^User Clicks on login button$")
    public void user_Clicks_on_login_button() throws Throwable 
     {
    	 
       WebElement login_button = driver.findElement(By.xpath("//*[@id='login_button']"));
       login_button.click();
       driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);  
       Thread.sleep(100);
     }

    @Then("^Ultimatix homepage  needs to be displayed$")
    public void ultimatix_homepage_needs_to_be_displayed() throws Throwable 
     {
    	
    	System.out.println("login succsefull");
        driver.close();    	
                   
     }
     
}    
     
             