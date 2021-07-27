package info.repository;

import info.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;



@Repository
public class UserDaoIpm implements UserDao {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserDaoIpm(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public User addUser(User user) {
        return null;
    }

    @Override
    public User update(User user) {
        return null;
    }

    @Override
    public void deleteUser(long id) {

    }

    @Override
    public User getUser(String login) {
        return null;
    }

    @Override
    public User get(long id) {
        return null;
    }
//
//    @Override
//    public boolean addUser(User user) {
//            return jdbcTemplate.update("INSERT INTO users(login, password, nickname, user_data_id, create_update, role_id ) " +
//                            "values (?,?,?,(Select id from user_data where email= ?), now()," +
//                            "(select id from role where role = 'USER'));",
//                    user.getLogin(), user.getPassword(), user.getNickName(), user.getEmail()) > 0;
//        }
//
//    @Override
//    public boolean addUserData(User user) {
//        return jdbcTemplate.update("INSERT INTO user_data(email, create_update, first_name, last_name) values (?, now(),?,?);",
//                user.getEmail(), user.getFirstName(),user.getLastName())>0;
//
//    }
//
//    @Override
//    public User getUser(String login) {
//        return jdbcTemplate.query("SELECT users.id, users.nickname, users.login, users.password, user_data.email, user_data.first_name, user_data.last_name , role.role " +
//                "FROM users, user_data , role " +
//                "WHERE users.user_data_id = user_data.id " +
//                "AND users.role_id = role.id " +
//                "AND users.login = ?;", new BeanPropertyRowMapper<>(User.class), login).stream().findAny().orElse(null);
//    }
//
//    @Override
//    public boolean update(User user) {
//
//      return jdbcTemplate.update("UPDATE user_data SET email = :email," +
//                        " first_name = :first_name, " +
//                        "last_name = :last_name, " +
//                        "create_update = now() " +
//                        "WHERE id = (SELECT users.user_data_id FROM users WHERE users.id =:users.id); " +
//                        "UPDATE users SET nickname = ?, " +
//                        "login = :login, " +
//                        "password = :password, " +
//                        "user_data_id = (SELECT id FROM user_data WHERE email = :email)," +
//                        "create_update= now() " +
//                        "WHERE users.id = :users.id; ",  new MapSqlParameterSource()
//              .addValue(":email", user.getEmail())
//                      .addValue(":first_name",user.getFirstName())
//                      .addValue(":last_name",user.getLastName())
//                      .addValue(":users.id",user.getId())
//                      .addValue(":login",user.getLogin())
//                      .addValue(":password",user.getPassword())) > 0;
//    }
//
//    @Override
//    public void deleteUser(int id) {
//        jdbcTemplate.update("DELETE FROM user_data " +
//                "WHERE id = (SELECT users.user_data_id FROM users WHERE users.id =?)",
//                id);
//        jdbcTemplate.update("DELETE FROM users WHERE id = ?", id);
//    }
}
