package com.example.invoice;

import java.time.LocalDate;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import ch.qos.logback.classic.Logger;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    private static final Logger logger = (Logger) LoggerFactory.getLogger(UserService.class);

    public Users createUser(Users user) {
        user.setSignInDate(LocalDate.now());
        logger.info("Creating user: {}", user);
        return userRepository.save(user);
    }

    public List<Users> getAllUsers() {
        logger.info("Fetching all users");
        return userRepository.findAll();
    }


    }
