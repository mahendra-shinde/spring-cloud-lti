## Spring Test

1.  Open `pom.xml` file and verify that `spring-test` is already included in dependencies.

    ```xml
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-test</artifactId>
        <scope>test</scope>
    </dependency>
    ```

2.  Open `src\test\java` and goto `Demo1ApplicationTest.java`
    Modify the code like this:

    ```java
    @RunWith(SpringRunner.class)
    @SpringBootTest
    public class Demo1ApplicationTests {

        @Autowired private HelloController hello;
        @Autowired private ProductController product;
        
        @Test
        public void contextLoads() {
            String result = hello.sayHello();
            assertEquals("Hello India!", result);
        }
        
        @Test
        public void testProductFind() {
            Product p = product.find(101);
            assertNotNull(p);
        }
    }
    ```

3.  Now, test application using

    3.1 Right click anywhere inside the test case class and choose `Run As` > `JUnit Test`

    3.2 Run command `mvnw.cmd test`

4.  You can collect test report from `targets\surefire-reports` directory.