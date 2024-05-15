package com.example.Users;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import org.slf4j.LoggerFactory;
import ch.qos.logback.classic.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


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
   


















//import java.util.List;
//import java.util.Optional;

//@RestController
//@RequestMapping("/users")
//public class UserController {
//
//  @Autowired
//  private UserRepository userRepository;
//
//  // Get all users
//  @GetMapping("/")
//  public List<Users> getAllUsers() {
//      return userRepository.findAll();
//  }
//
//  // Get user by ID
//  @GetMapping("/{id}")
//  public Optional<Users> getUserById(@PathVariable Long id) {
//      return userRepository.findById(id);
//  }
//
//  // Create a new user
//  @PostMapping("/")
//  public Users createUser(@RequestBody Users user) {
//      return userRepository.save(user);
//  }
//
//  // Update user details
//  @PutMapping("/{id}")
//  public Users updateUser(@PathVariable Long id, @RequestBody Users user) {
//      if (userRepository.existsById(id)) {
//          user.setUser_id(id); // Ensure the user_id is set correctly
//          return userRepository.save(user);
//      } else {
//          throw new RuntimeException("User not found with id: " + id);
//      }
//  }
//
//  // Delete user by ID
//  @DeleteMapping("/{id}")
//  public void deleteUser(@PathVariable Long id) {
//      userRepository.deleteById(id);
//  }
//}

