# Bootcamp2025.3_Team4

Automation testing project for the **Cards** feature on **tbcbank.ge**, created as part of the final automation project assignment.  
The project covers UI, API, and performance testing, along with reporting, CI/CD, and AI-assisted quality engineering.

## Project Scope

Team 4 was assigned the **Cards** feature.  
This project validates key user flows and content on the cards pages using automated checks across multiple layers.

## Tech Stack

- **Java 21**
- **Maven**
- **Playwright 1.55.0**
- **TestNG 7.11.0**
- **Rest Assured 5.4.0**
- **K6**
- **Allure Report**
- **GitHub Actions**

## Test Coverage

### UI Tests
- QR code validation for TBC Card application
- Q&A / FAQ section validation
- Contact form positive validation
- Contact form negative validation
- Contact form edge case validation

### API + UI Validation
- Cards page content comparison between API response and UI
- CTA title validation
- CTA button validation
- CTA list validation
- Cards grid validation
- Old cards validation
- Banner title validation

### Performance Tests
- **Load test:** 20 virtual users for 60 seconds
- **Stress test:** 100 virtual users for 60 seconds

Performance checks include:
- response time thresholds
- failed request rate
- successful check rate

## Cross-Browser Execution

The project supports:
- Chromium / Chrome
- Edge
- Mobile view coverage

## Reporting

The framework uses **Allure Report** for:
- test results
- logs
- screenshots
- execution history

## CI/CD

A **GitHub Actions** pipeline is configured to:

- run on push to `master`
- run on pull requests to `master`
- support manual trigger
- run weekly on schedule
- execute tests in CI mode
- upload Surefire reports
- upload Allure results
- generate Allure report
- deploy the Allure report to **GitHub Pages**

## AI-Assisted Quality Engineering

For the AI task, the team implemented:

- **AI code review**

The project includes the required AI deliverables:
- `prompt.txt`
- `result.txt`
- `analysis.md`

## Bug Reporting

Real bugs identified during testing were documented in **Jira**.

## Team Contributions

- **Tatia** — Reporting + CI/CD
- **Daniel** — Scenarios + Bug Reporting
- **Giorgi** — UI Tests (QR)
- **Mark** — UI Tests (Contact Form)
- **Ana** — API + Performance Testing
- **Teimurazi** — AI Task + Presentation

## How to Run

### Run automated tests
```bash
mvn clean test