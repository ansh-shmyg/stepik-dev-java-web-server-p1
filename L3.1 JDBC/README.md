## How to build server
`mvn compile assembly:single`

## How to start server
`java -jar server.jar`

## Test manually
* build and run server
* register new user:
    ```
    curl -v -X POST "http://localhost:8080/signin?login=login1&password=login1
    ```
  user should be saved in H2 database after signin.
* restart server
* login as new user
    ```
    curl -v -X POST "http://localhost:8080/signup?login=login1&password=login1
    ```
  returns "Authorized: login1"

## Run test tool
`./start.bat` or `java -jar tester.jar`