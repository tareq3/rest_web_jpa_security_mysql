package com.mti.web_jpa_security_mysql.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    //create 2 user for demo

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user").password("{noop}password").roles("USER")
                .and()
                .withUser("admin").password("{noop}password").roles("USER", "ADMIN");

    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/api/v1/books").hasRole("USER")
                .antMatchers(HttpMethod.POST, "/api/v1/books").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/api/v1/books/**").hasRole("USER")
                .antMatchers(HttpMethod.PUT, "/api/v1/books/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/api/v1/books/**").hasRole("ADMIN")
                .and()
                .csrf().disable()
                .formLogin().disable();
    }
}
