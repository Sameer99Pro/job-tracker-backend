package com.jobtracker.job_tracker_backend.controller;

import com.jobtracker.job_tracker_backend.model.User;
import com.jobtracker.job_tracker_backend.security.JwtUtil;
import com.jobtracker.job_tracker_backend.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = {
        "http://localhost:5173",
        "http://localhost:5174",
        "https://job-tracker-frontend-zeta-wine.vercel.app"
})
public class AuthController {

    @Autowired
    private UserService service;

    @Autowired
    private JwtUtil jwtUtil;

    // 🔥 SIGNUP
    @PostMapping("/signup")
    public User register(@RequestBody User user) {
        return service.register(user);
    }

    // 🔐 LOGIN (FIXED)
    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody User user) {

        // 🔥 IMPORTANT: Service use karo (bcrypt yahin handle hoga)
        User dbUser = service.login(user.getEmail(), user.getPassword());

        // 🔐 JWT token
        String token = jwtUtil.generateToken(dbUser.getEmail());

        Map<String, Object> response = new HashMap<>();
        response.put("token", token);
        response.put("user", dbUser);

        return response;
    }
}