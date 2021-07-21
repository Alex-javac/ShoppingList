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
        http.antMatcher("/**")
                .authorizeRequests()
                .antMatchers("/enter").hasRole("USER")
                .antMatchers("/register","/secondPage").hasRole("ADMIN")
                .and()
                .formLogin()
                .and()
                .logout().logoutUrl("*/logout");
    }


    }