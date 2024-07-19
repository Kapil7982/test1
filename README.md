# Loqo Application

This is a simple Spring Boot application for managing products. The application provides an API to fetch products with various filtering and sorting options.

## Table of Contents

- [Getting Started](#getting-started)
- [Running the Application](#running-the-application)
- [API Endpoints](#api-endpoints)
- [Testing](#testing)
- [Technologies Used](#technologies-used)
- [Project Structure](#project-structure)

## Getting Started

### Prerequisites

- Java 8 or higher
- Maven
- MySQL

### Installation

1. Clone the repository:

    ```bash
    git clone https://github.com/Kapil7982/test1.git
    cd Loqo
    ```

2. Build the project:

    ```bash
    mvn clean install
    ```

## Running the Application

1. Run the application:

    ```bash
    mvn spring-boot:run
    ```

2. The application will start on port 8888. You can access the API at `http://localhost:8888/products`.

## Sample Data 
Sample data for testing the endpoints(Inserted in MySQL Database).
```bash
create database Loqo;
use Loqo;
INSERT INTO product (name, category, price, in_stock, rating, created_at) VALUES
    -> ('Smartphone', 'electronics', 299.99, true, 4.5, '2023-01-15 12:00:00'),
    -> ('Laptop', 'electronics', 899.99, true, 4.7, '2023-03-20 08:30:00'),
    -> ('Tablet', 'electronics', 199.99, false, 4.2, '2023-04-10 10:45:00'),
    -> ('Headphones', 'accessories', 49.99, true, 4.1, '2023-02-25 15:15:00'),
    -> ('Smartwatch', 'electronics', 149.99, true, 4.3, '2023-05-05 09:20:00');
```
## API Endpoints

### Get Products

Retrieve a list of products with optional filtering and sorting.

- **URL:** `/products`
- **Method:** `GET`
- **Query Parameters:**
  - `category` (optional): Filter by product category.
  - `minPrice` (optional): Minimum price of the products.
  - `maxPrice` (optional): Maximum price of the products.
  - `inStock` (optional): Filter by stock availability (true/false).
  - `sortField` (optional, default: `createdAt`): Field to sort by.
  - `sortOrder` (optional, default: `asc`): Sort order (`asc`/`desc`).

- **Response:**
  - Status: `200 OK`
  - Body: JSON array of products.

**Example Request:**

```bash
http://localhost:8888/products?category=electronics&minPrice=100&maxPrice=1000&inStock=true&sortField=price&sortOrder=asc
```
**Example Response:**

```bash
[
    {
        "id": 5,
        "name": "Smartwatch",
        "category": "electronics",
        "price": 149.99,
        "inStock": true,
        "rating": 4.3,
        "createdAt": "2023-05-05T03:50:00.000+00:00"
    },
    {
        "id": 1,
        "name": "Smartphone",
        "category": "electronics",
        "price": 299.99,
        "inStock": true,
        "rating": 4.5,
        "createdAt": "2023-01-15T06:30:00.000+00:00"
    },
    {
        "id": 2,
        "name": "Laptop",
        "category": "electronics",
        "price": 899.99,
        "inStock": true,
        "rating": 4.7,
        "createdAt": "2023-03-20T03:00:00.000+00:00"
    }
]
```
## Testing

The application includes unit and integration tests to ensure the functionality of the service and controller layers.

### Test Coverage
- ProductServiceTest: Unit tests for the ProductService class.
- ProductControllerTest: Integration tests for the ProductController class.

### Technologies Used
- Java
- Spring Boot
- Spring Data JPA
- Hibernate
- Lombok
- H2 Database (for testing)
- JUnit 5
- Mockito

## Project Structure
```bash
src/
├── main/
│   ├── java/com/loqo/
│   │   ├── controllers/
│   │   │   └── ProductController.java
│   │   ├── models/
│   │   │   └── Product.java
│   │   ├── repositories/
│   │   │   └── ProductRepository.java
│   │   ├── services/
│   │   │   ├── ProductService.java
│   │   │   └── ProductSpecification.java
│   │   └── LoqoApplication.java
│   └── resources/
│       ├── application.properties
│       └── data.sql
└── test/
    └── java/com/loqo/
        ├── controllers/
        │   └── ProductControllerTest.java
        └── services/
            └── ProductServiceTest.java
```
