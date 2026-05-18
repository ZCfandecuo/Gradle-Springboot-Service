package com.johnny.singlegradlespringboot.service;

import com.johnny.singlegradlespringboot.config.LoginParams;
import com.johnny.singlegradlespringboot.config.Result;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    Result sendCode(String phone, HttpSession session);

    Result verifyUser(LoginParams loginParams, HttpSession session);
}
