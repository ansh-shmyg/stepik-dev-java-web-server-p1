## How to build server
`mvn compile assembly:single`

## How to start server
`java -jar server.jar`

## Test manually
```
curl -v -X POST "http://localhost:8080/signup?login=login1&password=login1
curl -v -X POST "http://localhost:8080/signin?login=login1&password=login1
```
returns "Authorized: login1"

## Run test tool
`./start.bat` or `java -jar tester.jar`