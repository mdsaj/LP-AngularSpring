package com.example.Controler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Entity.User;
import com.example.Repository.UserRepository;

@RestController
@CrossOrigin(origins = { "http://localhost:4200", "*"})
public class UserController {
 
    @Autowired 
    private UserRepository userRepository;
    
    @Autowired
    private MongoOperations mongoOperations;
    
    @PostMapping("/addUser")
    void addUser(@RequestBody User user) {
        userRepository.save(user);
    }
    
    @GetMapping("/getUsers")
    public List<User> getUsers() {
        return (List<User>) userRepository.findAll();
    }
    
    @GetMapping("/getUser/{id}")
    public Optional<User> getUserById(@PathVariable long id) {
        return userRepository.findById(id);
    }
    
    @PutMapping("/updateUser")
    public void updateUserById(@RequestBody User user) {
    	Query query = new Query();
    	Update update = new Update();
		query.addCriteria(Criteria.where("id").is(user.getId()));
		update.set("name", user.getName());
		update.set("email", user.getEmail());
		mongoOperations.updateFirst(query, update, User.class);
    }
    
    @DeleteMapping("/deleteUser/{id}")
    public Map<String, String> deleteUserById(@PathVariable long id) {
        userRepository.deleteById(id);
        HashMap<String, String> map = new HashMap<>();
        map.put("message", "User " + id + " deleted successfully");
        return map;
    }
}
