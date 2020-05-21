package Step_Definition;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AddAddress_Hooks_StepDef {

	WebDriver driver;
	
	@Before(order=1)
	public void lunchBrowser() {
		System.out.println("Gobal hooks");
		System.out.println("Oder 1");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Kiriti\\eclipse-workspace\\Java_Selenium\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver(); 
		driver.get("https://www.target.com.au/login");
	}
	
	@After(order=1)
	public void closeBrowser() {
		System.out.println("Gobal hooks");
		System.out.println("Oder 1");
		driver.quit();
	}
	
	@Before("@Hooks")
	public void BeforeTaggedHooks()
	{
		System.out.println("Tagged hooks");
		System.out.println("Tagged hooks for @Before method");
	}
	
	@After("@Hooks")
	public void AfterTaggedHooks() {
		System.out.println("Tagged hooks");
		System.out.println("Tagged hooks for @After method");
	}
	
	@Before(order=0)
	public void BeforeOrderingHooks()
	{
		System.out.println("Gobal hooks");
		System.out.println("Oder 0");
		System.out.println("Tagged hooks for @Before method");
	}
	
	@After(order=0)
	public void AfterOrderingHooks() {
		System.out.println("Gobal hooks");
		System.out.println("Oder 0");
		System.out.println("Tagged hooks for @After method");
	}
	
	@Given("^going to address page from login$")
	public void going_to_address_page_form_login(DataTable user){
	List<List<String>> data = user.raw();
		
		driver.findElement(By.id("j_username")).sendKeys(data.get(0).get(0));
		driver.findElement(By.id("j_password")).sendKeys(data.get(0).get(1));
		driver.findElement(By.id("login")).click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	    driver.findElement(By.xpath("//a[@title= 'My Address Details']")).click();
	     
	}

	@When("^confirm my address page with hooks$")
	public void confirm_my_address_page_with_hooks(){
	     String title = driver.getTitle();
	     System.out.println(title);
	}

	@Then("^enter new address with hooks$")
	public void enter_new_address_with_hooks(DataTable address){
		 List<List<String>> details = address.raw();
		  driver.findElement(By.xpath("//a[contains(text(), 'Add new address')]")).click();
		  driver.findElement(By.xpath("//input[@class= 'AddressLookupElement-searchField text ui-autocomplete-input']")).sendKeys(details.get(0).get(0));
		  driver.findElement(By.id("address.phoneNumber")).sendKeys(details.get(0).get(1));
	}

}
