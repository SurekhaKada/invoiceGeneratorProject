package com.example.users;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import com.example.Users.Users;

public class UserTest {
    @Test
    public void testIdGetterSetter() {
        
        Long id = 1L;
        Users user = new Users();

        user.setUserId(id);
        Long retrievedId = user.getUserId();

       
        assertEquals(id, retrievedId);
    }
    @Test
    public void testUsernameGetterSetter() {
        
        String username = "testUser";
        Users user = new Users();
        user.setUserName(username);
        String retrievedUsername = user.getUserName();
        assertEquals(username, retrievedUsername);
    }

    
}

