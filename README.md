# Electric Appliance Expense Tracker

A full-stack web application built using Java, Spring Boot, MySQL, HTML, CSS, and JavaScript to calculate electricity consumption and appliance expenses.

## Features

- Add appliance details
- Calculate electricity units consumed
- Calculate total electricity cost automatically
- View all appliances
- Get appliance by ID
- Delete appliances
- View total electricity bill
- MySQL database integration

## Tech Stack

- Java 17
- Spring Boot
- Spring Data JPA
- MySQL
- HTML
- CSS
- JavaScript
- Maven
- Git & GitHub

## Project Structure

```text
src
 └── main
      ├── java
      │    └── com.dhanush.electric_bill_tracker
      │         ├── controller
      │         ├── entity
      │         ├── repository
      │         ├── service
      │         └── service.impl
      │
      └── resources
           ├── static
           │    ├── index.html
           │    ├── style.css
           │    └── script.js
           │
           └── application.properties
```

## API Endpoints

### Add Appliance

```http
POST /api/appliances
```

### Get All Appliances

```http
GET /api/appliances
```

### Get Appliance By ID

```http
GET /api/appliances/{id}
```

### Delete Appliance

```http
DELETE /api/appliances/{id}
```

### Get Total Bill

```http
GET /api/appliances/total
```

## Bill Calculation Formula

```text
Units Consumed =
(Watts × Running Hours × Days Used) / 1000

Total Cost =
Units Consumed × Cost Per Unit
```

## Example

Appliance: Fan

```text
Watts = 75
Running Hours = 10
Days Used = 30
Cost Per Unit = ₹8
```

Calculation:

```text
Units Consumed = 22.5

Total Cost = ₹180
```

## Author

Dhanush Raj

GitHub:
https://github.com/Dhanush190503