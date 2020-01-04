## Micro-services demo1 : Eureka Server (Discovery Server)

1.  Create new Spring boot Starter project
    
    ```yaml
    Name:   discovery-server
    Type:   Maven
    Packaging:  Jar
    Java Version: 8
    Language:   Java

    Group:  com.mahendra
    Artifact:   discovery-server
    Version:    1.0
    Package:    com.mahendra.demo
    ```

3.  Add new Dependency (starter-pom)

    3.1 Eureka-Server

4.  Open `DiscoveryServerApplication.java` from `com.mahendra.demo` package. and add one annotation.

    ```java
    @SpringBootApplication
    @EnableEurekaServer
    public class DiscoveryServerApplication {

        public static void main(String[] args) {
            SpringApplication.run(DiscoveryServerApplication.class, args);
        }
    }
    ```

5.  Open `application.properties` file and add required settings:

    ```ini
    server.port=8761
    ### Options to be disabled (Enabled in CLIENT applications)
    eureka.client.fetch-registry=false
    eureka.client.register-with-eureka=false
    ## Disable the LOGGING of EUREKA (OPTIONAL)
    logging.level.com.netflix.eureka=OFF
    logging.level.com.netflix.discovery=OFF
    ```

6.  Now, Run your application as `Spring boot app` and then 
    connect your web-browser at http://localhost:8761

    