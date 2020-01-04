### Micro services demo-2 : Service as Discovery Client

1.  Create new Spring Starter project 

    ```yaml
    Name:   find-city-server
    Type:   Maven
    Packaging:  Jar
    Java Version: 8
    Language:   Java

    Group:  com.mahendra
    Artifact:   find-city-server
    Version:    1.0
    Package:    com.mahendra.demo
    ```

2.  Add following starter-poms (dependencies)

    2.1     Spring-Web
    
    2.2     Eureka-Discovery-Client    

3.  Add following properties inside `application.properties` file

    ```ini
    server.port=8081
    ## Allow to fetch information about ALL services registerd on eureka
    eureka.client.fetch-registry=true
    ## register current application on eureka server
    eureka.client.register-with-eureka=true
    ## Server URL for eureka server
    eureka.client.service-url.default = http://localhost:8761/eureka

    ## Set the UNIQUE name for current service
    spring.application.name=find-city
    ```

4.  Open the Only java file `FindCityServerApplication.java` and add annotation.

    ```java
    @SpringBootApplication
    @EnableDiscoveryClient
    public class FindCityServiceApplication {

        public static void main(String[] args) {
            SpringApplication.run(FindCityServiceApplication.class, args);
        }

    }
    ```

5.  First Launch eureka-server from [ms-demo-1](./ms-demo-1.md)

6.  Launch the find-city application.

7.  Visit `http://localhost:8761/eureka`

8.  To launch additional instance open Terminal for find-city project

    ```cmd
    $ cd target
    $ java -jar find-city-service-1.0.jar --server.port=9000
    ```