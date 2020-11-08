Feature: Login into account
	Existing user should have ability to login to account using correct credentials
	
Scenario: Login into account with correct credentials

Given User navigates to stackoverflow website
And User clicks on the login button
And User enters a valid username
And User enters a valid password
When User ckicks on the login button
Then User should be moved to the succesfull login page