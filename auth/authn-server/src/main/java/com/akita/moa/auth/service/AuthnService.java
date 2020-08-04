package com.akita.moa.auth.service;

import reactor.core.publisher.Mono;

public interface AuthnService {
    String login(String username, String password);
}
