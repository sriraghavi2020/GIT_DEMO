Feature: TargetAus feature 

@WithExample 
Scenario Outline: TargetAus login page test 
	Given Already in loging page 
	When confirm login page 
	Then enter user name "<username>" 
	And enter password "<password>" 
	Then press login button 
	
	
	
	Examples: 
		|username|password|
		|sriraghavi2020@gmail.com|buvimr94|
		|kiritik9@gmail.com|kiriti|
		
		
		
		@WithoutExample 
		Scenario: TargetAus address page test 
			Given going to address page by entering "sriraghavi2020@gmail.com" and "buvimr94" 
			When confirm address page 
			Then enter new address and save 
			Then close the window 
			
		@DataTable 
		Scenario: TargetAus add address in address page test 
			Given going to address page 
				|sriraghavi2020@gmail.com|buvimr94|
			When confirm my address page 
			Then enter new address 
				|107 power road, Doveton 3177|470528254|
				
		@Maps 
		Scenario: TargetAus add address with map 
			Given going to address page with map 
				|username|password|
				|sriraghavi2020@gmail.com|buvimr94|
			When confirm my address page with map 
			Then enter new address with map 
				|address|phone|
				|107 power road, Doveton 3177|470528254|
				
		@Hooks 
		Scenario: TargetAus add address in address page test 
			Given going to address page from login 
				|sriraghavi2020@gmail.com|buvimr94|
			When confirm my address page with hooks 
			Then enter new address with hooks 
				|107 power road, Doveton 3177|470528254|
				
		