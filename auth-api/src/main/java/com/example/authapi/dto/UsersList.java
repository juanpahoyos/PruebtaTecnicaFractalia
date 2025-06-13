package com.example.authapi.dto;

import lombok.Data;
import java.util.List;

@Data
public class UsersList {
    private List<UserData> users;
}