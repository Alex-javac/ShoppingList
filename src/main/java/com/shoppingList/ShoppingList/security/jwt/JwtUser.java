package com.shoppingList.ShoppingList.security.jwt;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.shoppingList.ShoppingList.model.Group;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;
import java.util.List;

public class JwtUser implements UserDetails {


    private final long id;
    private final String email;
    private final String username;
    private final String password;
    private final String firstName;
    private final String lastName;
    private final String nickName;
    private final Date created;
    private final Date updated;
    private final List<Group> group;
    private final Collection<? extends GrantedAuthority> authorities;

    public JwtUser(long id, String email, String username, String password, String firstName, String lastName, String nickName, Date created, Date updated, List<Group> group, Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.email = email;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.nickName = nickName;
        this.created = created;
        this.updated = updated;
        this.group = group;
        this.authorities = authorities;
    }

    @JsonIgnore
    public Long getId() {
        return id;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @JsonIgnore
    @Override
    public String getPassword() {
        return password;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getNickName() {
        return nickName;
    }

    @JsonIgnore
    public Date getCreated() {
        return created;
    }

    @JsonIgnore
    public Date getUpdated() {
        return updated;
    }

    public List<Group> getGroup() {
        return group;
    }
}
