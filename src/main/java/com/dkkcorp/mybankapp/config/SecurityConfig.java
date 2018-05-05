package com.dkkcorp.mybankapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder authenticationManagerBuilder)throws Exception{
        authenticationManagerBuilder
                .inMemoryAuthentication()
                .withUser("david").password("{noop}pass").authorities("ROLE_USER")
                .and()
                .withUser("admin").password("{noop}pass").authorities("ROLE_ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/user/index").hasRole("USER")
                .antMatchers("/admin/index").hasRole("ADMIN")
        .antMatchers("/","/index","/home").permitAll()
        .and()
        .httpBasic().and()
                .formLogin()
                .loginPage("/index")
                .permitAll()
                .and()
                .logout()
                .permitAll();

        super.configure(http);
    }
}
