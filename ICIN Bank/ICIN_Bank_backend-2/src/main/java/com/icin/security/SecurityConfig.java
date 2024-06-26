package com.icin.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.icin.entity.Role;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {	
		http.csrf(t ->t.disable());
			http.authorizeHttpRequests(request ->request
				.requestMatchers("/api/auth/**")
				.permitAll()
				.requestMatchers("/api/admin/**").hasAnyRole("ADMIN")
				.requestMatchers("/api/user/**").hasAnyRole("CUSTOMER")
				.anyRequest()
				.authenticated())
			.httpBasic(Customizer.withDefaults())
			.formLogin(Customizer.withDefaults());
		return http.build();
	}
	
	@Bean
	public PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
}
