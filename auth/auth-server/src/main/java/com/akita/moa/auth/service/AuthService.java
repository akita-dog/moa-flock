package com.akita.moa.auth.service;

import reactor.core.publisher.Mono;

public interface AuthService {
    Mono<String> login(String username, String password);

    Mono<String> validate(String token);
}
