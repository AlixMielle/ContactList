package com.example.contactlist.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.logout.HttpStatusReturningLogoutSuccessHandler;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
    @Autowired
    private CustomLogoutHandler logoutHandler;
    @Bean
    public UserDetailsService userDetailsService(){
        return new CustomUserDetailsService();
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        //Configuration de toutes les urls utilisées
        http
                .authorizeHttpRequests()
                .antMatchers("/contacts/all").permitAll()
                .antMatchers("/contacts/details").permitAll()
                .antMatchers("/contacts/add").permitAll()
                .antMatchers("/contacts/edit").permitAll()
                .antMatchers("/contacts/delete").permitAll()
                .antMatchers("/signup").permitAll()
                //.antMatchers("/api/**").permitAll()
        // Configuration des autres urls
                .anyRequest().authenticated()
        //Configuration du login
                .and()
                .formLogin()
                .loginPage("/signin")
                .usernameParameter("email")//nom dans la jsp
                .passwordParameter("password")//nom dans la jsp
                .defaultSuccessUrl("/contacts/all", true)
                .permitAll()
        //Configuration du logout
                .and()
                .logout()
                .logoutUrl("/logout")
                .addLogoutHandler(logoutHandler)
                .logoutSuccessHandler(new HttpStatusReturningLogoutSuccessHandler(HttpStatus.OK))
                .permitAll();

        //http.csrf().ignoringAntMatchers("/books/**");

        return http.build();
    }


    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception{
        return http.getSharedObject(AuthenticationManagerBuilder.class)
                .userDetailsService(userDetailsService())
                .passwordEncoder(passwordEncoder())
                .and()
                .build();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return new WebSecurityCustomizer() {
            @Override
            public void customize(WebSecurity web) {
                web.ignoring().antMatchers("/css/**", "/js/**", "/img/**", "/favicon.ico");
            }
        };
    }

}

