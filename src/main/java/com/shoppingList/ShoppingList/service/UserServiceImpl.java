package com.shoppingList.ShoppingList.service;

import com.shoppingList.ShoppingList.model.Role;
import com.shoppingList.ShoppingList.model.User;
import com.shoppingList.ShoppingList.repository.RoleRepository;
import com.shoppingList.ShoppingList.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User register(User user) {
        Role role = roleRepository.findByRole("ROLE_USER");
        List<Role> userRoles = new ArrayList<>();
        userRoles.add(role);
        user.setRoles(userRoles);
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        User registeredUser = userRepository.save(user);
        return registeredUser;
    }

    @Override
    public User findByUsername(String username) {
        User user = userRepository.findByUsername(username);
        return user;
    }

    @Override
    public User findById(Long id) {
        User result = userRepository.findById(id).orElse(null);
        return result;
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
