TasteLoop

TasteLoop is a food ordering backend built with Spring Boot. It's basically a mini version of how apps like Zomato/Swiggy work under the hood — restaurants can list their food items, customers can add items to a cart, place an order, and make a payment for it.

I built this to get hands-on with a proper multi-module Spring Boot project (instead of a single flat package) and to practice JWT-based auth, JPA relationships, and REST API design.

What it does
User registration/login with role-based access (Customer, Admin, Hotel Owner)
Restaurants can be created and managed by an owner/manager
Food items can be added to a restaurant, with stock tracking and veg/non-veg category
Cart system — add items, increase/decrease quantity, view cart by user
Order placement from cart items
Payment processing linked to an order (supports multiple payment methods)
Modules

The project is split into feature-based modules instead of one giant package:

com.jsp.tasteloop
├── user_module        # registration, login, profile, JWT auth
├── restaurant_module   # restaurant + food item management
├── cart_module         # cart and cart items
├── order_module        # order placement and order items
├── payment_module      # payment processing
└── common_module       # security config, exception handling

Each module follows the same pattern internally: controller -> service -> dao -> model/dto.

Tech Stack
Java + Spring Boot 4
Spring Data JPA (Hibernate)
Spring Security + JWT
PostgreSQL
Lombok
SpringDoc OpenAPI (Swagger UI)
Maven
API Overview
User (/tasteloop/user)
Method	Endpoint	Description
POST	/register	Register a new user
POST	/login	Login and get JWT token
GET	/profile?id=	Get user profile
PUT	/changepassword	Change password
DELETE	/delete?id=	Delete a user
Restaurant (/tasteloop/restaurant)
Method	Endpoint	Description
POST	/create	Create a restaurant
GET	/all	Get all restaurants
GET	/location	Search restaurants by location
GET	/name	Search restaurants by name
GET	/{restaurantId}	Get restaurant by id
PUT	/updateManager	Update restaurant manager
Food Item (/tasteloop/fooditem)
Method	Endpoint	Description
POST	/add	Add a food item to a restaurant
PUT	/update-stock/{foodItemId}	Update stock for an item
GET	/food-items	List food items
Cart (/tasteloop/cart)
Method	Endpoint	Description
POST	/createcart	Create a cart for a user
GET	/user/{userId}	Get a user's cart
POST	/add-item	Add item to cart
POST	/increase-quantity	Increase item quantity
POST	/decrease-quantity	Decrease item quantity
Order (/tasteloop/orders)
Method	Endpoint	Description
POST	/{userId}	Place an order from the user's cart
Payment (/tasteloop/payments)
Method	Endpoint	Description
POST	/process	Process payment for an order

Full request/response schemas are available via Swagger once the app is running.

Running it locally

1. Clone the repo

bash
git clone https://github.com/AmanKumar269/TasteLoop.git
cd TasteLoop/tasteloop

2. Set up PostgreSQL

Create a database named tasteloop_db:

sql
CREATE DATABASE tasteloop_db;

Update credentials in src/main/resources/application.properties if your Postgres username/password isn't postgres / root.

3. Run the app

bash
./mvnw spring-boot:run

The app starts on http://localhost:8080.

4. Check the APIs

Swagger UI: http://localhost:8080/swagger-ui.html

Notes
JWT secret and expiry are configured in application.properties — change the secret before deploying anywhere real.
spring.jpa.hibernate.ddl-auto=update is used for now, so tables get auto-created/updated on startup. Fine for dev, not something I'd use in production.
This is still a work in progress — things like order status updates, restaurant reviews, and better error responses are on my to-do list.
License

Open for learning/personal use.
