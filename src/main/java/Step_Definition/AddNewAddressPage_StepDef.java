package Step_Definition;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AddNewAddressPage_StepDef {

	
	WebDriver driver;

	@Given("^going to address page$")
	public void going_to_address_page(DataTable user){
	List<List<String>> data = user.raw();
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Kiriti\\eclipse-workspace\\Java_Selenium\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver(); 
		driver.get("https://www.target.com.au/login");
		driver.findElement(By.id("j_username")).sendKeys(data.get(0).get(0));
		driver.findElement(By.id("j_password")).sendKeys(data.get(0).get(1));
		driver.findElement(By.id("login")).click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	    driver.findElement(By.xpath("//a[@title= 'My Address Details']")).click();
	     
	}

	@When("^confirm my address page$")
	public void confirm_my_address_page(){
	     String title = driver.getTitle();
	     System.out.println(title);
	}

	@Then("^enter new address$")
	public void enter_new_address(DataTable address){
		 List<List<String>> details = address.raw();
		  driver.findElement(By.xpath("//a[contains(text(), 'Add new address')]")).click();
		  driver.findElement(By.xpath("//input[@class= 'AddressLookupElement-searchField text ui-autocomplete-input']")).sendKeys(details.get(0).get(0));
		  driver.findElement(By.id("address.phoneNumber")).sendKeys(details.get(0).get(1));
	}

//	@Then("^close the browser$")
//	public void close_the_browser(){
//		
//		driver.quit();
	     
//	}
}
