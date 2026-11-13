# Frequency Spectrum Analyzer

## Project Description
A Java-based Frequency Spectrum Analyzer using Fast Fourier Transform (FFT) and Maven.

## Technologies Used
- Java 21
- Apache Maven
- FFT
- JUnit
- Git and GitHub

## Features
- Reads signal data from CSV files.
- Performs frequency spectrum analysis.
- Identifies frequency components.
- Displays frequency and magnitude.
- Supports automated testing using JUnit.

## Build and Run

```bash
mvn clean compile
mvn test
mvn exec:java
```

## Test Results
- Tests Run: 2
- Failures: 0
- Errors: 0
- Build Status: SUCCESS

## Author
Rajmohan77

## Repository
FrequencySpectrumAnalyzer
# Frequency Spectrum Analyzer

## Project Description

A Java-based Frequency Spectrum Analyzer that uses Fast Fourier Transform (FFT) to analyze signal data and identify its frequency components.

## Technologies Used

- Java 21
- Apache Maven
- JTransforms 3.2
- JUnit 5
- Git and GitHub
- GitHub Actions

## Features

- Reads signal data from CSV files.
- Performs FFT-based frequency spectrum analysis.
- Identifies dominant frequency components.
- Displays frequency and magnitude.
- Supports automated testing using JUnit 5.
- Generates an executable JAR using Maven Shade Plugin.
- Automates build and testing using GitHub Actions.

## Build the Project

```bash
mvn clean package
```

## Run the Application

```bash
java -jar target/FrequencySpectrumAnalyzer-1.0-SNAPSHOT.jar
```

## Run Automated Tests

```bash
mvn clean test
```

## Sample Output

- Dataset: datasets/signal1.csv
- Samples: 1024
- Sampling Rate: 1024 Hz
- Detected Frequency: 50 Hz
- Magnitude: 1.0000
- Detected Frequency: 120 Hz
- Magnitude: 0.5000

## Test Results

- Tests Run: 2
- Failures: 0
- Errors: 0
- Build Status: SUCCESS

## CI/CD Pipeline

GitHub Actions performs the following steps:

1. Checks out the source code.
2. Sets up JDK 21.
3. Builds and tests the Maven project.
4. Generates the executable JAR.
5. Uploads the JAR as a workflow artifact.

## Official Release

**Version:** v1.0.0

[Download Frequency Spectrum Analyzer](https://github.com/Rajmohan77/FrequencySpectrumAnalyzer/releases/tag/v1.0.0)

## Author

Rajmohan77

## GitHub Repository

https://github.com/Rajmohan77/FrequencySpectrumAnalyzer

