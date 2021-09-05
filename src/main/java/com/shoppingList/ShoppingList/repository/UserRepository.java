package com.shoppingList.ShoppingList.repository;

import com.shoppingList.ShoppingList.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
User findByUsername(String username);
}
