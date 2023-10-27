/*
 * package com.ro.eurekaserver.config;
 * 
 * import org.springframework.context.annotation.Configuration; import
 * org.springframework.security.config.annotation.web.builders.HttpSecurity;
 * import org.springframework.security.web.SecurityFilterChain;
 * 
 * @Configuration public class SecurityConfig { public SecurityFilterChain
 * securityFilterChain(HttpSecurity httpSecurity) throws Exception { //
 * httpSecurity.csrf().ignoringRequestMatchers("/eureka/**");
 * httpSecurity.authorizeHttpRequests(auth ->
 * auth.requestMatchers("/eureka/**").permitAll()); httpSecurity.csrf(csrf ->
 * csrf.disable()); return httpSecurity.build(); } }
 */
