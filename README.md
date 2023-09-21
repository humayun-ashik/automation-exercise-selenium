# UI Test Automation using Selenium, TestNG, POM

## Languages and Frameworks

The project uses the following:
- *[Java 11](https://www.oracle.com/java/technologies/javase/jdk11-archive-downloads.html)* as the automation source language.
- *[Selenium WebDriver](https://www.selenium.dev/documentation/webdriver/)* as the test automation framework.
- *[TestNG](https://testng.org/doc/)* as the testing framework and assertion.
- *[IntelliJ IDEA](https://www.jetbrains.com/idea/)* as the IDE.
- *[Maven]()* as the projects libraries management
- *[Log4j]()* used for logging.
- *[ExtentReports]()* for report generation.

## Installation and Run
1. Clone the git repo — `git clone https://github.com/humayun-ashik/webdriverio-mocha-ui-automation.git`
2. Then download all the maven dependencies mentioned in `pom.xml`
3. In `/Drivers` directory place your browsers driver that suits.
4. Then go to `testng.xml` file set your desired browser and run `\src\testng.xml` from IDE.

## Project Details
1. In `testng.xml` file - test suite, browser options and test listener class is loaded.
2. This project follows Page Object Model(POM) design patterns.
3. In target test website - there are many ads appeared in different pages randomly which troubles selenium to locate page elements. To resolve this Adblocker is installed first to disable all the ads.
4. In `log4j.properties` file log patterns and log saving location is written.
5. `extent-config.xml` file is used to set the extent reports configuration.
6. In `/test-output` directory generated reports are saved as .html file which could be opened in any browsers to view the report.

