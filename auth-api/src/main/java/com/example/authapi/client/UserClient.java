package com.example.authapi.client;

import com.example.authapi.dto.UsersList;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "userClient", url = "https://dummyjson.com")
public interface UserClient {

    @GetMapping("/users")
    UsersList getUsers();
}