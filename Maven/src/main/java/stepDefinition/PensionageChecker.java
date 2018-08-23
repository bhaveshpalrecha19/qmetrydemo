package stepDefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;	
import cucumber.api.java.en.When;
import junit.framework.Assert;
import cucumber.api.java.en.Then;

public class PensionageChecker 
{
	WebDriver driver = null;
	@Given("^User navigates to \"(.*?)\"$")
	public void user_navigates_to(String Url) throws Throwable  
	{
		System.setProperty("webdriver.chrome.driver","D://chromedriver_win32//chromedriver.exe");
		driver = new ChromeDriver(); 	
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
        driver.get(Url);
	}

	@When("^User enters  \"(.*?)\"  and  \"(.*?)\"$")
	public void user_enters_and(String Arg1, String Arg2) throws Throwable 
      {
    	  
    	  
    	  WebElement Datevalue = driver.findElement(By.xpath("//*[@id='dbody']/div[2]/div[1]/div[1]/div[3]/input"));
    	  Datevalue.sendKeys(Arg1);
    	  driver.manage().timeouts().implicitlyWait(120,TimeUnit.SECONDS); 
    	  Thread.sleep(2000);
    	  WebElement Regimevalue = driver.findElement(By.xpath("//*[@id='dbody']/div[2]/div[1]/div[3]/div[3]/select"));
    	  Regimevalue.sendKeys(Arg2);  	  
    	  driver.manage().timeouts().implicitlyWait(120,TimeUnit.SECONDS);
    	  Thread.sleep(2000);
      }

     @When("^User Clicks on calculate PensionAge button$")
     public void user_Clicks_Pensionage_Calculate( ) throws Throwable 
     {
    	 
       WebElement PensionAge_button = driver.findElement(By.xpath("//*[@id='dbody']/div[2]/div[2]/button"));
       PensionAge_button.click();
       driver.manage().timeouts().implicitlyWait(120,TimeUnit.SECONDS);  
       Thread.sleep(2000);
     }

     @SuppressWarnings("deprecation")
	@Then("^Aow age needs to be displayed$")
     public void aow_age_needs_to_be_displayed() throws Throwable
     {
    	WebElement Aow_Pension_Age = null;
     	WebElement Aow_Date = null;
    	JavascriptExecutor jsx = (JavascriptExecutor)driver;
    	jsx.executeScript("window.scrollBy(0,450)", "");
     
    	
    	
      	Aow_Pension_Age = driver.findElement( By.xpath("//*[@id='dbody']/div[2]/div[3]/div[3]/div[2]/b"));      
    	String Aow_Pension_Age_value = Aow_Pension_Age.getText();	
    	System.out.println(Aow_Pension_Age_value);
    		
    
    	
        Aow_Date = driver.findElement( By.xpath("//*[@id='dbody']/div[2]/div[3]/div[3]/div[1]/b"));
    	String Aow_Date_value = Aow_Date.getText();	
    	System.out.println(Aow_Date_value);   
        Thread.sleep(2000);
        driver.manage().timeouts().implicitlyWait(120,TimeUnit.SECONDS);
        driver.close();
                
        
        Assert.assertTrue("Aow Age not returned",Aow_Pension_Age_value.contains(" "));
        Assert.assertTrue("Aow_Date not returned",Aow_Date_value.contains(" "));
      	
                   
     }
     
     
     
}