package info.config;

import info.security.CustomAuthProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private String[] OPEN_ENDPOINTS = {"/", "/index", "/registration", "/secondPage", "/break", "/enterBreak","/check-user"};
    private final CustomAuthProvider provider;

    @Autowired
    public SecurityConfig(CustomAuthProvider provider) {
        this.provider = provider;
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(provider);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().disable()
                .csrf().disable()
                .authorizeRequests()
                .antMatchers(OPEN_ENDPOINTS).permitAll()
                .antMatchers("/enter", "/shopList").hasRole("USER")
                .antMatchers("/admin").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .and()
                .logout().logoutUrl("*/index");

    }


}