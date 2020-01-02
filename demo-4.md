## Spring boot actuator 

Provides LIVE information about running application.

1. Add boot starter "actuator"
2. Add a property in `application.properties` file

    ```ini
    ### Which actuator feature should be available on HTTP protocol
    management.endpoints.web.exposure.include=mappings
    management.server.port=8088
    ### Now it can be accessed http://localhost:8088/actuator/mappings
    ```

3.  Run application and test URL http://localhost:8088/actuator/mappings

4.  Notice additional URL mappings defined by spring-boot.