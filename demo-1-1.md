## First Spring boot application

1.  File > New > Others > Search for `Spring Starter Project`

2.  Enter following details:

    ```yaml
    Name:   demo-1
    Type:   Maven
    Packaging:  Jar
    Java Version: 8
    Language:   Java

    Group:  com.mahendra
    Artifact:   demo-1
    Version:    1.0
    Package:    com.mahendra.demo
    ```

    Click Next to continue 

3.  Choose Spring Boot version `2.1.11` and then choose dependency `Spring Web`
4.  Click "Finish" button and wait for project to be created and ready!
5.  Locate the MAIN method/class it should be in package `com.mahendra.demo`
6.  Create a new package `com.mahendra.demo.controllers` and a new class `com.mahendra.demo.controllers.HelloController`

    ```java
    @RestController
    public class HelloController {

        @GetMapping("/")
        public String sayHello() {
            return "Hello World";
        }
    }
    ```

7.  The project could be run / executed using TWO approaches:

    7.1 Using eclipse

        Right click on project name -> Run As -> Spring boot application

    7.2 Using Command Prompt / terminal

        Right click on project name -> Show In -> Terminal

        In Terminal, type:
        
        ```cmd
        ## Set Java home to JDK directory (please replace jdk1.8.0_65 with your JDK directory name)
        $ set JAVA_HOME=C:\Program Files\Java\jdk1.8.0_65
        ## Use built-in Maven Wrapper (mvnw.cmd) to launch project
        $ mvnw.cmd spring-boot:run
        ```

> NOTE: Additional mvnw commands:

    ```yml
    mvnw.cmd package : Clean->Compile->Test->Package JAR/WAR
    mvnw.cmd clean	:  Clean previously created JAR/WAR & Classes
    mvnw.cmd compile : Compile all JAVA files into .class
    mvnw.cmd test :	   Run all Test cases

    ### Run the Spring boot application
    mvnw.cmd spring-boot:run
    ### To Stop , press CTRL+C
    ```

> NOTE : Spring boot project structure

    ```yaml
    src:        Source code for entire project
    target:     Binaries (.class, .jar, .war) Build artifacts
    
    src\main\java:      The Main source code files (JAVA files)
    src\main\resources: The Non-Java files (eg, application.properties)

    src\main\resources\application.properties:  The only place where DEFAULT configuration could be OVERRIDDEN!

    src\test\java:      All the Unit/Integration test cases
    src\test\resources: All the resources required by test cases

    pom.xml:            The maven `Project Object Model` file. All dependencies are defined here!

    mvnw:               Maven wrapper for Unix/Linux OS
    mvnw.cmd:           Maven wrapper for Windows OS
    ```