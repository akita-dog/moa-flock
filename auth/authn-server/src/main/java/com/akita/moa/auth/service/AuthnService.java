package com.akita.moa.auth.service;

public interface AuthnService {
    String login(String username, String password);

    String validate(String token);
}
