package com.bezkoder.springjwt.service;

import com.bezkoder.springjwt.model.User;
import com.bezkoder.springjwt.repository.UserRepository;
import com.bezkoder.springjwt.security.SecurityUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
public class SecurityService {

    private UserRepository userRepository;

    public SecurityService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User isUser() {
        String userId = SecurityUtil.getUserId();
        User user = userRepository.findFirstById(Long.valueOf(userId));
        return user;
    }

    public Boolean isAdmin() {
        return true;
    }

}
