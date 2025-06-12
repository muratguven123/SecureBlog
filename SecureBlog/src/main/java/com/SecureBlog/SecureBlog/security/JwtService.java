package com.SecureBlog.SecureBlog.security;


import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;

public class JwtService {

    // Güçlü bir secret key (env değişkenlerinden alman önerilir, burada sabit yazdık)
    private static final String SECRET_KEY = "muratguven376-supersecurekey-which-should-be-long-enough";

    // 1 gün = 24 saat * 60 dakika * 60 saniye * 1000 ms
    private static final long EXPIRATION_TIME = 1000 * 60 * 60 * 24;

    // HMAC256 algoritması ile imzalama
    private Algorithm getAlgorithm() {
        return Algorithm.HMAC256(SECRET_KEY);
    }

    /**
     * Kullanıcı adıyla JWT token oluşturur
     */
    public String generateToken(String username) {
        return JWT.create()
                .withSubject(username)
                .withIssuedAt(new Date()) // token oluşturulma zamanı
                .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION_TIME)) // token geçerlilik süresi
                .sign(getAlgorithm()); // token'ı imzala
    }

    /**
     * Token'dan username bilgisini çeker
     */
    public String extractUsername(String token) {
        return getDecodedJWT(token).getSubject();
    }

    /**
     * Token geçerli mi? Süresi dolmamış mı? Doğru kullanıcıya mı ait?
     */
    public boolean isTokenValid(String token, String expectedUsername) {
        try {
            String actualUsername = extractUsername(token);
            return actualUsername.equals(expectedUsername) && !isTokenExpired(token);
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Token süresi dolmuş mu?
     */
    private boolean isTokenExpired(String token) {
        Date expiration = getDecodedJWT(token).getExpiresAt();
        return expiration.before(new Date());
    }

    /**
     * Token'ı decode edip doğrulama yapan yardımcı metot
     */
    private DecodedJWT getDecodedJWT(String token) {
        return JWT.require(getAlgorithm())
                .build()
                .verify(token);
    }
}