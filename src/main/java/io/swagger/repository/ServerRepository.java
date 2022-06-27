package io.swagger.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import io.swagger.model.Server;


@EnableMongoRepositories
public interface ServerRepository extends MongoRepository<Server, String> {
	List<Server> findByNameContaining(String name);
}
