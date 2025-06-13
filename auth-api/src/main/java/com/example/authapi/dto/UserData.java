package com.example.authapi.dto;

import lombok.Data;

@Data
public class UserData {
    private int id;
    private String username;
    private String email;
    private String firstName;
    private String lastName;
}