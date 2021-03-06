
# Deck of Cards API Testing using Rest-Assured and Cucumber 

## Technologies used
- Java JDK 1.8
- Maven 
- Cucumber
- Rest-Assured

## Steps to execute the test suite
```groovy
$ mvn clean verify
```
## Check the test report
```
$ open target/cucumber-html-reports/overview-features.html
```

## Structure of the application. 
### Gherkin / Cucumber Tests
 The automation tests are written in Gherkin and are under
 ``` src/test/resources/features```
 There are 2 feature files 
 1. Create new Deck : This has 2 scenarios one for creating a normal 52 cards desk using GET and second to create deck with jokers using POST Method
 2. Draw Cards : This has 1 scenario outline with 4 test inputs (Example Table). This scenario tests the deck when the cards are drawn. 
 
### Java Code Organization
- CucumberTest.java is the test runner for the cucumber tests. 
- StepDefinitions is the base class with the required common elements for all the tests.
- UserStepDefinitions is the class with steps implemented for both API endpoints. 

### Possible Refactorings
- We could create the stepDefinitions for each in a new file. 
- Take the input for base url and data from external source (Properties File etc) and load based on command line switch
