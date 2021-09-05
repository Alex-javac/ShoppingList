package com.shoppingList.ShoppingList.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "lists")
public class ShopList {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "created")
    private java.util.Date created;
    @Column(name = "updated")
    private Date updated;

    @ManyToMany(fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    @JoinTable(name = "fam_lists",
            joinColumns = @JoinColumn(name = "lists_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "fam_id", referencedColumnName = "id"))
    private List<Group> groupShop;

    @ManyToMany(fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    @JoinTable(name = "lists_products",
            joinColumns = @JoinColumn(name = "lists_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "products_id", referencedColumnName = "id"))
    private List<Product> products;
}
