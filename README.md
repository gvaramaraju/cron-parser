# Cron Expression Parser

This project is a Java command-line application that parses a standard cron expression and prints the full expanded schedule for each field in a table format.

---

## Features

- Parses and expands standard 5-field cron expressions:
    - **minute** (0–59)
    - **hour** (0–23)
    - **day of month** (1–31)
    - **month** (1–12)
    - **day of week** (0–6, Sunday=0)
- Supports:
    - Wildcards (`*`)
    - Ranges (`1-5`)
    - Lists (`1,2,3,5-7`)
    - Steps (`*/15`)
- Command (6th part) is parsed and printed
- Graceful error handling and input validation
- Simple, readable tabular output
- Unit tests for common patterns and edge cases

---

## How to Build and Run

### Prerequisites

- Java 21 or higher installed
- Maven installed (`mvn -v` should work in terminal)

---

### Step 1: Build the Project

From the project root directory (where `pom.xml` is located), run:

```
mvn clean package
```

You will find the jar in the target

```
target/cron-parser-<version>.jar
```


### Step 2: Run the Application

```
java -jar target/cron-parser-<version>.jar "*/15 0 1,15 * 1-5 /usr/bin/find"
```

## Testing

### Test Suite

Run the Test Suite designed to test all cases we support

- Open the Source code in any editor
- Run the `ApplicationTest` class to test the application

