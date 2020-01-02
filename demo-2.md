### Demo 2 : Spring MVC with thymeleaf templates

1. Create a new Spring boot starter project

    File > New > Others > Search for `Spring Starter Project`

2.  Enter following details:

    ```yaml
    Name:   demo-2
    Type:   Maven
    Packaging:  Jar
    Java Version: 8
    Language:   Java

    Group:  com.mahendra
    Artifact:   demo-2
    Version:    1.0
    Package:    com.mahendra.demo
    ```

3.  Add new Dependency (starter-pom)

    3.1 spring-web
    3.2 thymeleaf

4.  Create a new controller class `com.mahendra.demo.controllers.HelloController`

    ```java
    @Controller
    @RequestMapping("/")
    public class HelloController {

        @GetMapping
        public String sayHello(Model map) {
            map.addAttribute("user", "mahendra");
            List<String> months
                = Arrays.asList(new String[]{"Jan","Feb","Mar","Apr",
                    "May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"});
            map.addAttribute("months",months);
            return "hello";
        }
    }
    ```

5.  Create a new HTML page inside `src\main\resources` with name `hello.html`

    ```html
    <!DOCTYPE html>
    <html xmlns:th="http://www.thymeleaf.org">

    <head>
    <meta charset="ISO-8859-1">
    <title>Hello MVC World!</title>
    </head>
    <body>
    <h2>Hello <span th:text="${user}"></span></h2>
    Choose month : <select name="month" th:field="*{months}">
        <option th:each="month: ${months}" 
            th:value="${month}"
            th:text="${month}"
        />
    </select>
    </body>
    </html>
    ```
6.  Change the server port using `application.properties` file

    ```yml
    server.port=8081
    ```

7.  Run application as `Spring Boot App`

8.  Test your application using web browser 
    http://localhost:8081
