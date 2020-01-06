## Docker Demo-1 : Linux Mode NGINX

1.  Run docker in "Linux Mode"
2.  Create a new NGINX container in DETACHED mode

    ```cmd
    $ docker run --name w1 -d -p 8080:80 nginx:alpine
    $ docker ps 
    ```

3.  Create a new HTML file `index.html` (filename is CaseSensitive)

    ```html
    <html>
    <body>
    <h1>Hello World from Mahendra</h1>
    </body>
    </html>
    ```

4.  Run following command to COPY this index.html inside NGINX container.

    ```cmd
    $ docker cp index.html w1:/usr/share/nginx/html/
    ```

5.  Test using Web Browser http://localhost:8080/

6.  Stop the container and convert into an image.

    ```cmd
    $ docker stop w1
    $ docker commit w1 mahendrshinde/mynginx:1
    ```

    > Replace 'mahendrshinde' with YOUR DOCKER_ID

7.  To check if IMAGE is BUILT, try following command:

    ```cmd
    $ docker images
    ```

8.  Login with your docker-id and push the IMAGE on docker-hub

    ```cmd
    $ docker login
    Username: mahendrshinde
    Password:        
    $ docker push mahendrshinde/mynginx:1
    ```

9.  Visit hub.docker.com to view your newly uploaded docker image
