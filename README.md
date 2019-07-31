# spring-boot-monitoring-sample
Sample of Spring Boot monitoring setup.

Trying to build a bunch of spring-boot applications and monitor them using 
different services.

For this we will use the following:
 - [spring-boot](https://start.spring.io/)
 - [spring-boot-admin](https://github.com/codecentric/spring-boot-admin)
 - [docker](https://docs.docker.com/install/linux/docker-ce/ubuntu/) with 
 [docker-compose](https://docs.docker.com/compose/install/)
 - [consul](https://www.consul.io/) - service registry and discovery
 - **java 11** (openjdk-11-jdk)

##TODO:
 - config server
 - spring boot admin -  enable metrics for our services and other actuator endpoints.
 - api gateway
 - all spring boot apps to be startable as docker
 - add security on the api gateway
 - add log aggregation and collection with es and kibana and json logs for our apps

## The involved components/services:

### Consul - [http://localhost:8500/ui/dc1/services](http://localhost:8500/ui/dc1/services)
We will need to start this first so that our service have were to register and
discover each other.
```bash
$ docker-compose up --build mon-consul
```

### Postgres
Before we start our applications we need to connect to the postgres server and 
create our databases:
```bash
$ docker exec -it mon-postgres psql -h localhost -U postgres
$ create database simple_service;
```
To start the postgres service:
```bash
$ docker-compose up --build mon-postgres
```
### Simple service - [http://localhost:8989/swagger-ui.html](http://localhost:8989/swagger-ui.html)
This is a simple service with a database that offers some endpoints to fetch some
dummy data and a swagger-ui documentation. Also uses database migration scripts.
```bash
$ cd simple-service/
$ mvn package -DskipTests
$ cd ..
$ docker-compose up --build mon-simple-service
```
### Boot Admin - [http://localhost:8990/#/applications](http://localhost:8990/#/applications)
This is our spring-boot-admin service. It discovers and monitors our services that
have registered in [consul](http://localhost:8500/ui/dc1/services).
```bash
$ cd boot-admin/
$ mvn package -DskipTests
$ cd ..
$ docker-compose up --build mon-boot-admin
```