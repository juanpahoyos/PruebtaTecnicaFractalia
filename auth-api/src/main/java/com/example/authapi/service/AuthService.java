package com.example.authapi.service;

import com.example.authapi.client.AuthClient;
import com.example.authapi.dto.AuthRequest;
import com.example.authapi.dto.AuthResponse;
import com.example.authapi.dto.UserData;
import com.example.authapi.model.LoginLog;
import com.example.authapi.repository.LoginLogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthClient authClient;
    private final LoginLogRepository loginLogRepository;

    public UserData loginAndFetchUser(AuthRequest request) {
        AuthResponse authResponse = authClient.login(request);

        String bearerCookie = "Bearer " + authResponse.getToken();
        UserData user = authClient.getUser(bearerCookie);

        LoginLog log = new LoginLog();
        log.setUsername(request.getUsername());
        log.setAccessToken(authResponse.getToken());
        log.setRefreshToken(authResponse.getRefreshToken());
        log.setLoginTime(LocalDateTime.now());

        loginLogRepository.save(log);

        return user;
    }
}