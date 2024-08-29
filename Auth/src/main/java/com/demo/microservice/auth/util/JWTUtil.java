package com.demo.microservice.auth.util;

import com.demo.microservice.user.model.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.util.Date;

public class JWTUtil {
    private static final long TTL = 10000;
    private static final SecretKey secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    public static String generateToken(User user) {
        String token = Jwts.builder()
                .setSubject(user.getUsername())
                .setExpiration(new Date(System.currentTimeMillis() + TTL))
                .signWith(secretKey)
                .compact();
        return "Bearer " + token;
    }

    public static boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token.substring(7));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}