package com.oracle.demo.infra.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.oracle.demo.domain.users.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;


@Service
public class TokenService {

    @Value("${JWT_SECRET}:123123")
    private String secret;

    public String generateToken(User user) {
        var algorithm = Algorithm.HMAC256(secret);
        return JWT.create()
                .withIssuer("API forum")
                .withSubject(user.getUsername())
                .withExpiresAt(expiresData())
                .sign(algorithm);
    }


    public String getSubject(String tokenJWT) {
        try {
            var algorithm = Algorithm.HMAC256(secret);
            return JWT.require(algorithm)
                    .withIssuer("API forum")
                    .build()
                    .verify(tokenJWT)
                    .getSubject();

        }catch (JWTVerificationException e) {
            throw new RuntimeException("Token JWT is expired or invalid!");
        }
    }

    private Instant expiresData() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
}

