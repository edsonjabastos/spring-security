package io.github.edsonjabastos.springsecurity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    // Filters
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(
                authorizeConfig -> {
                    authorizeConfig
                            .requestMatchers("/public").permitAll();
                    authorizeConfig
                            .requestMatchers("/logout").permitAll();
                    authorizeConfig.anyRequest().authenticated();
                })
                .oauth2Login(Customizer.withDefaults())
                // .oauth2ResourceServer((oauth2) -> oauth2.jwt(jwtConfigurer -> jwtConfigurer.jwtAuthenticationConverter(jwtAuthConverter)));
                .oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt);
                // .formLogin(Customizer.withDefaults());
        return http.build();
    }

}
