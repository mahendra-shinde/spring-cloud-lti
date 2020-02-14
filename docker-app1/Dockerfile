### Download / PULL and Image
FROM openjdk:8-jdk

## Create a new container, add new directory app
## COMMIT to create a new image
WORKDIR /app

## Create another container from IMAGE created at line 6
## And copy file, use COMMIT 
COPY App1.java /app

## RUn command in new container and again COMMIT
RUN ["javac","App1.java"]

## Set the ENTRY POINT
CMD ["java","App1"]