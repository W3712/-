package com.itheima.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;


@Data
@Component
@ConfigurationProperties(prefix = "jwt")
public class MyJwt {
    private String key;
    private String algorithmName;

    public String createToken(Map<String,Object> map,Long time){
        String token = Jwts.builder()
                .setClaims(map)
                .signWith(SignatureAlgorithm.valueOf(algorithmName), key)
                .setExpiration(new Date(System.currentTimeMillis() + time))
                .compact();
        return token;
    }
    public Map<String,Object> parseToken(String token){
        return Jwts.parser()
                .setSigningKey(key)
                .parseClaimsJws(token)
                .getBody();
    }

}
