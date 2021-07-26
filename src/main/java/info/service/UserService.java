package info.service;

import info.model.User;
import info.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {


   private UserDao userDao;
@Autowired
    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public User getUser(User user){
        return userDao.getUser(user.getLogin());
    }
@Transactional(rollbackFor = Exception.class)
    public boolean addUser(User user){
    return userDao.addUserData(user) && userDao.addUser(user);
}

}
