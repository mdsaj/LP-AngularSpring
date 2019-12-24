package com.example.Controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Entity.User;
import com.example.Repository.UserRepository;

@RestController
@CrossOrigin(origins = { "http://localhost:4200", "*"})
public class UserController {
 
    @Autowired 
    private UserRepository userRepository;
    
    @GetMapping("/getUsers")
    public List<User> getUsers() {
        return (List<User>) userRepository.findAll();
    }
 
    @PostMapping("/addUser")
    void addUser(@RequestBody User user) {
        userRepository.save(user);
    }
}
