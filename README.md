
# SpringBoot Blog API


## Tech Stack

- Java 11
- Spring Boot
- Spring Web 
- Spring Data Jpa
- H2
- Lombok 
- MapStruct
## APIs

#### Comment API

```http
  GET /v1/api/comment/get 
```
```http
  GET /v1/api/comment/get/{id} 
```
```http
  POST /v1/api/comment/save 
```
```http
  PUT /v1/api/comment/update/{id}
```
```http
  DELETE /v1/api/comment/delete/{id}
```

#### Post API

```http
  GET /v1/api/posts/get 
```
```http
  GET /v1/api/posts/get/{id} 
```
```http
  POST /v1/api/posts/save 
```
```http
  PUT /v1/api/posts/update/{id}
```
```http
  DELETE /v1/api/posts/delete/{id}
```

#### User API

```http
  GET /v1/api/users/get 
```
```http
  GET /v1/api/users/get/{id} 
```
```http
  POST /v1/api/users/save 
```
```http
  PUT /v1/api/users/update/{id}
```
```http
  DELETE /v1/api/users/delete/{id}
```
## Run&Build

- supported port: 8080
- mvn clean install
- mvn spring-boot:run