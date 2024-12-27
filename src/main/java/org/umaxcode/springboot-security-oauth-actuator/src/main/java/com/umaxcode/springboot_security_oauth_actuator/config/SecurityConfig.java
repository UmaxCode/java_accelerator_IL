package com.umaxcode.springboot_security_oauth_actuator.config;

import com.umaxcode.springboot_security_oauth_actuator.security.FederatedIdentityAuthSuccessHandler;
import com.umaxcode.springboot_security_oauth_actuator.security.JWTSecurityFilterChain;
import com.umaxcode.springboot_security_oauth_actuator.security.UserRepositoryOAuth2UserHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableMethodSecurity
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final UserRepositoryOAuth2UserHandler userRepositoryOAuth2UserHandler;

    @Bean
    public SecurityFilterChain configure(HttpSecurity http,
                                         JWTSecurityFilterChain jwtSecurityFilterChain
    ) throws Exception {

        http
                .csrf(AbstractHttpConfigurer::disable)
                .cors(Customizer.withDefaults())
                .authorizeHttpRequests(authorizeRequests ->
                        authorizeRequests.requestMatchers("/auth/**").permitAll()
                                .anyRequest().authenticated())
                .formLogin(Customizer.withDefaults())
                .oauth2Login(oauth -> oauth.successHandler(authenticationSuccessHandler()))
                .addFilterBefore(jwtSecurityFilterChain, UsernamePasswordAuthenticationFilter.class)
                .sessionManagement(sessionManagement ->
                        sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        return http.build();
    }

    private AuthenticationSuccessHandler authenticationSuccessHandler() {
        FederatedIdentityAuthSuccessHandler successHandler = new FederatedIdentityAuthSuccessHandler();
        successHandler.setOAuth2UserHandler(userRepositoryOAuth2UserHandler);
        return successHandler;
    }


}
