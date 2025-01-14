# Automation

---

## Project Structure

src/test/java/amaysimTesting: Contains the Java source code for test automation.
src/test/java/Utility: provides a centralized setup and management utility for initializing WebDriver instances in Selenium-based test automation. It handles driver path settings, and configures global timeouts, ensuring a consistent and reusable WebDriver setup across tests.

## Execution

1. Clone Git project
```bash
git clone https://github.com/jkdelacruz/Automation.git
```
2. Run the script
```bash
mvn test -Dtest=<TestScript>
```
**Note:** You should be at the root directory to run this command.
Make sure to replace `<TestScript>` with the name of the automation script you want to run.

## Test Reports

- **Reports**: After test execution, Reports are generated and stored in the `allure-results` directory.
  To generate this report temporarily, run this code below.

```bash
allure serve ./allure-results
```
**Note:** You should be at the allure-results directory to run this command.

## Dependencies

Ensure you have the following dependencies installed:

- Java 22 or latest
- Maven
- NodeJs
- Chrome Web Driver

**Note:** Update Chrome webdriver path in test script.
```declarative
C:\*\chromedriver-win64\chromedriver.exe
```

---
