## Messaging in Spring Boot

1. Launch RabbitMQ Message Brocker 

    ```sh
    $  docker run --name rb1 -d -p 5672:5672 -p 15672:15672 rabbitmq:management
    ```

2.  Visit Web Browser: localhost:15672

    Login with guest/guest

3.  File > project > Import Spring Getting started content > RabbitMQ 
    Choose COMPLETE
    Click FINISH

4.  Run project as new Spring boot application

    