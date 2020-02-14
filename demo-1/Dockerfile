FROM openjdk:8-jdk
WORKDIR /app
COPY target/demo-1-1.0.jar /app
ENV server.port=9000
CMD ["java","-jar","demo-1-1.0.jar"]