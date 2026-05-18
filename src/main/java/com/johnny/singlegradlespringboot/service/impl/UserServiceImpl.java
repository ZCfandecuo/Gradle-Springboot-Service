package com.johnny.singlegradlespringboot.service.impl;

import com.johnny.singlegradlespringboot.config.LoginParams;
import com.johnny.singlegradlespringboot.config.Result;
import com.johnny.singlegradlespringboot.service.UserService;
import com.johnny.singlegradlespringboot.utils.ConstUtils;
import jakarta.servlet.http.HttpSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

@Service

public class UserServiceImpl implements UserService {
    @Autowired
    StringRedisTemplate redisTemplate;
    private final Logger log = LogManager.getLogger();

    @Override
    public Result sendCode(String phone, HttpSession session) {
        String code = "123456";
        if(phone.length()!=11){return Result.fail("Please input correct phone number");}
        redisTemplate.opsForValue().set("login_code:"+phone, code, 5, TimeUnit.MINUTES);
        log.info("Code:{} send success", code);

        return Result.ok();
    }

    @Override
    public Result verifyUser(LoginParams loginParams, HttpSession session) {
        String account = loginParams.account();
        log.info(ConstUtils.PREFIX_LOGIN+account+loginParams.code());
        if(Objects.equals(redisTemplate.opsForValue().get(ConstUtils.PREFIX_LOGIN+account), loginParams.code())) {
            return Result.ok();
        }
        return Result.fail("Verify code is error!");
    }


}
