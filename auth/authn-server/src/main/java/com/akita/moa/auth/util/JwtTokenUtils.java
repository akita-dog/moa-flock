package com.akita.moa.auth.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import com.akita.moa.auth.config.JwtConfigs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
public class JwtTokenUtils {
    @Autowired
    private JwtConfigs jwtConfigs;

    /**
     * 生成token
     * @param userDetails
     * @return
     */
    public String generateToken(UserDetails userDetails) {
        return generateToken(userDetails.getUsername(), new HashMap<>());
    }

    private String generateToken(String subject, Map<String, Object> claims) {
        return Jwts.builder()
                .setSubject(subject)
                .setClaims(claims)
                .setExpiration(new Date(System.currentTimeMillis() + jwtConfigs.getExpiration() * 1000))
                .signWith(SignatureAlgorithm.HS512, jwtConfigs.getSecurity())
                .compact();
    }

    /**
     * 根据token获取信息
     * @param token
     * @param claimsResolver
     * @param <T>
     * @return
     */
    public <T> T getClaimsByToken(String token, Function<Claims, T> claimsResolver) {
        return claimsResolver.apply(getAllClaimsByToken(token));
    }

    private Claims getAllClaimsByToken(String token) {
        return Jwts.parser()
                .setSigningKey(jwtConfigs.getSecurity())
                .parseClaimsJws(token)
                .getBody();
    }
}
