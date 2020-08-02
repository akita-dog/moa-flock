package com.akita.moa.auth.rest;

import com.akita.moa.auth.dto.req.LoginReq;
import com.akita.moa.auth.service.AuthnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class AuthnController {
    @Autowired
    private AuthnService service;

    @PostMapping("/login")
    Mono<String> login(LoginReq req) {
        return service.login(req.getUsername(), req.getPassword());
    }
}
