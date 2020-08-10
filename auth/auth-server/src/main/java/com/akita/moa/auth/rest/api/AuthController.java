package com.akita.moa.auth.rest.api;

import com.akita.moa.auth.dto.req.LoginReq;
import com.akita.moa.auth.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
public class AuthController {
    @Autowired
    private AuthService service;

    @PostMapping("/login")
    Mono<String> login(@RequestBody LoginReq req) {
        return service.login(req.getUsername(), req.getPassword());
    }

    @PostMapping("/validate/token")
    Mono<String> validateToken(@RequestBody String token) {
        return service.validate(token);
    }
}
