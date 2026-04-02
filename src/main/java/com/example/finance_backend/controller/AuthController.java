package com.example.finance_backend.controller;

import com.example.finance_backend.dto.LoginRequest;
import com.example.finance_backend.dto.RegisterRequest;
import com.example.finance_backend.entity.User;
import com.example.finance_backend.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(authService.register(request));
    }
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest request) { //token string stored
        return ResponseEntity.ok(authService.login(request));
    }
}
