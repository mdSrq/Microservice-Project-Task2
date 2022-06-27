# Microservice-Project-Task2
Project Work for Microservice - AXYYA Digital

## Task 2 Swagger Codegen.  
Create the same API as in task #1, but use https://editor.swagger.io/ to create your API and generate the server code.
- [x] Use Swagger Editor to create API and generate the server code.
  <img src="./screenshots/Codegen Yaml.png">
- [x] Once your stub is ready implement same funcationlity as described in task #1, Finally show how you application responds to requests using postman or any other HTTP client.
  - [x] GET servers.
  - [x] Should return all the servers if no parameters are passsed.   
    <img src="./screenshots/Codegen getServers.png"> 
  - [x] When server id is passed as a parameter, return a single server.  
    <img src="./screenshots/Codegen getServer.png">
  - [x] Return 404 if there's no such server found in the database.   
    <img src="./screenshots/Codegen getServerNotFound.png">
- [x] PUT a server.
  - [x] Add/Update : The server object is passed as json-encoded message body.   
    <img src="./screenshots/Codegen addServer.png">
- [x] Delete a server. The parameter is a server ID.  
    <img src="./screenshots/Codegen deleteServer.png">
- [x] GET(find) server by name. The parameter is a string, must check if a server name contains this string.   
  - [x] Return one or more servers found.
      <img src="./screenshots/Codegen findServer.png">
  - [X] Return 404 if nothing is found.
      <img src="./screenshots/Codegen findServerNotFound.png">
