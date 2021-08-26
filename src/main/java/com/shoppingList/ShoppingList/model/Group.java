package com.shoppingList.ShoppingList.model;

import javax.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "fam")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "name")
    private String name;



    @ManyToMany(mappedBy = "groupUser", fetch = FetchType.LAZY)
    private List<User> usersGroup;

    @ManyToMany(mappedBy = "groupShop", fetch = FetchType.LAZY)
    private List<ShopList> shopLists;
}
