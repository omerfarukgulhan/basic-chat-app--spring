package com.ofg.websocket.service;

import com.ofg.websocket.model.User;
import com.ofg.websocket.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void saveUser(User user) {
        user.setOnline(true);
        userRepository.save(user);
    }

    public void disconnect(User user) {
        User storedUser = userRepository.findById(user.getUserName()).orElse(null);
        if (storedUser != null) {
            storedUser.setOnline(false);
            userRepository.save(storedUser);
        }
    }

    public List<User> getConnectedUsers() {
        return userRepository.findAllByOnline(true);
    }
}
