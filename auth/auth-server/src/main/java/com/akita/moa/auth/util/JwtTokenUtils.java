package com.akita.moa.auth.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import com.akita.moa.auth.config.JwtConfigure;
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
    private JwtConfigure jwtConfigure;

    /**
     *
     * @param userDetails
     * @return
     */
    public String generateToken(UserDetails userDetails) {
        return generateToken(userDetails.getUsername(), new HashMap<>());
    }

    private String generateToken(String subject, Map<String, Object> claims) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setExpiration(new Date(System.currentTimeMillis() + jwtConfigure.getExpiration() * 1000))
                .signWith(SignatureAlgorithm.HS512, jwtConfigure.getSecurity())
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
        return claimsResolver.apply(getClaimsByToken(token));
    }

    private Claims getClaimsByToken(String token) {
        return Jwts.parser()
                .setSigningKey(jwtConfigure.getSecurity())
                .parseClaimsJws(token)
                .getBody();
    }

    public Boolean isExpire(String token) {
        return getClaimsByToken(token, Claims::getExpiration).before(new Date());
    }

    public String getUsername(String token) {
        return getClaimsByToken(token, Claims::getSubject);
    }
}
