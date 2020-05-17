## Description
Small web server with "home" and "admin" pages.

## How to build server
`mvn compile assembly:single`

## How to start server
`java -jar server.jar`

## Test manually
* build and run server
* send curl message admin page: 
  ```
  $ curl http://localhost:8080/home
  ```
  you should get number 10 in output. This number is max user limit.
* send "GET" request 10 times to the home page, and then send one more request. etc: you need to need to send max. user limit + 1 requests:
  ```
  # x 11 times by default
  $ curl http://localhost:8080/home
  ```
  at last, you should get message:
  ```
  $ curl http://localhost:8080/home
  Server is closed for maintenance!
  ```
## Run Junit test
* ensure that folder "src/main/test" marked as test root.
* run test from file "src/main/test/servlets/HomePageServletTest.java"

## Run test tool
`./start.bat` or `java -jar tester.jar`