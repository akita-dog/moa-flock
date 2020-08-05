package com.akita.moa.auth.service.impl;

import com.akita.moa.auth.service.AuthnService;
import com.akita.moa.auth.util.JwtTokenUtils;
import com.akita.moa.common.exception.ApiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthnServiceImpl implements AuthnService {
    @Autowired
    private JwtTokenUtils jwtTokenUtils;

    @Override
    public String login(String username, String password) {
        if (!"akita".equals(username)) {
            throw new ApiException("用户名未找到");
        }

        if (!"123456".equals(password)) {
            throw new ApiException("密码错误");
        }

        return jwtTokenUtils.generateToken(username);
    }

    @Override
    public String validate(String token) {
        if (jwtTokenUtils.isExpire(token)) throw new ApiException("token已过期");

        return jwtTokenUtils.getUsername(token);
    }
}
