## Docker File demo1

1.  Create a new directory/folder with name `docker-app1` 
2.  Create a simple class inside directory  
    
    ```java
    public class App1{

        public static void main(String arg[]){
            System.out.println("Hello World");
        }
    }
    ```

3.  In same directory create another file `Dockerfile` (With NO EXTENSION)

    ```bash
    ### Download / PULL and Image
    FROM openjdk:8-jdk

    ## Create a new container, add new directory app
    ## COMMIT to create a new image
    WORKDIR /app

    ## Create another container from IMAGE created at line 6
    ## And copy file, use COMMIT 
    COPY App1.java /app

    ## Run command in new container and again COMMIT
    RUN ["javac","App1.java"]

    ## Set the ENTRY POINT
    CMD ["java","App1"]
    ```

4.  From terminal use following command:

    ```sh
    $ docker build -t myapp . 
    $ docker run myapp
    ```