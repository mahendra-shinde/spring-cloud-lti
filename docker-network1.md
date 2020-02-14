## Docker Networking

1.  Create a new docker Network

    ```cmd
    ### STOP ALL CONTAINERS
    $ docker stop $(docker ps -q)
    ### REMOTE ALL CONTAINERS
    $ docker rm $(docker ps -aq)
    $ docker network create net1 -d bride --subnet 182.18.0.0/16
    $ docker run -it --name t1 --net net1 nginx:alpine sh
    $ hostname -i
    ##KEEP RUNNING
    ```

2.  Open another terminal

    ```cmd
    $ docker run -it --name t2 --net net1 nginx:alpine sh
    $ hostname -i
    $ ping t1
    CTRL +C 
    $ exit
    ```