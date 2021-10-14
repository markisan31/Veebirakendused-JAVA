package com.bezkoder.springjwt.service;

import com.bezkoder.springjwt.model.User;
import com.bezkoder.springjwt.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public User get(Long id){
        return userRepository.findFirstById(id);
    }

    public User insert(User user) {
        user.setId(user.getId());

        return userRepository.save(user);
    }

    public User update(User user) {

        return userRepository.save(user);
    }

    public void delete(Long id) {
        boolean exists = userRepository.existsById(id);
        if (exists) {
            userRepository.deleteById(id);
        }
    }

    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(u -> users.add(u));
        return users;
    }
}
