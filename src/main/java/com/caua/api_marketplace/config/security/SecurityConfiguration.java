package com.caua.api_marketplace.config.security;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
    @Autowired
    SecurityFilter securityFilter;
    @Bean
    public SecurityFilterChain configure(final HttpSecurity http) throws Exception {
        return http
                .csrf(csrf-> csrf.disable())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(authorizeRequests -> authorizeRequests
                        .requestMatchers(HttpMethod.POST , "/auth/registerClient").permitAll()
                        .requestMatchers(HttpMethod.POST , "/auth/login").permitAll()
                        .requestMatchers(HttpMethod.POST , "/product/create").hasAuthority("ROLE_ADMIN")
                        .requestMatchers(HttpMethod.POST , "/auth/registerAdmin").hasAuthority("ROLE_ADMIN")
                        .requestMatchers(HttpMethod.POST , "/auth/registerProducer").hasAuthority("ROLE_ADMIN")
                        .requestMatchers(HttpMethod.POST , "/reservation/create").hasAuthority("ROLE_CLIENT")
                        .requestMatchers(HttpMethod.GET , "/reservation/getAllByProducer/").hasAuthority("ROLE_CLIENT")
                        .requestMatchers(HttpMethod.GET , "/reservation/getAllByClient/").hasAuthority("ROLE_CLIENT")
                        .requestMatchers(HttpMethod.GET , "/reservation/getAll").hasAuthority("ROLE_CLIENT")
                        .requestMatchers(HttpMethod.GET , "/product/getAll").hasAuthority("ROLE_CLIENT")
                        .requestMatchers(HttpMethod.GET , "/product/getAllByCategory/").hasAuthority("ROLE_CLIENT")
                        .requestMatchers(HttpMethod.GET , "/product/getAllByProducer/").hasAuthority("ROLE_CLIENT")
                        .requestMatchers(HttpMethod.GET , "/product/getAllByProducerAndCategory/").hasAuthority("ROLE_CLIENT")
                        .requestMatchers(HttpMethod.PUT , "/reservation/update").hasAuthority("ROLE_CLIENT")
                        .requestMatchers(HttpMethod.PUT , "/product/update").hasAuthority("ROLE_ADMIN")
                        .requestMatchers(HttpMethod.DELETE , "/product/delete").hasAuthority("ROLE_ADMIN")
                        .requestMatchers(HttpMethod.DELETE , "/reservation/delete/").hasAuthority("ROLE_CLIENT")
                        .anyRequest().authenticated()
                )
                .addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
