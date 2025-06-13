package com.example.authapi.client;

import com.example.authapi.dto.AuthRequest;
import com.example.authapi.dto.AuthResponse;
import com.example.authapi.dto.UserData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "authClient", url = "https://dummyjson.com/auth")
public interface AuthClient {

    @PostMapping("/login")
    AuthResponse login(@RequestBody AuthRequest request);

    @GetMapping("/me")
    UserData getUser(@RequestHeader("Cookie") String cookie);
}