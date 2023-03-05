package com.example.seti.config;

import com.example.seti.filter.JwtFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

    @Value("${jwt.token.secret}")
    private String secretKey;

    @Bean
    public FilterRegistrationBean jwtFilter() {
        FilterRegistrationBean filter= new FilterRegistrationBean();
        JwtFilter jwtFilter = new JwtFilter();
        jwtFilter.setSecretKey(secretKey);
        filter.setFilter(jwtFilter);
        return filter;
    }
}
