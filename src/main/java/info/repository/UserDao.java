package info.repository;

import info.model.User;

public interface UserDao {
    boolean addUser(User user);
    boolean update(User user);
    void deleteUser(int id);
    User getUser(String login, String password);
}
