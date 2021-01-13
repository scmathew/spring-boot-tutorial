package com.frankmoley.lil.sbet.landon.roomwebapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // for any http requests matching the pattern permit all requests that are authenticated
        // Configure login page at /login and force there if unauthenticated

        http.authorizeRequests().antMatchers("/", "/api/*", "/api/rest/*").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login").permitAll()
                .and()
                .logout().permitAll();
    }

    @Autowired
    public void ConfigureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        // Only for demo purposes, not production which is NoOpPasswordEncoder is deprecated
        auth.inMemoryAuthentication().passwordEncoder(NoOpPasswordEncoder.getInstance())
                .withUser("user").password("password").roles("USER");

    }
}
