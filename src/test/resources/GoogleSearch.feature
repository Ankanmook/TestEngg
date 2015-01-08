Feature: Search
	

Scenario: Google
	Given on google search page
	When enter "Gamesys" into search field
	And click on search button
	Then verify the first link text "Gamesys"
	
	
		  
