package com.shoppingList.ShoppingList.repository;

import com.shoppingList.ShoppingList.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByRole(String role);
}
