## Description
Minimized version of 'L4.1 WebSockets' from this repo

## How to build server
`mvn compile assembly:single`

## How to start server
`java -jar server.jar`

## Test manually
* build and run server
* run any websocket client utility
* connect to server via "ws://localhost:8080/chat" and send some message
* you should get the same message in the reply

## Run test tool
`./start.bat` or `java -jar tester.jar`