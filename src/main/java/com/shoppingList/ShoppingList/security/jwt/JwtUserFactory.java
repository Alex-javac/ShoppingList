package com.shoppingList.ShoppingList.security.jwt;

import com.shoppingList.ShoppingList.model.Role;
import com.shoppingList.ShoppingList.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public final class JwtUserFactory {
    public JwtUserFactory() {
    }

    public static JwtUser create(User user) {
        return new JwtUser(
                user.getId(),
                user.getEmail(),
                user.getUsername(),
                user.getPassword(),
                user.getFirstName(),
                user.getLastName(),
                user.getNickName(),
                user.getCreated(),
                user.getUpdated(),
                user.getGroupUser(),
                mapToGrantedAuthorities(new ArrayList<>(user.getRoles()))
        );
    }
    private static List<GrantedAuthority> mapToGrantedAuthorities(List<Role> userRoles) {
        return userRoles.stream()
                .map(role ->
                        new SimpleGrantedAuthority(role.getRole())
                ).collect(Collectors.toList());
    }
}
