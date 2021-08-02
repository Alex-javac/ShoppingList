package info.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "price")
    private float price;
    @Column(name = "create_update")
    private Date date;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_type_id")
    private ProductType productType;

    @ManyToMany(mappedBy = "products", fetch = FetchType.LAZY)
    private List<ShopList> shopLists;
}