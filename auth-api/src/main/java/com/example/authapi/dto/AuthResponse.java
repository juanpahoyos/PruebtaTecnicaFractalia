package com.example.authapi.dto;

import lombok.Data;

@Data
public class AuthResponse {
    private String token;
    private String refreshToken;
    private long expiresIn;
}