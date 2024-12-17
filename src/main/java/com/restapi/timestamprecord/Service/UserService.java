package com.restapi.timestamprecord.Service;

import com.restapi.timestamprecord.Entity.User;
import com.restapi.timestamprecord.Ripo.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public void addUser(User user) {
        userRepository.save(user);
    }
    public List<User> findUser() {
        return userRepository.findAll();
    }
}
