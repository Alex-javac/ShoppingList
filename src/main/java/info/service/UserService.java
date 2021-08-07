package info.service;

import info.model.User;
import info.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {


    private UserDao userDao;

    @Autowired
    public UserService(@Qualifier("userDaoHibernateImpl") UserDao userDao) {
        this.userDao = userDao;
    }

    public User getUser(User user) {
        return userDao.getUserByLogin(user.getLogin());
    }

    public boolean addUser(User user) {
        return userDao.addUser(user) != null;
    }

}
