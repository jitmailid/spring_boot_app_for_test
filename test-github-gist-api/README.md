# test-github-gist-api Spring application 

This one is an HTTP web server API built in java Spring Boot that interacts with the GitHub API and responds to requests for a list of the user’s publicly available Gists2. This API responds on the endpoint /<USER>

### Example:

Test Web URL:  http://localhost:8080/octocat (octocat is the user)

# Spring Boot Application

This Spring Boot project template was generated using : [spring initializr](https://start.spring.io/)


# Steps to run application through Docker Container

1. Build docker image

```
docker build -t github-gist-api -f DockerService/Dockerfile .
    OR (if it fails because of cache error)
docker build --no-cache -t github-gist-api -f DockerService/Dockerfile .
```
2. Once the image is built, run the docker container

```
docker run -p 8080:8080 github-gist-api
```
3. After the container is running,test API executing below command

```
curl http://localhost:8080/octocat
```