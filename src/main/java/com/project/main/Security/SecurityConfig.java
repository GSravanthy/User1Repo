package com.project.main.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
	@Autowired
	private JWTAuthenticationFilter jwtFilter;
	@Bean
	public SecurityFilterChain applicationSecurity(HttpSecurity http) throws Exception {
		http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
		
		http.cors().disable().csrf().disable().sessionManagement()
		.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and()
		.formLogin().disable()
		.securityMatcher("/**")
		.authorizeHttpRequests(registry -> registry
				.requestMatchers("/citizen/register","/auth/login").permitAll()
				.anyRequest().authenticated()
				);
		
		return http.build();
		/*
		 * http.cors().disable().csrf().disable().sessionManagement()
		 * .sessionCreationPolicy(SessionCreationPolicy.STATELESS) .and()
		 * .authorizeRequests()
		 * .requestMatchers("/admin").hasRole(Role.ADMIN.toString())
		 * .requestMatchers("/user").hasRole(Role.USER.toString())
		 * .requestMatchers("/").permitAll() // .anyRequest().authenticated() .and()
		 * .formLogin(); 
		 */
	}
}
