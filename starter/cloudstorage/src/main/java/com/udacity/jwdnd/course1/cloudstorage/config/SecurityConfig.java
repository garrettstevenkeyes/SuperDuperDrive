package com.udacity.jwdnd.course1.cloudstorage.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import com.udacity.jwdnd.course1.cloudstorage.services.AuthenticationService;
/*spring will use this as a source of configuration for the IOC context*/
@Configuration
/*lets spring know this class is configuring springs security*/
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private AuthenticationService authenticationService;

    public SecurityConfig(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(this.authenticationService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        /*This method allows any authenticated requests to our /signup page
        * or the the css and jss directories*/
        http.authorizeRequests()
                /*All of these can be accessed without authorization needed*/
                .antMatchers("/signup", "/css/**", "/js/**","/home", "/result").permitAll()
                .anyRequest().authenticated();
        /*This permits all users to access the auto generated login page
        * at /login */
        http.formLogin()
                .loginPage("/login")
                .permitAll();
        /*This method redirects successful logins to the /home page by default*/
        http.formLogin()
                .defaultSuccessUrl("/home", true);
    }

}
