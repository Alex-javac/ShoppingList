package info.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


import java.net.URL;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class User {
    private List<ProductList> productLists;
    private List<Group> groupList;
    private int id;
    private String login;
    private String password;
    private String nickName;
    private String firstName;
    private String lastName;
    private String email;
    private String role;
    private URL picture;

}
