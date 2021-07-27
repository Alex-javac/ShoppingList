package info.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.sql.Date;
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
    @Column(name = "create_update")
    private Date date;

    @ManyToMany(fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    @JoinTable(name = "fam_lists", joinColumns = @JoinColumn(name = "lists_id"), inverseJoinColumns = @JoinColumn(name = "fam_id"))
    private List<Group> group;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "lists_products", joinColumns = @JoinColumn(name = "lists_id"), inverseJoinColumns = @JoinColumn(name = "products_id"))
    @Fetch(value = FetchMode.SUBSELECT)
    private List<ProductType.Product> products;
}
