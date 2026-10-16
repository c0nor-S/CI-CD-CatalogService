Catalog Service

Spring Boot Catalog Service for CICD-1 Lab 1.

-  Port: 8081
-  Swagger: http://localhost:8081/swagger-ui/index.html
-  Database: H2 (catalogdb)
-  Products And Categories Use A JPA ManyToOne Relationship.

## Endpoints

- GET /products
  * Get All Products.
- GET /products/{id}
  * Get Product By ID.
- GET /products/min-price?price=''
  * Get Products Above A Minimum Price Using  JPQL.
- GET /products/by-category?name=''
  * Get Products By Category Using JPQL.
- POST /products
  * Create A Product With An Existing Category ID.

## POST Example

{
    "name": "Keyboard",
    "price": 79.99,
    "categoryId": 2
}

Related Repository

Order Service: [<ORDER-REPOSITORY-LINK>](https://github.com/c0nor-S/CI-CD-Order-Service)
