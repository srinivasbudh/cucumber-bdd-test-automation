# Selenium Test Automation with Cucumber BDD

UI Test Automation Architecture using Java, Selenium WebDriver with Cucumber BDD built in maven.

## Languages and Frameworks

The project uses the following:
- *[Java 11](https://openjdk.java.net/projects/jdk/11/)* as the programming language.
- *[Selenium WebDriver](https://www.selenium.dev/)* as the web browser automation framework using the Java binding.
- *[cucumber](https://cucumber.io/)* BDD framework to define the behaviour of application.
- *[JUnit](https://junit.org/junit4/)* as the testing framework.
- *[AssertJ](https://assertj.github.io/doc/)* as the assertion library.
- *[Extent Reports](https://www.extentreports.com/)* as the test reporting strategy.
- *[Maven](https://maven.apache.org/)* as the build tool.
- *[IntelliJ IDEA](https://www.jetbrains.com/idea/)* as the IDE.

## Project Structure
```bash
cucumber-bdd-test-automation/
   |-drivers
   |-output
   |-src
   |---main
   |-----java
   |-------com
   |---------automation
   |-----------pages
   |-----------steps
   |-----------utils
   |---test
   |-----java
   |-------features
   |-------runner
   |-----resources

```
## Project Architecture
- [Config](#config)
- [Driver](#driver)
- [Page](#page)
- [Report](#report)


### Config
The project uses [general.properties](src/test/resources/config.properties) file to map all the global parameters such as browser and base url. All the relevant classes to read the parameters are provided in the [config](src/main/java/com/automation/utils/configUtils.java) package.

### Driver
The project uses Selenium WebDriver to automate user workflows for web-based applications as part of automated testing. The [driver](drivers/) package contains all the necessary initialization logic for WebDriver.

### Page
The project uses Page Object Model to capture all the relevant UI components and functionalities of a web page. The [page](src/main/java/com/automation/pages) package provides all the classes to achieve this. For convenience, there is an example class - [LoginPage.java](src/main/java/com/automation/pages/LoginPage.java) to demonstrate the usage.

### Report
The project uses *Extent Reports* to provide test reporting functionalities. The [report](output/testReport.html) package contains the relevant class.


## Test explanation
````
I have automated below flows as per the suggestion in test assignment
	a) Open Account flow
	b) Login
	c) Rate Calculation flow
	d) Tracking flow
````
As testing is performed in production I have not fully created account also did few false assertions


# How to Run the tests

	# Pre-requisite:
	* JDK 8
	* Maven is installed in the machine and configured properly


## 1) Using Maven

	Open a command window and run:

		WindowsOS:	mvn clean verify

		MacOs : mvn clean verify 


## 2) Using IDE
	Open the cloned project in IDE. Enable Auto-Import for Maven-dependency
	Run Testrunner files in the path (\src\test\java\runner\TestRunner.java)


## Test Reports

Below is the screenshot of test report generated by extent reports

![alt text](output/TestResult.png?raw=true)

## Bug

When user creates an account and create userId, the hannover menu still shows login option and open my account option as displayed in the below screenshot. However after refresh everything will look nnormal.

![alt text](output/Bug_Image.png?raw=true)