# spring-boot-monitoring-sample
Sample of Spring Boot monitoring setup.

Trying to build a bunch of spring-boot applications and monitor them using different services.

For this we will use the following:
 - [spring-boot](https://start.spring.io/)
 - [docker](https://docs.docker.com/install/linux/docker-ce/ubuntu/) with [docker-compose](https://docs.docker.com/compose/install/)
 - [consul](https://www.consul.io/) - service registry and discovery

## The involved components/services:

### Consul - [http://localhost:8500/ui/dc1/services](http://localhost:8500/ui/dc1/services)
We will need to start this first so that our service have were to register and
discover each other.
```bash
$ docker-compose up --build dev-consul
```