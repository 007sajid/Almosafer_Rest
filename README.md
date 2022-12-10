# Almosafer_Rest

This Readme file explains the API testing Automation Framework for the Almoasfer project.
This project uses Rest Assured library to automate APIs. 

## Language and Libraries used
Java
Rest Assured
JUnit
Maven 
Log4j
Fillo
JsonPath
Gson
Allure Reports

## IDE
I used Eclipse IDE for the development and JDK 11 with Maven configurations to automate test cases and create reports. 



## Framework Structure
There are two main folders comprising of the framework code
Main folder have all the structure required to make JSON request with the data needs. 
  - BaseURL and other endpoints creation from a file in APIConstants.java.
  - Payload created with help of pojo classes. 
  - DataUtils.java have file data connection with it in order to read data from a file. 
2. Test folder have tests setup along with Assertions and JSON reaction
	- API actions gets Json data and returns required value from the json
	- Assertions have multiple assertions which usually required in order to validate APIs
## Tests
	- BaseTest.java lays basis of an API request and can be inherited in most of the API calls of the project.
	- GetFlight.java is a test written to get flights details from one city to another. 
	- PostPricePolicy.java automates a POST API call and verify responses with dynamic dates. Dates data can be provided via Variables and Files.

## How to run
Just pull the code and open in any IDE (Eclipse in my case) 
Import the maven dependencies
Enter following commands in order to see the run.
mvn clean 
mvn test

## Reports
After the code run successfully we can run following command to see the detailed report of the tests.
  allure serve allure-results

### Video
A video is added here of the run as well. 
https://user-images.githubusercontent.com/27945485/206875546-994df439-85e3-4864-ab89-77397a86b762.mp4

