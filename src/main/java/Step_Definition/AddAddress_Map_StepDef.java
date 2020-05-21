package Step_Definition;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AddAddress_Map_StepDef {
	WebDriver driver;

	@Given("^going to address page with map$")
	public void going_to_address_page_with_map(DataTable details) {
		
		for(Map<String, String> data : details.asMaps(String.class, String.class))
		{
		driver = new ChromeDriver();
		driver.get("https://www.target.com.au/login");
		driver.findElement(By.id("j_username")).sendKeys(data.get("username"));
		driver.findElement(By.id("j_password")).sendKeys(data.get("password"));
		driver.findElement(By.id("login")).click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[@title= 'My Address Details']")).click();
	}
	}

	@When("^confirm my address page with map$")
	public void confirm_my_address_page_with_map() {
		String title = driver.getTitle();
		System.out.println(title);
	}

	@Then("^enter new address with map$")
	public void enter_new_address_with_map(DataTable data) {
		for(Map<String, String> details : data.asMaps(String.class, String.class)) {
			driver.findElement(By.xpath("//a[contains(text(), 'Add new address')]")).click();
			driver.findElement(By.xpath("//input[@class= 'AddressLookupElement-searchField text ui-autocomplete-input']"))
					.sendKeys(details.get("address"));
			driver.findElement(By.id("address.phoneNumber")).sendKeys(details.get("phone"));
			
		}
		
	}

}
