package com.shoppingList.ShoppingList.service;

import com.shoppingList.ShoppingList.model.User;

public interface UserService {
    User register(User user);

    User findByUsername(String username);

    User findById(Long id);

    void delete(Long id);

}
