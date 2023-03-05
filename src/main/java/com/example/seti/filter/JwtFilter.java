package com.example.seti.filter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.filter.GenericFilterBean;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.io.IOException;


public class JwtFilter extends GenericFilterBean {


    private String secretKey;

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        final HttpServletRequest request = (HttpServletRequest) servletRequest;
        final HttpServletResponse response = (HttpServletResponse) servletResponse;
        final String authHeader = request.getHeader("authorization");

        if (authHeader == null || !authHeader.startsWith("Bearer ")){
            throw new ServletException("An exception occurred");
        }
        final String token = authHeader.substring(7);
        SecretKey key = Keys.hmacShaKeyFor(secretKey.getBytes());
        try {
            Claims claims = Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody();
//            compareEndPoints(request.getRequestURI(), claims.get("role").toString());
            request.setAttribute("claims", claims);
            request.setAttribute("role", claims.get("role").toString());
            filterChain.doFilter(request, response);
        } catch (JwtException e) {
            throw new ServletException("Токен не активный");
        }
    }

//    private void compareEndPoints(String endpoint, String role) throws ServletException{
//        if (role.equals("user") && endpoint.equals("/test/jwt/admin")) {
//            throw new ServletException("Пользователю с ролью " + role + " недоступна данная функция.");
//        }
//    }
}