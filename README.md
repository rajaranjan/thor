# Thor Backend Service
This is the backend api microservice for getting the standing of league. This is running on port 8080. There is no dev and prod build separation in docker. It is kept simple as there is no production environment given for deployment.

## Github code link
https://github.com/rajaranjan/thor

## Basic configuration file Structure 
1. Dockerfile 
2. .dockerignore
3. .gitignore
4. Jenkinsfile
5. README.md

## Swagger documentation link 
- Link : http://localhost:8080/swagger-ui/index.html#/

## Written one testcase to test business logic
- FootballApiTests ( For simplicity written one test case. Although more unit tests should be written for real project )

## Running the App using docker
- Build : docker build -t rajaranjans/thor .
- Run : docker run -p 8080:8080 rajaranjans/thor

## Pulling from docker hub and running ( Deliberately made it public )
- LINK : docker pull rajaranjans/thor:latest 

## CI/CD pipeline
Jenkins file is added. When we run jenkins job it pulls the code from github main branch, builds a docker image and push to docker hub.To keep it simple not added complete CI/CD thing like dev and prod environment. It can be setup.