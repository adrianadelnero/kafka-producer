# kafka-producer
# Read Me First

* Kafdrop is a UI for monitoring Apache Kafka clusters
* ZooKeeper is a centralized service for maintaining configuration information, naming, providing distributed synchronization, and providing group services.
* Kafka is open-source software that provides a framework for storing, reading, and analyzing a stream of data. Kafka provides three main functions.
  - Publish and subscribe to streams of records, similar to a message queue or enterprise messaging system.
  - Effectively store streams of records in the order in which records were generated.
  - Process streams of records in real-time.


# Getting Started

Run in the terminal:

Start docker images:
```
docker-compose up
```

Build application:
```
mvn clean install
```

Run application:
```
mvn spring-boot:run
```

You can access Kafdrop, in http://localhost:9000.

Testing:

```powershell
curl --location --request POST 'localhost:8080/order/pizza' \
--header 'Content-Type: application/json' \
--data-raw '{
"item": "Pizza de presunto",
"amount": 1,
"crust": "THIN_CRUST",
"toppings": ["CHEESE", "HAM"]
}'
```

The message are available in topic:
http://localhost:9000/topic/topic.pizza.order/messages?partition=0&offset=0&count=100&keyFormat=DEFAULT&format=DEFAULT


### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.7.7/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.7.7/maven-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.7.7/reference/htmlsingle/#web)
* [Spring Boot Actuator](https://docs.spring.io/spring-boot/docs/2.7.7/reference/htmlsingle/#actuator)
* [Spring for Apache Kafka](https://docs.spring.io/spring-boot/docs/2.7.7/reference/htmlsingle/#messaging.kafka)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/2.7.7/reference/htmlsingle/#data.sql.jpa-and-spring-data)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)
* [Building a RESTful Web Service with Spring Boot Actuator](https://spring.io/guides/gs/actuator-service/)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)

