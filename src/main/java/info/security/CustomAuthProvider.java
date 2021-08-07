package info.security;

import info.model.User;
import info.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class CustomAuthProvider implements AuthenticationProvider {


    private final UserDao userDao;

    @Autowired
    public CustomAuthProvider(UserDao userDao) {
        this.userDao = userDao;
    }


    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        User user = userDao.getUserByLogin(authentication.getName());
        if (authentication.getCredentials().equals(user.getPassword())) {
            return new UsernamePasswordAuthenticationToken(user, null, Collections.singleton(new SimpleGrantedAuthority(user.getRole().getRole())));
        }
        return new UsernamePasswordAuthenticationToken(user, null);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
