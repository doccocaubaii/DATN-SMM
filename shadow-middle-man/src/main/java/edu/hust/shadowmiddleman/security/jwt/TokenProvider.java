package edu.hust.shadowmiddleman.security.jwt;


import io.jsonwebtoken.*;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

@Component
@Log4j2
public class TokenProvider {


    private final String jwtSecret;

    private final int jwtExpirationInMs;

    private final JwtParser jwtParser;

    public TokenProvider(@Value("${app.jwtExpirationInMs}") int jwtExpirationInMs,
                         @Value("${app.jwtSecret}") String jwtSecret) {
        this.jwtExpirationInMs = jwtExpirationInMs;
        this.jwtSecret = jwtSecret;
        this.jwtParser = Jwts.parser()
                .verifyWith(getSigningKey())
                .build();
    }

    public String generateToken(Authentication authentication) {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + jwtExpirationInMs);
        String authorities = authentication.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.joining(","));
        return Jwts.builder()
                .subject(userDetails.getUsername())
                .claim("auth", authorities)
                .issuedAt(new Date())
                .expiration(expiryDate)
                .signWith(getSigningKey())
                .compact();
    }

    public String generateToken(String username, String authorities) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + jwtExpirationInMs);
        return Jwts.builder()
                .subject(username)
                .claim("auth", authorities)
                .issuedAt(new Date())
                .expiration(expiryDate)
                .signWith(getSigningKey())
                .compact();
    }

    public String getUsernameFromJWT(String token) {
        Claims claims = this.jwtParser
                .parseSignedClaims(token)
                .getPayload();

        return claims.getSubject();
    }

    public Authentication getAuthentication(String token) {
        Claims claims = this.jwtParser.parseSignedClaims(token).getPayload();

        Collection<? extends GrantedAuthority> authorities = Arrays
                .stream(claims.get("auth").toString().split(","))
                .filter(auth -> !auth.trim().isEmpty())
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
        User principal = new User(claims.getSubject(), "", authorities);
        return new UsernamePasswordAuthenticationToken(principal, token, authorities);
    }

    public boolean validateToken(String authToken) {
        try {
            Jwts.parser()
                    .verifyWith(getSigningKey())
                    .build()
                    .parseSignedClaims(authToken);
            return true;
        } catch (SignatureException ex) {
            // Invalid JWT signature
            System.out.println("Invalid JWT signature");
        } catch (MalformedJwtException ex) {
            // Invalid JWT token
            System.out.println("Invalid JWT token");
        } catch (ExpiredJwtException ex) {
            // Expired JWT token
            System.out.println("Expired JWT token");
        } catch (UnsupportedJwtException ex) {
            // Unsupported JWT token
            System.out.println("Unsupported JWT token");
        } catch (IllegalArgumentException ex) {
            // JWT claims string is empty
            System.out.println("JWT claims string is empty");
        } catch (JwtException ex) {
            log.error(ex.getMessage(), (Object) ex.getStackTrace());
        }
        return false;
    }

    private SecretKey getSigningKey() {
        byte[] keyBytes = this.jwtSecret.getBytes(StandardCharsets.UTF_8);
        ;
        return new SecretKeySpec(keyBytes, "HmacSHA256");
    }
}
