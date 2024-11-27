package com.ofg.websocket.repository;

import com.ofg.websocket.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserRepository extends MongoRepository<User, String> {
    List<User> findAllByOnline(boolean online);
}
