## How to build server
`mvn compile assembly:single`

## How to start server
`java -jar server.jar`

## Test manually 
`curl -v "http://localhost:8080/mirror?test=key"`

returns "key"

## Run test tool
`./start.bat` or `java -jar tester.jar hello `