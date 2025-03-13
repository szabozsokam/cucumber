CUCUMBER PROJECT
------------------------------

<p>This small test automation project is written in java-selenium, cucumber and JUnit 5, 
and aims to test the user authentication process of a publicly available web app.
The project is made for demo purposes.</p>

Installation:
- clone the repository from GitHub and open as a Java Maven project
- run mvn clean install
- mark src/test folder as sources 
- mark src/test/resources folder as test resources

Project structure:
- gherkin test scenario: src/test/resources/features/
- step definitions: src/test/stepdefs
- test runner class: src/test/utils
- page objects: src/test/pages
  - abbreviations for web elements:
       - IF: input field
       - CB: checkbox
       - RB: radio button


Running tests
- run this command by adding the selected browser type to the driver property: 
> mvn test -Dbrowser=chrome
- 

Test reports

