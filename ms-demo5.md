## Microservices demo-5 : Ribbon Load Balancer

1.  Run discovery-server from demo-1
2.  Run config-server from demo-3

3.  Open the existing project [book-service](./ms-demo4.md).

4.  Modify the `HelloController`

    ```java
    @RestController
    public class HelloController {

        @Value("${spring.rabbitmq.username}")
        private String rabbitmqUser;
        
        @GetMapping("/")
        public String testConfig() {
            System.out.println("Processing the request");
            return "RabbitMQ User: "+rabbitmqUser;
        }
    }
    ```

5.  Open the command-prompt or terminal in project directory

    HINT: Right click on project > Show In > terminal

    ```cmd
    $ mvnw.cmd package
    $ cd target
    $ java -jar book-service-1.0.jar --server.port=9091
    ```

6.  Create one more terminal using above step and run commands:

    ```
    $ cd target
    $ java -jar book-service-1.0.jar --server.port=9092
    ```

7.  Create a new Client application

    Create new Spring boot Starter project
    
    ```yaml
    Name:   web-client-demo
    Type:   Maven
    Packaging:  Jar
    Java Version: 8
    Language:   Java

    Group:  com.mahendra
    Artifact:   web-client-demo
    Version:    1.0
    Package:    com.mahendra.demo
    ```

2.  Add following starter-poms (dependencies)

    2.1  Eureka Client
    2.2  Spring-WEB
    2.3  Ribbon 

3.  Open `application.properties` file of new project and add following properties

    ```ini
    server.port=9080
    eureka.client.service-url.default = http://localhost:8761/eureka

    eureka.client.register-with-eureka=false
    eureka.client.fetch-registry=true
    ribbon.eureka.enabled=true
    ```

4.  Modify `WebClientDemoApplication.java` 

    ```java
    @SpringBootApplication
    @EnableEurekaClient

    @RibbonClient(name = "book-service")
    public class WebClientDemoApplication {

        public static void main(String[] args) {
            SpringApplication.run(WebClientDemoApplication.class, args);
        }

        @Bean
        @LoadBalanced
        public RestTemplate template() {
            return new RestTemplate();
        }   
    }
    ```

5.  Create a new home controller `com.mahendra.demo.controllers.HomeController`

    ```java
    @RestController
    @RequestMapping("/test")
    public class HomeController {

        @Autowired RestTemplate template;
        
        @GetMapping
        public String testIt() {
            System.out.println("Making a request to REST Service");
            String result = template.getForObject("http://book-service/", String.class);
            return result;
        }
    }

    ```

6.  Run the application as Spring boot app
7.  Test the URL:
    http://localhost:9080/test

8.  To check which instance has processed the request,
    check both terminals in eclipse