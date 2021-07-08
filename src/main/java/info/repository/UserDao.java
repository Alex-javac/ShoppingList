package info.repository;

import info.model.User;

public interface UserDao {
    boolean addUser(User user);
    boolean update(int id);
    boolean deleteUser(int id);
    User getUser(String login, String password);
}
