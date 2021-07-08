package info.service;

import info.model.User;
import info.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class UserService {
   private final UserDao userDao;
@Autowired
    public UserService(@Qualifier("userDaoExternal") UserDao userDao) {
        this.userDao = userDao;
    }

    public User getUser(User user){
        return userDao.getUser(user.getLogin(), user.getPassword());
    }

    public boolean addUser(User user){
    return userDao.addUser(user);
}
}
