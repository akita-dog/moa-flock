package com.akita.moa.auth.service;

import reactor.core.publisher.Mono;

public interface AuthnService {
    Mono<String> login(String username, String password);
}
