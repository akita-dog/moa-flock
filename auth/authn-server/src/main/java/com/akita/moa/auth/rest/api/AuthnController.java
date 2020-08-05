package com.akita.moa.auth.rest.api;

import com.akita.moa.auth.dto.req.LoginReq;
import com.akita.moa.auth.service.AuthnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
public class AuthnController {
    @Autowired
    private AuthnService service;

    @PostMapping("/login")
    Mono<ResponseEntity<String>> login(@RequestBody LoginReq req) {
        return Mono.just(ResponseEntity.ok(service.login(req.getUsername(), req.getPassword())));
    }

    @GetMapping("/validate/{token}")
    Mono<ResponseEntity<String>> validateToken(@PathVariable String token) {
        return Mono.just(ResponseEntity.ok(service.validate(token)));
    }
}
