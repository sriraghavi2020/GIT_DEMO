package Step_Definition;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
//import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
//import cucumber.api.java.en.When;

public class AddressPage_StepDef {
	WebDriver driver;

	@Given("^going to address page by entering \"(.*)\" and \"(.*)\"$")
	public void going_to_address_page_by_entering(String username, String password){
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Kiriti\\eclipse-workspace\\Java_Selenium\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver(); 
		driver.get("https://www.target.com.au/login");
		driver.findElement(By.id("j_username")).sendKeys(username);
		driver.findElement(By.id("j_password")).sendKeys(password);
		driver.findElement(By.id("login")).click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	    driver.findElement(By.xpath("//a[@title= 'My Address Details']")).click();
	     
	}

	@When("^confirm address page$")
	public void confirm_address_page(){
	     String title = driver.getTitle();
	     System.out.println(title);
	}

	@Then("^enter new address and save$")
	public void enter_new_address_and_save(){
		 
		  driver.findElement(By.xpath("//a[contains(text(), 'Add new address')]")).click();
		  driver.findElement(By.xpath("//input[@class= 'AddressLookupElement-searchField text ui-autocomplete-input']")).sendKeys("107, power road, doveton 3177");
	}

	@Then("^close the window$")
	public void close_the_window(){
		
		driver.quit();
	     
	}

}
