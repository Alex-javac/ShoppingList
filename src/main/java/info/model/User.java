package info.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.net.URL;
import java.util.List;

@Getter
@Setter
public class User {
    private List<ProductList> productLists;
    private List<Group> groupList;
    private String login;
    private String password;
    private String nickName;
    private String firstName;//
    private String lastName;//
    private String email;//
    private URL picture;
}
