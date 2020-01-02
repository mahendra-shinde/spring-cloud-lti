## Spring boot dev-tools

The `devtools` bundle provide Live Dev Environment for application.
Once application is RUN, make changes to source code and save them.
Spring DevTools would simply re-launch itself to reflect those changes.

How to add devTools ?

1. Right click on project > spring > Add DevTools

2. The first option is provided by eclipse plugin. Incase no plugin is installed,
use following alternative.

    Add a new dependency in POM.XML file

    ```XML
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-devtools</artifactId>
    </dependency>
    ```

3.  Run the project again "Run As Spring Boot App"
4.  Create additional request handling method in "HelloController" and check the server console.

    ```java
    @GetMapping("/{name}")
	public String sayHello(@PathVariable("name") String name) {
		return "Hello "+name;
	}
    ```

5.  Test the method using web address http://localhost:8081/mahendra
