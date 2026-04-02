package com.example.finance_backend.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
public class TestController {
    // Accessible by  loggedin user
    @GetMapping("/all")
    public String all() {
        return "Accessible by all authenticated users";
    }
    // Only for admin
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/admin")
    public String admin() {
        return "Only ADMIN can access";
    }

    // for admin or analyst
    @PreAuthorize("hasAnyRole('ADMIN', 'ANALYST')")
    @GetMapping("/analyst")
    public String analyst() {
        return "ADMIN or ANALYST can access";
    }
}