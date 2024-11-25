package com.jwtapi.jwtapi.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;


import static ch.qos.logback.classic.spi.ThrowableProxyVO.build;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain configure (HttpSecurity http) throws Exception {
        return  http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/home").permitAll()
                        .anyRequest().authenticated()
                )
                .httpBasic()
                .and()
                .csrf()
                .disable()
                .build();

    }

}
