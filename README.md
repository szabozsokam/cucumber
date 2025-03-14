CUCUMBER PROJECT
------------------------------

<p>This small test automation project is written in java-selenium, cucumber and JUnit 5, 
and aims to test the user authentication process of a publicly available web app.
The project is made for demo purposes.</p>


Installation:
- clone the repository from GitHub and open as a Java Maven project
- run mvn clean install
- mark src/main/java folder as source
- mark src/test/java folder as test source
- mark src/test/resources folder as test resources
- use Cucumber and Gherkin plugins in your IDE


Project structure:
- gherkin test scenario: src/test/resources/features/
- step definitions: src/test/java/stepdefs
- page objects: src/main/java/pages
  - abbreviations for web elements:
       - IF: input field
       - CB: checkbox
       - RB: radio button
- test runner classes: src/test/java/utils


Running tests
- run this command by adding the selected browser type to the driver property: 
> mvn test -Dbrowser=chrome
- if you would like to run only a part of the tests, you can mark the desired tests with a tag, and specify the tag name in CucumberOptions of the TestRunner class


Test reports
- html report can be opened from target/reports/html-report/

