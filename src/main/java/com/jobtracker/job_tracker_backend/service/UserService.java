package com.jobtracker.job_tracker_backend.service;

import com.jobtracker.job_tracker_backend.model.User;
import com.jobtracker.job_tracker_backend.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder; // 🔥 ADD

    // 🔥 SIGNUP
    public User register(User user) {

        // check email already exists
        if (repository.findByEmail(user.getEmail()).isPresent()) {
            throw new RuntimeException("Email already registered");
        }

        // 🔐 HASH PASSWORD
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        return repository.save(user);
    }

    // 🔐 LOGIN
    public User login(String email, String password) {

        User user = repository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        // 🔥 MATCH HASHED PASSWORD
        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        return user;
    }
}