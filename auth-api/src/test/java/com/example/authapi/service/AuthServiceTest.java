package com.example.authapi.service;

import com.example.authapi.client.AuthClient;
import com.example.authapi.dto.AuthRequest;
import com.example.authapi.dto.AuthResponse;
import com.example.authapi.dto.UserData;
import com.example.authapi.model.LoginLog;
import com.example.authapi.repository.LoginLogRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class AuthServiceTest {

    @Mock
    private AuthClient authClient;

    @Mock
    private LoginLogRepository loginLogRepository;

    @InjectMocks
    private AuthService authService;

    public AuthServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testLoginAndFetchUser() {
        AuthRequest request = new AuthRequest("emilys", "emilyspass");

        AuthResponse authResponse = new AuthResponse();
        authResponse.setToken("abc123");
        authResponse.setRefreshToken("ref123");

        UserData userData = new UserData();
        userData.setUsername("emilys");

        when(authClient.login(request)).thenReturn(authResponse);
        when(authClient.getUser("Bearer abc123")).thenReturn(userData);

        UserData result = authService.loginAndFetchUser(request);

        assertEquals("emilys", result.getUsername());
        verify(loginLogRepository, times(1)).save(any(LoginLog.class));
    }
}