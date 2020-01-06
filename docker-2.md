## Docker Commands:

1. docker version
2. docker info
3. docker system df
4. docker run --name web1 -d -p 8080:80 nginx:alpine
5. docker run -it --name web2 nginx:alpine
6. docker ps 
7. docker ps -a
8. docker stop web1
9. docker rm web1


Windows Container demo:

Right click on Docker icon in system tray and choose option 
    "Switch to Windows Containers"
    NOTE: If the option is "Switch to Linux Container"
          That means your are already in Windows container mode.

Pull an image:
$ docker pull mcr.microsoft.com/windows/nanoserver:1903

$ docker run -it mcr.microsoft.com/windows/nanoserver:1903 CMD
$ dir
$ echo Hello > file1.txt
$ type file1.txt
$ exit
### List all STOPPED/RUNNING containers
$ docker ps -a 
$ docker stop CONTAINER_ID
## Replace CONTAINER_ID with ID of your container.
$ docker rm CONTAINER_ID
