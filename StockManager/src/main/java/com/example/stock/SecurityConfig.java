package com.example.stock;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.example.stock.security.CustomAuthenticationFailureHandler;
import com.example.stock.security.CustomAuthenticationSuccessHandler;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/index.html").permitAll() // 允許訪問公共資源
                .anyRequest().authenticated() // 所有其他請求需要身份驗證
                .and()
            .formLogin()
                .loginPage("/login.html") // 自定義登入頁面的路徑
                .permitAll() // 允許所有用戶訪問登入頁面
                .and()
            .logout()
                .permitAll(); // 允許所有用戶登出
    }


    @Bean
    @Override
    public UserDetailsService userDetailsService() {
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

        UserDetails user = User.builder()
            .username("abc")
            .password(encoder.encode("123"))
            .roles("USER")
            .build();

        return new InMemoryUserDetailsManager(user);
    }
    
    @Bean
    public AuthenticationSuccessHandler authenticationSuccessHandler() {
        return new CustomAuthenticationSuccessHandler(); // 自定義的成功處理程序
    }

    @Bean
    public AuthenticationFailureHandler authenticationFailureHandler() {
        return new CustomAuthenticationFailureHandler(); // 自定義的失敗處理程序
    }
}

