### Microservices Demo-3 : Config Server

1.  Create new Spring boot Starter project
    
    ```yaml
    Name:   config-server
    Type:   Maven
    Packaging:  Jar
    Java Version: 8
    Language:   Java

    Group:  com.mahendra
    Artifact:   config-server
    Version:    1.0
    Package:    com.mahendra.demo
    ```

2.  Add following starter-poms (dependencies)

    2.1  Config Server (from Spring Cloud Config)

3.  Open `application.properties` file and add following properties:

    ```ini
    server.port=8888
    spring.cloud.config.server.git.uri=https://github.com/mahendra-shinde/config-repo.git
    ```

4.  Open the Only .java file `ConfigServerApplication.java`

    ```
    @SpringBootApplication
    @EnableConfigServer
    public class ConfigServerApplication {

        public static void main(String[] args) {
            SpringApplication.run(ConfigServerApplication.class, args);
        }

    }
    ```

4.  Run the application as `Spring boot app` and then try following URLS

    http://localhost:8888/fare-service/deafult

    http://localhost:8888/book-service/deafult