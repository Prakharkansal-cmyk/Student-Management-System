package com.Students.Student_Management_system.service;

import com.Students.Student_Management_system.model.User;
import com.Students.Student_Management_system.repository.UserRepository;
import com.Students.Student_Management_system.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    public String register(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return "User registered successfully!";
    }

    public String login(User user) {
        User existing = userRepository.findByUsername(user.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (passwordEncoder.matches(user.getPassword(), existing.getPassword())) {
            return jwtUtil.generateToken(existing.getUsername());
        }
        throw new RuntimeException("Invalid credentials");
    }
}
