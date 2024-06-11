# Rent car

This is a sample Spring Boot 3.2.4 project with Gradle and Java 17.

## Requirements

- Java 17
- Gradle

## Project Setup

1. Clone this repository:

   ```bash
   git clone https://github.com/Carlos-RomeroRo/PROG-WEB-FINAL.git
   ```

2. Navigate to the project directory:

   ```bash
   cd PROG-WEB-FINAL
   ```

3. Create environment file:
   - Look for `application.properties.template` in the resources directory and copy it to the `application.properties` file (create a new file if needed)
   - Edit the `application.properties` file to match your environment values


## Running the Project

To run the project, you can use Gradle from the command line:

```bash
./gradlew bootRun
```

This will start the Spring Boot application on the default port `8080`.

## Using the API

Once the application is up and running, you can access the API at:

```
http://localhost:8080/
```