package ru.learnup.mvc.mvctest.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("Ivan")
                .password("1234")
                .roles("USER")

                .and()
                .withUser("admin")
                .password("admin")
                .roles("ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/api/welcome").hasAnyRole("USER","ADMIN")
                .antMatchers("/api/**").hasAnyRole("USER", "ADMIN")
           //     .antMatchers("/api/**").hasRole()
                .and().formLogin().permitAll();


//        .antMatchers("/api").permitAll()
//                .and().formLogin();
    }

    @Bean
    public PasswordEncoder encoder () {
        return NoOpPasswordEncoder.getInstance();
    }


}
