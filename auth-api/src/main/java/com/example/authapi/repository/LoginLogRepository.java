package com.example.authapi.repository;

import com.example.authapi.model.LoginLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginLogRepository extends JpaRepository<LoginLog, String> {
}