package com.example.security.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Slf4j
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        log.info("build Auth global.......");

        auth.inMemoryAuthentication()
                .withUser("manager")
                .password("{noop}1111")
                .roles("ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/guest/**").permitAll()           // permitAll: 모든 사용자가 접근가능
                .antMatchers("/account/**").hasRole("MANAGER")  // hasRole: 해당 룰을 가진 사용자 접근가
                .antMatchers("/account/**").hasRole("ADMIN")
                .antMatchers("/admin/**").hasRole("ADMIN");

        http.formLogin();   // 스프링시큐리티에서 제공하는 기본 로그인페이지를 사용하겠다.
        http.exceptionHandling().accessDeniedPage("/accessDenied");
        http.logout().logoutUrl("/logout").invalidateHttpSession(true); // invalidateHttpSession: 브라우저가 종료되면 로그아웃
    }
}
