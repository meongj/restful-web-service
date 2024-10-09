package com.in28minutes.rest.webservices.security;
import static  org.springframework.security.config.Customizer.withDefaults;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfiguration {
    // SecurityFilterChain은 문지기 역할
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // 1. authentiucated 한지 체크
        http.authorizeHttpRequests(
                auth -> auth.anyRequest().authenticated()
        );
        // 2.authentiucated 하지 않으면,  로그인 page 보여줌
        http.httpBasic(withDefaults());
        // 3. CSRF → POST, PUT
        http.csrf().disable();
    return http.build();
    }
}
