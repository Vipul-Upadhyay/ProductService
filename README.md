# Product Service
## Overview
Product Service is a Spring Boot application that provides a RESTful API for managing products. It integrates with a third-party fake store API to fetch product data and supports various operations such as creating, updating, deleting, and searching for products.  
## Features
- Fetch product details from a third-party API
- Create, update, and delete products
- Search products with pagination and sorting
- Token validation for secure access
- Caching with Redis
## Technologies Used
- Java
- Spring Boot
- Spring Cloud
- Spring Data JPA
- Redis
- Maven
## Getting Started
### Prerequisites
Java 11 or higher
Maven
Redis
### Installation
1. Clone the repository:
```sh
git clone https://github.com/your-username/product-service.git
cd product-service
```
2. Configure the application properties in src/main/resources/application.properties:
```sh
fakestore.api.url=https://fakestoreapi.com
fakestore.api.paths.products=/products
spring.redis.host=localhost
spring.redis.port=6379
```
3. Build the project:
```sh  
mvn clean install
```
4. Run the application:
```sh
mvn spring-boot:run
```
## Usage
### API Endpoints
- #### Get Product by ID
GET /products/{id}
- #### Get All Products
GET /products
- #### Create Product
POST /products
- #### Update Product by ID
PUT /products/{id}
- #### Delete Product by ID
DELETE /products/{id}
- #### Search Products
GET /products/search
### Example Requests
- #### Get Product by ID
```sh
curl -X GET "http://localhost:8080/products/1"
```
- #### Create Product
```sh
curl -X POST "http://localhost:8080/products" -H "Content-Type: application/json" -d '{"title": "New Product", "description": "Product description", "price": 100.0, "category": "Category", "image": "image_url"}'
```
## Contributing
Contributions are welcome! Please open an issue or submit a pull request for any changes.  
## License
This project is licensed under the MIT License. See the LICENSE file for details.
