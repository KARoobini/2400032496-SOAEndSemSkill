package com.example;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;

@Component
public class JwtUtil {

    // Replace with the SAME Base64 secret
    // used to generate your existing JWT token.
    private final String secret = "YOUR_BASE64_SECRET_KEY";

    public boolean validateToken(String token) {

        try {
            SecretKey key = Keys.hmacShaKeyFor(
                    Decoders.BASE64.decode(secret));

            Jwts.parser()
                .verifyWith(key)
                .build()
                .parseSignedClaims(token);

            return true;

        } catch (JwtException | IllegalArgumentException e) {
            return false;
        }
    }
}