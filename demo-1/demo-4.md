## REST Method types

1.  Create new spring-boot-starter project

   ```yaml
    Name:   demo-4
    Type:   Maven
    Packaging:  Jar
    Java Version: 8
    Language:   Java

    Group:  com.mahendra
    Artifact:   demo-4
    Version:    1.0
    Package:    com.mahendra.demo
    ```

2.  Add TWO starter dependencies 

    2.1 Spring-WEB
    2.2 DevTools

3.  Create a new Controller class `com.mahendra.demo.controllers.EmployeeController`

    ```java
    @RestController
    //// URL http://localhost:8081/emps
    @RequestMapping("/emps")
    public class EmployeeController {

        
        // GET http://localhost:8081/emps
        @GetMapping
        public String doGet() {
            return "Processing GET type method!";
        }
        
        // PUT GET http://localhost:8081/emps
        @PutMapping
        public String doPut() {
            return "Processing PUT type method!";
        }
        
        
        // DELETE GET http://localhost:8081/emps
        @DeleteMapping
        public String doDelete() {
            return "Processing DELETE type method!";
        }
        
        // POST http://localhost:8081/emps
        @PostMapping
        public String doPost() {
            return "Processing POST type method!";
        }
    }
    ```
4.  Run application as `Spring Boot App` and Test using POSTMAN

    4.1 GET http://localhost:8081/emps
    4.2 POST http://localhost:8081/emps
    4.3 PUT http://localhost:8081/emps
    4.4 DELETE http://localhost:8081/emps
    4.5 OPTIONS http://localhost:8081/emps
    4.6 HEAD http://localhost:8081/emps
