## Description
Websocket with HTML chat client.

## How to build server
`mvn compile assembly:single`

## How to start server
`java -jar server.jar`

## Test manually
* Test in the command line
   * build and run server
   * run any websocket client utility
   * connect to server via "ws://localhost:8080/chat" and send some message
   * you should get the same message in the reply

Or 
* Test in the browser 
    * Open "http://localhost:8080/chat" in browser and test chat.

## Run test tool
`./start.bat` or `java -jar tester.jar`