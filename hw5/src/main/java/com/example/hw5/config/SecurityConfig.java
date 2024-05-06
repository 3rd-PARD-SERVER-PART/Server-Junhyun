package com.example.hw5.config;

import com.example.seminar5.Oauth.PrincipalOauth2UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    public final PrincipalOauth2UserService principalOauth2UserService;
    private final CorsConfig corsConfig;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable);
        http.addFilter(corsConfig.corsFilter());
        http.authorizeHttpRequests(
                au -> au.anyRequest().permitAll()
        );
        http.oauth2Login(
                oauth -> oauth
                        .loginPage("/loginForm")
                        // 프론트랑 연결할 때 .loginPage("https://localhost:3000") 이렇게 프론트랑 맞춰준다.
                        .defaultSuccessUrl("/home")
                        .userInfoEndpoint(
                                userInfoEndpointConfig ->
                                        userInfoEndpointConfig.userService(principalOauth2UserService)
                        )
        );
        // http로 들어온 oauth 로그인은
        // 로그인을 성공하면 home페이지로 이동
        // principalOauth2UserService 여기에서 로그인 로직 처리를 하겠다
        return http.build();
    }

}
