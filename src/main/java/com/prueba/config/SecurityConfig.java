package com.prueba.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/h2-console/**").permitAll() // Permitir acceso a la consola H2
                .anyRequest().authenticated()
                .and()
                .httpBasic()
                .and()
                .csrf().disable()
                .headers().frameOptions().disable(); // Permitir la visualización de la consola H2 en un iframe
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("user")
                .password("{noop}321") // Spring Security 5 requiere usar el codificador {noop} para contraseñas en texto plano
                .roles("USER");
    }
}