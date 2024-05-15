package com.example.users;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import com.example.Users.UserRepository;
import com.example.Users.Users;


import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testSaveUser() {
    
        Users user = new Users();
        user.setUserName("surekha");
        user.setEmail("s@example.com");
        Users savedUser = userRepository.save(user);

        // Verify that the user is saved with an ID
        assertNotNull(savedUser.getUserId());
        assertEquals("surekha", savedUser.getUserName());
        assertNotEquals("j@example", savedUser.getEmail());
    }

    @Test
    public void testFindByid() {
        
        Users user = new Users();
        user.setUserName("surekhakada");
        user.setEmail("ske@example.com");
        Users savedUser = userRepository.save(user);

        Optional<Users> optionalUser = userRepository.findById(savedUser.getUserId());
         assertTrue(optionalUser.isPresent());
        Users foundUser = optionalUser.get();
        assertEquals(savedUser.getUserId(), foundUser.getUserId());
        assertEquals("surekhakada", foundUser.getUserName());
        assertNotEquals("sk@example.com", foundUser.getEmail());
    }
    
   
    @Test
    public void findNonExistentUserByIdTest() {
        // Find a user with a non-existent ID
        Optional<Users> foundUser = userRepository.findById(-1L);
        
        assertFalse(foundUser.isPresent());
    }
    @Test
    public void saveNullUser() {
        try {
            userRepository.save(null);
        } catch (Exception e) {
            // Expected Exception occurred, test passed
            return;
        }
        fail("Expected IllegalArgumentException was not thrown");
    }

}

