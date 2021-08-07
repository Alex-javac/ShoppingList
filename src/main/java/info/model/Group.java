package info.model;

import javax.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
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

    @OneToMany(mappedBy = "group")
    List<User> users;

    @ManyToMany(mappedBy = "group", fetch = FetchType.LAZY)
    private List<ShopList> shopLists;
}
