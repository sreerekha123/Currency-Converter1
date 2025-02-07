# Currency Converter
# Overview

This is a Spring Boot application that provides real-time currency conversion using a public exchange rates API. The application fetches exchange rates and allows users to convert an amount from one currency to another.

## Features

- Fetch real-time exchange rates from an external API.
- Convert currency amounts using the latest exchange rates.
- RESTful API endpoints.
- Error handling for API failures and invalid input.



## Technology Used

- Java 17
- Spring Boot 3
- Spring Web
- Spring Boot Test (JUnit)
- Maven
- REST API integration

  ## API Endpoints

#### 1. Get exchange rate

```http
  GET /api/rates?base=USD
```
{

    "base":"USD,
    "rates": {
    "EUR": 0.945,
    "INR": 82.15,
    "GBP": 0.785
  }
}

#### 2.Convert Currency

```http
  POST /api/convert

```
#### Request Body:

{

    "from": "USD",
    "to": "EUR",
    "amount": 100
  }

#### Example Response:


{

    "from": "USD",
    "to": "EUR",
    "amount": 100,
    "convertedAmount": 94.5
}
  

# Error Handling
 - Returns a 400 error for invalid currency codes.
 - Returns a 500 error if the external API is unavailable.


# Running the Application

```http
`mvn clean install
mvn spring-boot:run
```

# Running Tests

```http
mvn test
```

# Future Enhancements

- Implement caching to reduce API calls.
- Support for more public exchange rate APIs.
- Deploy to a cloud platform.








