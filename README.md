
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

```
  GET /v1/api/comment/get 
```
```
  GET /v1/api/comment/get/{id} 
```
```
  POST /v1/api/comment/save 
```
```
  PUT /v1/api/comment/update/{id}
```
```
  DELETE /v1/api/comment/delete/{id}
```

#### Post API

```
  GET /v1/api/posts/get 
```
```
  GET /v1/api/posts/get/{id} 
```
```
  POST /v1/api/posts/save 
```
```
  PUT /v1/api/posts/update/{id}
```
```
  DELETE /v1/api/posts/delete/{id}
```

#### User API

```
  GET /v1/api/users/get 
```
```
  GET /v1/api/users/get/{id} 
```
```
  POST /v1/api/users/save 
```
```
  PUT /v1/api/users/update/{id}
```
```
  DELETE /v1/api/users/delete/{id}
```
## Run&Build

- supported port: 8080
- mvn clean install
- mvn spring-boot:run
