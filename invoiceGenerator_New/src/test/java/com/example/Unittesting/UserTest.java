package com.example.Unittesting;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.example.invoice.Users;


public class UserTest {
    @Test
    public void testIdGetterSetter() {
        
        Long id = 1L;
        Users user = new Users();

        user.setId(id);
        Long retrievedId = user.getId();

       
        assertEquals(id, retrievedId);
    }
    @Test
    public void testUsernameGetterSetter() {
        
        String username = "testUser";
        Users user = new Users();
        user.setName(username);
        String retrievedUsername = user.getName();
        assertEquals(username, retrievedUsername);
    }

    
}

