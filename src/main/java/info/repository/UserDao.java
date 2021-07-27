package info.repository;

import info.model.User;

public interface UserDao {
    User addUser(User user);

    User update(User user);

    void deleteUser(long id);

    User getUser(String login);

    User get(long id);

}
