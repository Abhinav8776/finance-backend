package com.example.finance_backend.service;

import com.example.finance_backend.dto.LoginRequest;
import com.example.finance_backend.dto.RegisterRequest;
import com.example.finance_backend.entity.User;
import com.example.finance_backend.entity.Role;
import com.example.finance_backend.repository.UserRepository;
import com.example.finance_backend.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    public User register(RegisterRequest request) {
        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(Role.valueOf(request.getRole()));
        user.setActive(true);

        return userRepository.save(user);
    }
    public String login(LoginRequest request) {

        User user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) { // this will check the password is correct
            // by comparing stored hash with combining salt+reuestpass then make its new hash if it equals to stored hash
            throw new RuntimeException("Invalid password");
        }

        return jwtService.generateToken(user); //giving token instead of user name+pass so we dont need to login for make new request
    }
}