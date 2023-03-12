package br.com.avanade.dio.apis.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@Profile("prd")
public class SecurityConfigurationPrd {

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
            .authorizeHttpRequests(auth ->
                    auth.requestMatchers(HttpMethod.POST, "/api/v1/client").permitAll()
                    .anyRequest().authenticated()
            );

        return http.build();
    }
}
