# Spring Boot Tutorial

Sample Spring Boot project created from a LinkedIn Learning course.

## Build

### Start Spring Boot App via Maven
```bash
 mvn spring-boot:run
```

## Spring Boot Docker Image

Build
```bash
docker build -t spring-boot-tutorial .
```
Run
```bash
docker run -p 8080:8080 -d spring-boot-tutorial
```
Stop
```bash
docker stop CONTAINER_ID
```