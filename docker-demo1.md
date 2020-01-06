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
    Username: [YOURDOCKER-ID-WITHOUT-BRACKETS]
    Password:        
    $ docker push [YOURDOCKER-ID-WITHOUT-BRACKETS]/mynginx:1
    ```

9.  Visit hub.docker.com to view your newly uploaded docker image

10. Stop all RUNNING containers at ONCE (Only in POWERSHELL prompt)

    ```pwsh
    $ docker stop $(docker ps -q)
    ```

11. Now, download an image and run as container

    ```pwsh
    $ docker run --name w2 -d -p 8080:80 mahendrshinde/mynginx:1
    ```

    NOTE: Use the exact same command to run MY docker image on your system

12. Check Web Browser at address http://localhost:8080/

13. Stop and delete all containers now

    ```pwsh
    $ docker stop $(docker ps -q)
    $ docker rm $(docker ps -aq)
    ```
    NOTE: if you get an error stating AT LEAST ONE ARGUMENT REQUIRED, dont panick, it means STOP and RM failed as there were no containers to stop/delete!