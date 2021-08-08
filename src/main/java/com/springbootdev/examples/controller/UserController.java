package com.springbootdev.examples.controller;

import com.springbootdev.examples.entity.User;
import com.springbootdev.examples.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/users")
    public User create(@RequestBody User user) {
        return userRepository.save(user);
    }

    @GetMapping("/users")
    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    @PutMapping("/users/{user_id}")
    public User update(@PathVariable("user_id") long userId, @RequestBody User userObject) {
        User user = userRepository.findById(userId).orElse(new User());
        user.setName(userObject.getName());
        user.setCountry(userObject.getCountry());
        return userRepository.save(user);
    }

    @DeleteMapping("/users/{user_id}")
    public Iterable<User> delete(@PathVariable("user_id") long userId) {
        userRepository.deleteById(userId);
        return userRepository.findAll();
    }

    @GetMapping("/users/{user_id}")
    public User findByUserId(@PathVariable("user_id") long userId) {
        return userRepository.findById(userId).orElse(new User());
    }
}
