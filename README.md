# Bootcamp2025.3_Team4

Automation testing project for the Cards feature on tbcbank.ge, created as part of the final automation project assignment.

This project demonstrates a full QA automation workflow including:
- Test design
- UI + API + Performance automation
- Database validation
- Reporting & CI/CD
- AI-assisted quality engineering

---

## Project Scope

Team 4 was assigned the Cards feature.

The project validates key user flows, UI components, backend data consistency, and supporting test data using automated testing across multiple layers.

---

## Tech Stack

- Java 21
- Maven
- Playwright 1.55.0
- TestNG 7.11.0
- Rest Assured 5.4.0
- K6
- H2 Database
- MyBatis
- Allure Report
- GitHub Actions

---

## Test Coverage

### UI Tests
- QR code validation for TBC Card application
- Q&A / FAQ section validation
- Contact form positive validation
- Contact form negative validation
- Contact form edge case validation

### API + UI Validation
- Cards page content comparison (API vs UI)

### Database Usage
- In-memory H2 database configuration for test data handling
- SQL script execution for test data initialization
- MyBatis mapper usage for database interaction
- Database-backed validation support for automated tests

### Performance Tests
- Load test: 20 virtual users / 60 seconds
- Stress test: 100 virtual users / 60 seconds

Performance checks include:
- response time thresholds
- failed request rate
- successful check rate

---

## Cross-Browser Execution

- Chromium / Chrome
- Edge
- Mobile view

---

## Setup

### Prerequisites
- Java 21
- Maven
- Node.js
- Git
- Allure CLI
- K6

### Clone repository
git clone https://github.com/tateisnoone/Bootcamp2025.3_Team4.git
cd Bootcamp2025.3_Team4

### Install dependencies
mvn clean install

### Install Playwright browsers
npx playwright install

---

## How to Run

### Run all tests
mvn clean test

### Run performance tests
k6 run src/test/resources/performance/load-test.js
k6 run src/test/resources/performance/stress-test.js

---

## Database Configuration

The project uses an in-memory H2 database for test data setup and validation.

Database configuration includes:
- Driver: org.h2.Driver
- URL: jdbc:h2:mem:testdb
- Mode: MSSQLServer compatibility
- User: sa

Database setup is initialized automatically during test execution using SQL scripts and MyBatis mapper configuration.

---

## Reporting

### Generate Allure report
allure serve target/allure-results

OR

allure generate target/allure-results --clean -o allure-report

Report includes:
- test results
- logs
- screenshots
- execution history

---

## CI/CD

GitHub Actions pipeline:
- runs on push to master
- runs on pull requests
- manual trigger supported
- weekly scheduled runs
- uploads reports
- generates Allure report
- deploys to GitHub Pages

---

## AI-Assisted Quality Engineering

Implemented:
- AI code review

Deliverables:
- prompt.txt
- result.txt
- analysis.md

---

## Team Contributions

- **Tatia** — Reporting + CI/CD, Project Set Up
- **Daniel** — Scenarios + Bug Reporting
- **Giorgi** — UI Tests (QR, Q&A)
- **Mark** — UI Tests (Contact Form)
- **Ana** — API + Performance Testing
- **Teimurazi** — AI Task + Presentation


