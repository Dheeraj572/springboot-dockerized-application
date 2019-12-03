# springboot-dockerized-application
Lets you dockerize a springboot application

Procedure to build and run docker image:
1)Open project in cmd and go to the location where Dockerfile exist
2)Run command docker build -f Dockerfile -t spring-boot-docker .
3)Run command docker run -p 5000:5000 spring-boot-docker


