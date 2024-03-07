package com.SpringSecurity.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.SpringSecurity.Security.JWTAuthenticationFilter;
import com.SpringSecurity.Security.JwtAuthenticationEntryPoint;



@Configuration
public class SecurityConfig {
	 @Autowired
	    private JwtAuthenticationEntryPoint point;
	    @Autowired
	    private JWTAuthenticationFilter filter;

	    @Bean
	    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	    	http.csrf(csrf -> csrf.disable())
	    	.cors(cors -> cors.disable())
            .authorizeHttpRequests(auth -> auth.requestMatchers("/auth/login").permitAll().requestMatchers("/home/**").authenticated())
            .exceptionHandling(ex -> ex.authenticationEntryPoint(point))
            
            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
	     
	    	http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
	        return http.build();


}
}
