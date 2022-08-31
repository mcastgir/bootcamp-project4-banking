# Project Banking
> Microservice **Banking** Bootcamp NTT Data

This project include:
- Spring Boot Webflux
- Spring Boot Data MongoDB Reactive
- Spring Cloud Config
- Spring Cloud Eureka Client
- Spring Cloud Bootstrap
- Spring Boot Actuator
- WebClient
- Spring Cloud Circuitbreaker Resilience4j
- Kafka Producer
- WebTestClient
- JUnit
- Mockito
- SonarQube
- Lombok
- Github Actions
- Docker

### Docker

1. Create Image Config Server in Docker
```  
docker build -t banking .
```

2. Create Container

```
docker run -p 8088:8088 --name banking-instance --link config-server-instance:latest -d banking:latest
```

### SonarQube

```
mvn clean verify sonar:sonar -Dsonar.projectKey=banking -Dsonar.host.url=http://localhost:9093 -Dsonar.login=sqp_4a461e3a5117194223cbfe1b28c9bc90e5d7594e
```