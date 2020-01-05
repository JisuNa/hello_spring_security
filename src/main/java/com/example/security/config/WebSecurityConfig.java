package com.example.security.config;

import com.example.security.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Slf4j
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private AccountService accountService;

    public WebSecurityConfig(AccountService accountService) {
        this.accountService = accountService;
    }

    @Autowired
    public void configure(AuthenticationManagerBuilder auth) throws Exception {

        // Type 1 - 암호화 ID/PW (=하드코딩)
//        log.info("build Auth global.......");
//        String password = passwordEncoder().encode("password");
//        auth.inMemoryAuthentication()
//                .withUser("manager")
//                .password(password)
//                .roles("ADMIN");

        // Type 2 - 암호화 ID/PW (=기본 DB)
//        auth.jdbcAuthentication()
//                .rolePrefix(AppConstBean.SECURITY_ROLE_PREFIX)
//                .dataSource(dataSource)
//                .usersByUsernameQuery(AppConstBean.SECURITY_USERS_BY_USERNAME_QUERY)
//                .authoritiesByUsernameQuery(AppConstBean.SECURITY_AUTHORITIES_BY_USERNAME_QUERY);

        auth.userDetailsService(accountService).passwordEncoder(passwordEncoder());

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

//         permitAll : 모든 접근자를 항상 승인
//         denyAll : 모든 사용자의 접근을 거부
//         anonymous : 사용자가 익명 사용자인지 확인
//         authenticated : 인증된 사용자인지 확인
//         rememberMe : 사용자가 remember me를 사용해 인증했는지 확인
//         fullyAuthenticated : 사용자가 모든 크리덴셜을 갖춘 상태에서 인증했는지 확인

        http.authorizeRequests()
                .antMatchers("/guest/**").permitAll()           // permitAll: 모든 사용자가 접근가능
                .antMatchers("/account/**").hasRole("MANAGER")  // hasRole: 해당 룰을 가진 사용자 접근가
                .antMatchers("/account/**", "/admin/**").hasRole("ADMIN");

        http.formLogin();   // 스프링시큐리티에서 제공하는 기본 로그인페이지를 사용하겠다.
        http.exceptionHandling().accessDeniedPage("/accessDenied");
        http.logout()
                .logoutUrl("/logout")           // 로그아웃 처리 URL
                .logoutSuccessUrl("/")          // 로그아웃 성공시 이동 URL
                .invalidateHttpSession(true);   // invalidateHttpSession: 브라우저가 종료되면 로그아웃
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
