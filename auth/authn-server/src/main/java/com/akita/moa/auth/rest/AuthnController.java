package com.akita.moa.auth.rest;

import com.akita.moa.auth.dto.req.LoginReq;
import com.akita.moa.auth.service.AuthnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthnController {
    @Autowired
    private AuthnService service;

    @PostMapping("/login")
    String login(LoginReq req) {
        return null;
    }
}
