# Cribhub

[![License](https://img.shields.io/badge/license-MIT-blue.svg)](LICENSE)

## Description

This project is a system which focuses on shared accommodation management. The intent for this management system is to have a centralized platform, which is tailored towards addressing the needs of users living in communal living space. Living in a shared accommodation often comes with a set of challenges which can have varying effects on the living experience for the roommates. Our goal is to address these challenges by streamlining tasks and improving communication. 
A brief description of the project.

## Table of Contents

- [Installation](#installation)
- [Usage](#usage)
- [Building, running and testing locally](#building-running-and-testing-locally)
- [License](#license)

## Installation

To install and set up the project, you need to have Docker installed on your system. If you don't have Docker installed, you can follow the instructions below:

1. Visit the [Docker website](https://www.docker.com/get-started) and download the appropriate version of Docker for your operating system.
2. Follow the installation instructions provided by Docker to install it on your system.

Once Docker is installed, you can proceed with the following steps:

1. Clone the repository by running the following command in your terminal:
    ```
    git clone https://github.com/Cribhub/Cribhub
    ```

2. Navigate to the root folder of the project:
    ```
    cd cribhub
    ```

3. Run the following command to start the project using Docker Compose:
    ```
    docker-compose up
    ```

This will start the project and any necessary dependencies defined in the Docker Compose file.

## Usage

After starting the project, you can access it by visiting `localhost:3000` in your web browser.

## Building, running and testing locally

### Frontend

1. Navigate to the frontend folder located at: cribhub/frontend.
```
cd cribhub/frontend
```

2. Install all the necessary dependencies
```
npm install
```

To Build the project:
```
npm run build
```

To run the project:
```
npm run start
```

To test the project:
```
npm run test
```

### Backend

1. Navigate to the backend folder located at: cribhub/backend.
```
cd cribhub/backend
```

To Build the project:
```
./gradlew build
```

To run the project:
```
./gradlew bootRun
```

To test the project:
```
./gradlew test
```

## License

This project is licensed under the [MIT License](LICENSE).