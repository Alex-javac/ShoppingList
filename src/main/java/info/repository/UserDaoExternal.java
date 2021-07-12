package info.repository;

import info.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoExternal implements UserDao {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserDaoExternal(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public boolean addUser(User user) {
        boolean flag = jdbcTemplate.update("INSERT IGNORE user_data(email, create_update) values (?, now())", user.getEmail()) > 0;
        if (flag) {
            jdbcTemplate.update("UPDATE user_data SET first_name = ?, last_name = ? where email = ? ", user.getFirstName(), user.getLastName(), user.getEmail());
            String group = user.getEmail() + "_group";
            jdbcTemplate.update("INSERT fam(name) VALUES (?)", group);
            return jdbcTemplate.update("INSERT users(login, password, nickname, user_data_id, create_update, group_id) " +
                            "values (?,?,?,(Select id from user_data where email= ?), now(), (Select id from fam where name = ?))",
                    user.getLogin(), user.getPassword(), user.getNickName(), user.getEmail(), group) > 0;
        }
        return false;
    }

    @Override
    public User getUser(String login, String password) {
        return jdbcTemplate.query("SELECT users.id, users.nickname, users.login, users.password, user_data.email, user_data.first_name, user_data.last_name " +
                "FROM users, user_data " +
                "WHERE users.user_data_id = user_data.id " +
                "AND users.login = ? " +
                "AND users.password = ?", new BeanPropertyRowMapper<>(User.class), login, password).stream().findAny().orElse(null);
    }

    @Override
    public boolean update(User user) {

        boolean flag1 = jdbcTemplate.update("UPDATE user_data SET email = ?," +
                        " first_name = ?, " +
                        "last_name = ?, " +
                        "create_update = now() " +
                        "WHERE id = (SELECT users.user_data_id FROM users WHERE users.id =?)",
                user.getEmail(), user.getFirstName(), user.getLastName(), user.getId()) > 0;
        boolean flag2 = jdbcTemplate.update("UPDATE users SET nickname = ?, " +
                        "login = ?, " +
                        "password = ?, " +
                        "user_data_id = (SELECT id FROM user_data WHERE email =?)," +
                        "create_update= now()",
                user.getNickName(), user.getLogin(), user.getPassword(), user.getEmail()) > 0;
        return flag1 || flag2;
    }

    @Override
    public void deleteUser(User user) {
        jdbcTemplate.update("DELETE FROM user_data " +
                "WHERE id = (SELECT users.user_data_id FROM users WHERE users.id =?)",
                user.getId());
        jdbcTemplate.update("DELETE FROM users WHERE id = ?", user.getId());
    }
}
