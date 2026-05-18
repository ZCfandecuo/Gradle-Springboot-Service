package com.johnny.singlegradlespringboot.controller;


import com.johnny.singlegradlespringboot.config.LoginParams;
import com.johnny.singlegradlespringboot.config.Result;
import com.johnny.singlegradlespringboot.service.UserService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
public class UserLoginController {
    @Resource
    private UserService userService;


    @GetMapping("/code")
    public Result sendCode(@RequestParam("phone")String phone, HttpSession session){
        return userService.sendCode(phone, session);
    }

    @PostMapping("/login")
    public Result loginVerify(@RequestBody LoginParams loginParams, HttpSession session){
        return userService.verifyUser(loginParams, session);
    }
}
