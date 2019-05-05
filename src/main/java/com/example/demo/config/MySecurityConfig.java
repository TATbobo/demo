package com.example.demo.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        //定制授权规则
        http.authorizeRequests().antMatchers("/").permitAll()
                .antMatchers("/dashboard").hasRole("Customer");
        //开启登陆界面
        http.formLogin().usernameParameter("user").passwordParameter("pwd")
                .loginPage("/user/login");
        http.logout().logoutSuccessUrl("/");
        http.rememberMe().rememberMeParameter("remember-me");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //super.configure(auth);
        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder()).withUser("bobo").password(new BCryptPasswordEncoder().encode("123")).roles("Customer","Administrator")
                .and()
                .withUser("xingxing").password("123").roles("VIP2");
    }
}
