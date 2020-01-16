package com.martini.api.controller;


import com.martini.api.entity.User;
import com.martini.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserRestController {
    @Autowired
    UserRepository userRepository;

    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    @PostMapping("/createUser")
    public User createUser(@Valid @RequestBody User user) {
        return userRepository.save(user);
    }

    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable(value = "id") Long id){
        return userRepository.findById(id).orElse(null);
    }

    @PutMapping("/updateUser/{id}")
    public User updateUser(@PathVariable(value = "id") Long id, @Valid @RequestBody User userDetails){
        User user = userRepository.findById(id).orElse(null);
        user.setName(userDetails.getName());
        user.setUsername(userDetails.getUsername());
        User updateNote = userRepository.save(user);
        return updateNote;
    }
    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable(value = "id") Long id){
        User note = userRepository.findById(id).orElse(null);
        userRepository.delete(note);
        return ResponseEntity.ok().build();
    }




}
