UI and API tests for the Kanboard application
-

___________________________
Deployment instruction:

- Java 17, Maven 3.9.2, Docker Desktop are installed
- Copy the docker-compose.yml file
- run the command $ docker-compose up on the folder with the file
- make sure that the container with the Kanboard app is running
- NOTE: token is unique for each localhost --> TBM in upcoming test refactoring
- Login: admin password: admin
- Navigate to get API token: Settings/API
- Change token value in env.properties

______________________________________
Run tests with the following commands:

- mvn clean test -Papi-regression - for running all API tests
- clean test -Progression -Dbrowser=chrome -Dheadless=false - for running all UI tests in Chrome
- mvn clean test -Progression -Dbrowser=chrome -Dheadless=true - for running all UI tests in Chrome headless mode
- mvn clean test -Progression -Dbrowser=firefox -Dheadless=false - for running all UI tests in Firefox

_____________________________________
Run the commands to get the Allure report
- allure generates target/allure-results
- allure serve target/allure-results

___________________________
Test suits by functionality:
- Plugin - for login UI checks
- Project - for project UI checks
- Ptask - for task UI checks
- Papi-regression - for all API tests
- mvn clean test -Ptask -Dbrowser=chrome -Dheadless=false
