package com.example.oauth_2._no.springsec;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class LoginApi {


    @PostMapping("/login")
    public String login (@RequestBody User user)
    {
        long currentTimeMillis = System.currentTimeMillis();
        return Jwts.builder()
                //dla jakiego usera
                .setSubject(user.getLogin())
                //klucz wartosc - np rola
                .claim("roles","user")
                //czas od kiedy aktywny token
                .setIssuedAt(new Date(currentTimeMillis))
                //kiedy wygasa
                .setExpiration(new Date(currentTimeMillis + 2000000))
                //tutaj (typ szyfrowania (tuatj HMAC), haslo)
                .signWith(SignatureAlgorithm.HS256,user.getPassword())
                //typ token - zmiana na string
                .compact();

    }
}
