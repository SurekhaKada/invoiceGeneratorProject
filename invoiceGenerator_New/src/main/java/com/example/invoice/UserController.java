package com.example.invoice;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import ch.qos.logback.classic.Logger;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    private static final Logger logger = (Logger) LoggerFactory.getLogger(UserController.class);

    @PostMapping
    public Users createUser(@RequestBody Users user) {
        logger.info("Received request to create user: {}", user);
        return userService.createUser(user);
    }

    @GetMapping
    public List<Users> getAllUsers() {
        logger.info("Received request to get all users");
        return userService.getAllUsers();
        
    }
    
    

}
   