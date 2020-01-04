### Microservices demo-4 Client for Config server

1.  Create New Spring starter project

       ```yaml
    Name:   book-service
    Type:   Maven
    Packaging:  Jar
    Java Version: 8
    Language:   Java

    Group:  com.mahendra
    Artifact:   book-service
    Version:    1.0
    Package:    com.mahendra.demo
    ```

2.  Add following starter-poms (dependencies)

    2.1  Config Client (from Spring Cloud Config)
    2.2  Eureka Client 
    2.3  Spring-WEB


3.  Open `application.properties` file and add following properties

    ```ini
    spring.application.name=book-service
    server.port=9090
    spring.cloud.config.uri=http://localhost:8888
    ```

4.  Rename the above file (application.properties) into `bootstrap.properties`

5.  Open & Edit `BookServiceApplication.java` 

    ```java
    @SpringBootApplication
    @EnableDiscoveryClient
    public class BookServiceApplication {

        public static void main(String[] args) {
            SpringApplication.run(BookServiceApplication.class, args);
        }
    }
    ```
6.  Create a new REST Controller `com.mahendra.demo.controllers.HelloController`

    ```java
    @RestController
    public class HelloController {

        // Value INJECTED from config-server    
        @Value("${spring.rabbitmq.username}")
        private String rabbitmqUser;
        
        @GetMapping("/")
        public String testConfig() {
            return "RabbitMQ User: "+rabbitmqUser;
        }
    }
    ```



