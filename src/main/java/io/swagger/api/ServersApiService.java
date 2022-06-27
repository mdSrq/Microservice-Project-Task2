package io.swagger.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.swagger.model.Server;
import io.swagger.repository.ServerRepository;
@Service
public class ServersApiService {
	@Autowired
	private ServerRepository serverRepo;

	public Server getServer(String id) throws NotFoundException {
		Optional<Server> server = serverRepo.findById(id);
		if (server.isEmpty())
			throw new NotFoundException(404,"Invalid ID");
		return server.get();
	}

	public List<Server> getServers() {
		return serverRepo.findAll();
	}

	public boolean addServer(Server server) {
		return serverRepo.save(server) != null;
	}

	public void deleteServer(String id) throws NotFoundException {
		if (serverRepo.findById(id).isEmpty())
			throw new NotFoundException(404, "Invalid ID");
		serverRepo.deleteById(id);
	}

	public List<Server> findServer(String name){
		return serverRepo.findByNameContaining(name);
	}

}
