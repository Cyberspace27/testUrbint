# README

Demo for Urbint test

# Preconditions 
1 - TestNG (Require manual installation in the last versions of eclipse)
2 - Chrome driver last version
3 - Eclipse 

# Installing
This is a maven proyect so is only require to install the dependecies ( select Update maven dependencies )

# Run the proyect
 - There is a xmls folder select any xml file ( FullRegressionSuite.xml )  
 - Click on the xml file and select "Run As" => TestNG Suite

# Note
- The chrome webdriver should be added in the "C://" folder
- Inside of the proyect is the chrome webdriver zip & testNG Jar 7.3.0

# Report 
When the proyect run after the execution the report is build inside of the folder test-output open in any browser the file emailable-report.html

# Todo
- Use the dependencie bonigarcia to manage the chrome driver version in a dinamic way
- Update gitIgnore file to not push the folder test-output and other temp files
- Create function to manage and validate the system messages in the login page
- MIssing one validation method