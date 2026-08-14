# TasteLoop 

TasteLoop is a **food ordering backend application** built using **Java and Spring Boot**.

I created this project to practice building REST APIs, working with Spring Boot, JPA relationships, authentication, and PostgreSQL.

## Features

* User registration and login
* JWT-based authentication
* Role-based access for users
* Restaurant management
* Add and manage food items
* Veg / Non-Veg food category
* Food stock management
* Cart management
* Add items to cart
* Increase / decrease cart quantity
* Place orders
* Payment processing
* User profile management
* Change password

## Project Modules

The project is divided into different modules based on functionality:

```text
com.jsp.tasteloop
│
├── user_module
├── restaurant_module
├── cart_module
├── order_module
├── payment_module
└── common_module
```

Each module mainly contains:

```text
Controller → Service → DAO → Model / DTO
```

## Technologies Used

* **Java**
* **Spring Boot**
* **Spring Data JPA / Hibernate**
* **Spring Security**
* **JWT**
* **PostgreSQL**
* **Lombok**
* **Maven**
* **Swagger / SpringDoc OpenAPI**

## Main APIs

### User

| Method | Endpoint                         | Description      |
| ------ | -------------------------------- | ---------------- |
| POST   | `/tasteloop/user/register`       | Register user    |
| POST   | `/tasteloop/user/login`          | Login            |
| GET    | `/tasteloop/user/profile`        | Get user profile |
| PUT    | `/tasteloop/user/changepassword` | Change password  |
| DELETE | `/tasteloop/user/delete`         | Delete user      |

### Restaurant

| Method | Endpoint                               | Description               |
| ------ | -------------------------------------- | ------------------------- |
| POST   | `/tasteloop/restaurant/create`         | Create restaurant         |
| GET    | `/tasteloop/restaurant/all`            | Get all restaurants       |
| GET    | `/tasteloop/restaurant/location`       | Search by location        |
| GET    | `/tasteloop/restaurant/name`           | Search by name            |
| GET    | `/tasteloop/restaurant/{restaurantId}` | Get restaurant by ID      |
| PUT    | `/tasteloop/restaurant/updateManager`  | Update restaurant manager |

### Food Item

| Method | Endpoint                                        | Description    |
| ------ | ----------------------------------------------- | -------------- |
| POST   | `/tasteloop/fooditem/add`                       | Add food item  |
| PUT    | `/tasteloop/fooditem/update-stock/{foodItemId}` | Update stock   |
| GET    | `/tasteloop/fooditem/food-items`                | Get food items |

### Cart

| Method | Endpoint                            | Description       |
| ------ | ----------------------------------- | ----------------- |
| POST   | `/tasteloop/cart/createcart`        | Create cart       |
| GET    | `/tasteloop/cart/user/{userId}`     | Get user's cart   |
| POST   | `/tasteloop/cart/add-item`          | Add item to cart  |
| POST   | `/tasteloop/cart/increase-quantity` | Increase quantity |
| POST   | `/tasteloop/cart/decrease-quantity` | Decrease quantity |

### Order

| Method | Endpoint                     | Description |
| ------ | ---------------------------- | ----------- |
| POST   | `/tasteloop/orders/{userId}` | Place order |

### Payment

| Method | Endpoint                      | Description     |
| ------ | ----------------------------- | --------------- |
| POST   | `/tasteloop/payments/process` | Process payment |

## Database

The project uses **PostgreSQL**.

Create the database:

```sql
CREATE DATABASE tasteloop_db;
```

Then update the database username and password in:

```text
src/main/resources/application.properties
```

## How to Run

### 1. Clone the repository

```bash
git clone https://github.com/AmanKumar269/TasteLoop.git
cd TasteLoop/tasteloop
```

### 2. Configure PostgreSQL

Create the `tasteloop_db` database and update your PostgreSQL credentials in `application.properties`.

### 3. Run the application

```bash
./mvnw spring-boot:run
```

The application will start on:

```text
http://localhost:8080
```

## Swagger

After starting the application, API documentation can be accessed through Swagger:

```text
http://localhost:8080/swagger-ui.html
```

Swagger can be used to test the available REST APIs.

## What I Learned

While working on TasteLoop, I practiced:

* Building REST APIs using Spring Boot
* Spring Security and JWT authentication
* JPA entity relationships
* PostgreSQL database integration
* CRUD operations
* Cart and order logic
* Exception handling
* Project structure using multiple modules
* API testing using Swagger

## Note

This project is mainly built for **learning and practice**. Some features can still be improved, such as order status management, restaurant reviews, and better error handling.
