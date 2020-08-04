package com.akita.moa.auth.service.impl;

import com.akita.moa.auth.service.AuthnService;
import com.akita.moa.auth.util.JwtTokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthnServiceImpl implements AuthnService {
    @Autowired
    private UserDetailsService service;

    @Autowired
    private JwtTokenUtils jwtTokenUtils;

    @Override
    public String login(String username, String password) {
        if (!"akita".equals(username)) {
            throw new UsernameNotFoundException("用户名未找到");
        }

        if (!"123456".equals(password)) {
            throw new BadCredentialsException("密码错误");
        }

        UserDetails userDetails = service.loadUserByUsername(username);

        return jwtTokenUtils.generateToken(userDetails);
    }
}
