package com.akita.moa.auth.dto.req;

import lombok.Data;

@Data
public class LoginReq {
    private String username;
    private String password;
}
