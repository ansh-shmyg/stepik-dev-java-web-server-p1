## Description
Small web server with "resources" page which can read xml file.

## How to build server
`mvn compile assembly:single`

## How to start server
`java -jar server.jar`

## Test manually
* build and run server
* create xml file in the repository root: 
    ```$xslt
    <class name="resources.TestResource">
        <name>Gendalf</name>
        <age>70</age>
    </class>
    ```
  save it with some name etc. "example.xml"
* send curl message resources page with path parameter: 
  ```
  $ curl http://localhost:8080/resources?path=example.xml
  ```
  or 
    ```
    $ curl -X POST http://localhost:8080/resources?path=example.xml
    ```
  In the output you should get "name" and "age" parameter defined in the xml.
* Additionally you can check variables ResourceServerController.name ResourceServerController.age in jconsole (JMX).
  Those variables should have values from xml file.
## Run test tool
`./start.bat` or `java -jar tester.jar`