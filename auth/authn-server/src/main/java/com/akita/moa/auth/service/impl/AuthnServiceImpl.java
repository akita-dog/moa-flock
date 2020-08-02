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
import reactor.core.publisher.Mono;

@Service
public class AuthnServiceImpl implements AuthnService {
    @Autowired
    private UserDetailsService service;

    @Autowired
    private JwtTokenUtils jwtTokenUtils;

    @Override
    public Mono<String> login(String username, String password) {
        if (!"akita".equals(username)) {
            return Mono.error(new UsernameNotFoundException("用户名未找到"));
        }

        if (!"123456".equals(password)) {
            return Mono.error(new BadCredentialsException("密码错误"));
        }

        UserDetails userDetails = service.loadUserByUsername(username);

        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);

        return Mono.just(jwtTokenUtils.generateToken(userDetails));
    }
}
