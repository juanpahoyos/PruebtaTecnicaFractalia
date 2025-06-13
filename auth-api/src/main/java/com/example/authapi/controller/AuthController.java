package com.example.authapi.controller;

import com.example.authapi.dto.AuthRequest;
import com.example.authapi.dto.UserData;
import com.example.authapi.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<UserData> login(@RequestBody AuthRequest request) {
        UserData user = authService.loginAndFetchUser(request);
        return ResponseEntity.ok(user);
    }
}