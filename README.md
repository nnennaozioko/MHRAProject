# MHRAProject

# Job Search Automation Framework
This project automates a web testing scenario for the Civil Service Jobs website using Cucumber BDD and Selenium. The automation covers searching for jobs, filtering results, and verifying job details using a structured and scalable automation framework.
 It includes browser setup, page navigation, and job search handling using Selenium and Java.
 
# Project Overview
The automation script performs the following tasks:
•	Launch the Civil Service Jobs website – Open the URL: https://www.civilservicejobs.service.gov.uk/csr/index.cgi
•	Search for Jobs – Search for job openings with the title containing "Analyst" in London.
•	Validate Search Results – Ensure that relevant job listings appear in the search results

# Additional Actions:
•	Filter by Department: Medicines and Healthcare products Regulatory Agency.
•	Select the first available job listing.
•	Verify the number of jobs listed on the job details page.

# Challenge Goal:
Civil Service Code Verification:
•	Navigate to "Working for the Civil Service."
•	Open the "Civil Service Code" in a new window.
•	Validate that the link redirects to the "Code" section of the Civil Service Commission website.

# What I considered
•	Used the Page Object Model to organize element locators.
•	Kept step definitions clean and focused on test logic.
•	Captured logs and screenshots for better debugging.
•	Made the framework scalable for future tests.
•	Used meaningful names for locators and methods.

# Project Structure:
src
test
java
•	cucumberOptions- Test runners
•	hooks- Setup and teardown logic
         - Browser initialization, page load, and teardown
•	page objects- Page Object classes for web elements
                    - SearchJobOpeningsPage.java
                    - CivilServiceCodePage.java
•	utilities-  Utility classes and option management
•	stepDefinitions- Step definitions for Cucumber

 resources
•	features- Gherkin feature files
•	extent.properties- Configuration properties
•	testing.xml- Rrunning and organizing automated tests in Java.
 pom.xml- Maven dependencies and build configuration

# Setup Instructions
1. Clone the Repository
2. Install Dependencies
3. Set Up Browsers
•	Install Chrome, Firefox, or Edge.
•	Update src/test/resources/extent.properties with browser
## 4.  Run Tests with Specific Tags:
•	Right-click the feature file and select Run or use the TestRunner:
•	Double-click the TestRunner class and click the green arrow
•	OR right-click the TestRunner class and select Run

# 5.  Configuration
extent.properties (Example)

# 6. Set browser type and mode:
    Properties
   browser=chrome
   
# 7.  Framework Components
1. BasePage.java (hooks.BasePage)
•	Initializes the WebDriver based on the browser type.
•	Loads configuration from extent.properties.
•	Handles page load and teardown.
2. Page Objects
Page Object Model (POM) simplifies element access and test maintenance:
•	SearchJobOpeningsPage.java (pageObjects.SearchJobOpeningsPage)
   Contains locators and methods to interact with job search components
•	CivilServiceCodePage.java (pageObjects.CivilServiceCodePage)
   Contains locators and methods to interact with Civil Service Code-related components

3. OptionManager.java (utilities.OptionManager)
•	Handles browser-specific options for Chrome and Firefox.

4. Step Definitions
•	Maps Gherkin steps to Java methods.

5. Screenshots & Logs
•	The framework captures screenshots automatically after each step using @AfterStep:
Execution Logs:
•	Logs are stored under /target/cucumber-reports/.

6. Sample Test Report
After running the tests, the reports will be generated at:
target/cucumber-reports/index.html
