package com.akita.moa.auth.service.impl;

import com.akita.moa.auth.service.AuthService;
import com.akita.moa.auth.util.JwtTokenUtils;
import com.akita.moa.common.exception.ApiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.Collections;

@Service
public class AuthServiceImpl implements AuthService, ReactiveUserDetailsService {
    @Autowired
    private JwtTokenUtils jwtTokenUtils;

    @Override
    public Mono<String> login(String username, String password) {
        return findByUsername(username).switchIfEmpty(Mono.defer(() -> Mono.error(new UsernameNotFoundException("找不到用户"))))
                .map(userDetails -> jwtTokenUtils.generateToken(userDetails));
    }

    @Override
    public Mono<String> validate(String token) {
        return Mono.create(stringMonoSink -> {
            if (jwtTokenUtils.isExpire(token)) {
                stringMonoSink.error(new ApiException("token已过期"));
            } else {
                stringMonoSink.success(jwtTokenUtils.getUsername(token));
            }
        });
    }

    @Override
    public Mono<UserDetails> findByUsername(String username) {
        return "akita".equals(username) ? Mono.just(new User("akita", "123456", Collections.singleton(new SimpleGrantedAuthority("TEST")))) : Mono.empty();
    }
}
