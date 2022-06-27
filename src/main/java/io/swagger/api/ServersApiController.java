package io.swagger.api;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import io.swagger.annotations.ApiParam;
import io.swagger.model.Server;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2022-06-26T14:37:15.545Z")

@Controller
public class ServersApiController implements ServersApi {
	private ServersApiService service;

    @Autowired
    public ServersApiController(ServersApiService service) {
        this.service = service;
    }

    public ResponseEntity<Void> addServer(@ApiParam(value = "Server object that needs to be added" ,required=true )  @Valid @RequestBody Server server) {
    	return service.addServer(server) ? 
    			new ResponseEntity<Void>(HttpStatus.ACCEPTED) :
    			new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<Void> deleteServer(@ApiParam(value = "Server to delete",required=true) @PathVariable("id") String id) {
    	try {
			service.deleteServer(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (NotFoundException e) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
    }

    public ResponseEntity<List<Server>> findByName(@NotNull @ApiParam(value = "Complete or partial name of the server", required = true) @Valid @RequestParam(value = "name", required = true) String name) {
    	List<Server> servers = service.findServer(name);
		return servers.size() > 0 ? new ResponseEntity<List<Server>>(servers, HttpStatus.OK) :
			new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<Server> getServer(@ApiParam(value = "ID of server to return",required=true) @PathVariable("id") String id) {
    	try {
			return new ResponseEntity<Server>(service.getServer(id), HttpStatus.OK);
		} catch (NotFoundException e) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
    }

    public ResponseEntity<List<Server>> getServers() {
    	return new ResponseEntity<List<Server>>(service.getServers(), HttpStatus.OK);
    }

}
