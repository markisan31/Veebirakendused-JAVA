package com.bezkoder.springjwt.controller;

import com.bezkoder.springjwt.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import com.bezkoder.springjwt.model.User;
import com.bezkoder.springjwt.service.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;
    private UserRepository userRepository;

    public UserController(UserService userService) {
        this.userService = userService;
    }

//    @GetMapping
//    public List<User> findAll() {
//        log.info(userService.findAll().stream().findAny().get().getFirstName());
//        return userService.findAll();
//    }

    @GetMapping("")
    public String listUsers(Model model) {
        List<User> listUsers = userService.findAll();
        model.addAttribute("listUsers", listUsers);

        return "users";
    }

    @GetMapping("/{id}")
    public User get(@PathVariable("id") Long id) {
        return userService.get(id);
    }

//    @PostMapping("")
//    public User insert(@RequestBody User user) {
//        User newUser = userService.insert(user);
//        return newUser;
//    }

    @PutMapping("/{id}")
    public User update(@RequestBody User user) {
        User updatedUser = userService.update(user);
        return updatedUser;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        userService.delete(id);
    }

    @PostMapping("/process_register")
    public User processRegister(@RequestBody User user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        User newUser = userService.insert(user);
        return newUser;
    }
}
