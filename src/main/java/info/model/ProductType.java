package info.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Table(name = "product_type")
@Entity
@NoArgsConstructor
public class ProductType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "productType")
    List<Product> products;


    @Getter
    @Setter
    @NoArgsConstructor
    @Entity
    @Table(name = "products")
    public static class Product {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private long id;
        @Column(name = "name")
        private String name;
        @Column(name = "price")
        private float price;

        @ManyToOne(cascade = CascadeType.ALL)
        @JoinColumn(name = "product_type_id", nullable = false)
        private ProductType productType;

        @ManyToMany(mappedBy = "products")
        private List<ShopList> shopLists;
    }
}
