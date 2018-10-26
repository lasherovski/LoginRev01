package com.group19.comment.g19_comment;


import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .formLogin()
                .loginPage("/pages/login.xhtml").permitAll()
                .loginProcessingUrl("/j_spring_security_check")
                .defaultSuccessUrl("/pages/home.xhtml")
                .failureUrl("/pages/login.xhtml?error=1");
        http
                .logout()
                .logoutUrl("/j_spring_security_logout")
                .logoutSuccessUrl("/pages/login.xhtml");
        http
                .authorizeRequests()
                .antMatchers("/javax.faces.resource/**").permitAll()
                .antMatchers("/pages/**").authenticated();
    }

    @Bean
    public DemoAuthenticationProvider demoSpringSecurityAuthenticationProvider() {
        return new DemoAuthenticationProvider();
    }

}