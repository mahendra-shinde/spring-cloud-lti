## REST Services : Content Negotiation

- Both Server and Client would have LIST OF RESPONSE/ACCEPT TYPES
- Client send "ACCEPT" header to service with value like:
    "application/json", "application/xml"

    Which literally translates to:

    I would accept data in either JSON or XML format.

- Server would use it's 'produces={"application/json","application/xml"}' annotation which clearly says:

    I would produce response in either JSON or XML.

- Client submit some data with CONTENT_TYPE "application/xml"
- Server would say 'consumes={"application/json","application/xml"}' which means:

    I would like request body in either JSON or XML format!

- When the content-type or response-type doesn't match, then server returns '406 Not Acceptable'

## Demo steps
1.  Use demo-1 project created yesterday.

2.  Modify `com.mahendra.demo.models.Product` and add one annotation on class-level.

    ```java
    @XmlRootElement
    public class Product{ ... }
    ```

3.  Modify `com.mahendra.demo.controllers.ProductController` and modify the annotation on find method.

    ```java
   	@GetMapping(value="/find/{id}",produces= {"application/json","application/xml"})
    ```

4.  Run application as Spring boot app and then TEST using Postman

5.  In Postman enter url "http://localhost:8081/products/find/101" 
6.  In headers, set "Accept" to "application/json"
7.  Then click "Send" button
8.  In Headers, set "Accept" to "application/xml" and click "send" button
9.  In Headers, set "Accept" to "application/pdf" and click "send" button
10. Now, You are expected to get ERROR 406 : Not Acceptable !