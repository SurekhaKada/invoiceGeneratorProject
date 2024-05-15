package com.example.Unittesting;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.example.invoice.UserRepository;
import com.example.invoice.Users;


@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testSaveUser() {
    
        Users user = new Users();
        user.setName("surekha");
        user.setEmail("s@example.com");
        Users savedUser = userRepository.save(user);

        // Verify that the user is saved with an ID
        assertNotNull(savedUser.getId());
        assertEquals("surekha", savedUser.getName());
        assertNotEquals("j@example", savedUser.getEmail());
    }

    @Test
    public void testFindByid() {
        
        Users user = new Users();
        user.setName("surekhakada");
        user.setEmail("ske@example.com");
        Users savedUser = userRepository.save(user);

        Optional<Users> optionalUser = userRepository.findById(savedUser.getId());
         assertTrue(optionalUser.isPresent());
        Users foundUser = optionalUser.get();
        assertEquals(savedUser.getId(), foundUser.getId());
        assertEquals("surekhakada", foundUser.getName());
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