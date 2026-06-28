# AutomationFrameworkUsingSelenium-Java-
Automation framework using selenium with Java
# Selenium Java Automation Framework

## Overview

This project is a robust UI Automation Framework built using **Java**, **Selenium WebDriver**, and **TestNG** for automating end-to-end test scenarios on an eCommerce web application.

The framework follows industry best practices, including the **Page Object Model (POM)** design pattern, reusable utilities, test reporting, logging, and Continuous Integration/Continuous Deployment (CI/CD) using GitHub Actions or Jenkins.

---

## Tech Stack

* Java 17+
* Selenium WebDriver
* TestNG
* Maven
* Page Object Model (POM)
* WebDriverManager
* Extent Reports
* Log4j2
* Apache POI (Excel Data Handling)
* Git
* GitHub
* GitHub Actions / Jenkins (CI/CD)

---

## Project Structure

```
AutomationFramework
│
├── src
│   ├── main
│   │   ├── java
│   │   │   ├── pages
│   │   │   ├── utilities
│   │   │   ├── base
│   │   │   └── listeners
│   │   └── resources
│   │       ├── config.properties
│   │       └── log4j2.xml
│   │
│   └── test
│       ├── java
│       │   ├── tests
│       │   └── dataProviders
│       └── resources
│
├── test-output
├── reports
├── screenshots
├── pom.xml
├── testng.xml
└── README.md
```

---

## Features

* Page Object Model (POM) architecture
* Cross-browser execution (Chrome, Firefox, Edge)
* Data-driven testing using Excel
* Screenshot capture on test failure
* Detailed Extent Reports
* Logging using Log4j2
* TestNG annotations and parallel execution
* Maven dependency management
* Automatic WebDriver management
* Environment configuration through properties file
* CI/CD pipeline integration
* Easy maintenance and scalability

---

## Prerequisites

Ensure the following software is installed:

* Java JDK 17 or later
* Maven 3.8+
* Git
* Chrome / Firefox / Edge browser
* IDE (IntelliJ IDEA or Eclipse)

Verify installation:

```bash
java -version
mvn -version
git --version
```

---

## Installation

Clone the repository:

```bash
git clone https://github.com/yourusername/selenium-java-framework.git
```

Navigate to the project:

```bash
cd selenium-java-framework
```

Install dependencies:

```bash
mvn clean install
```

---

## Running Tests

Execute all tests:

```bash
mvn test
```

Run a specific TestNG suite:

```bash
mvn test -DsuiteXmlFile=testng.xml
```

Run with a specific browser:

```bash
mvn test -Dbrowser=chrome
```

---

## Test Reports

After execution, reports are generated in:

```
/test-output
/reports
```

The Extent Report includes:

* Test Summary
* Passed Tests
* Failed Tests
* Skipped Tests
* Screenshots for Failures
* Execution Time

---

## Configuration

Update the configuration file:

```
src/main/resources/config.properties
```

Example:

```properties
baseUrl=https://automationpractice.techwithjatin.com/login
browser=chrome
implicitWait=10
explicitWait=20
```

---

## CI/CD Pipeline

The project supports automated execution through GitHub Actions or Jenkins.

### Pipeline Workflow

* Trigger on every push or pull request
* Checkout source code
* Set up Java environment
* Build project with Maven
* Execute Selenium tests
* Generate reports
* Archive test artifacts
* Publish test results

### Example GitHub Actions Workflow

```yaml
name: Selenium Tests

on:
  push:
    branches:
      - main

jobs:
  selenium-test:
    runs-on: ubuntu-latest

    steps:
      - uses: actions/checkout@v4

      - name: Set up Java
        uses: actions/setup-java@v4
        with:
          distribution: temurin
          java-version: '17'

      - name: Build Project
        run: mvn clean install

      - name: Execute Tests
        run: mvn test
```

---

## Sample Test Scenarios

* User Login
* User Registration
* Product Search
* Product Filtering
* Add Product to Cart
* Update Cart Quantity
* Remove Product from Cart
* Checkout Process
* Order Confirmation
* Logout

---

## Design Patterns Used

* Page Object Model (POM)
* Factory Design Pattern
* Singleton Pattern (Driver Management)
* Utility Classes
* Data-Driven Testing

---

## Best Practices

* Reusable page objects
* Explicit waits instead of Thread.sleep()
* Externalized test data
* Configurable environments
* Clean coding standards
* Meaningful logging
* Independent test cases
* Screenshot capture on failures

---

## Future Enhancements

* Docker execution
* Selenium Grid support
* Parallel execution
* BrowserStack/Sauce Labs integration
* API automation integration
* Allure Reporting
* Performance testing support


## Author

**Your Name**

For questions or suggestions, feel free to open an issue or submit a pull request.
