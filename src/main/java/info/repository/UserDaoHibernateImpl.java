package info.repository;

import info.model.Group;
import info.model.Role;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import info.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoHibernateImpl implements UserDao {

    private final SessionFactory sessionFactory;

    @Autowired
    public UserDaoHibernateImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public User addUser(User user) {
        Session session = getSession();
        Role role = session.get(Role.class, 1L);
        user.setRole(role);
        Group group = session.get(Group.class, 1L);
        user.setGroup(group);
        System.out.println(user);
        session.save(user);
        return user;
    }

    @Override
    public User update(User user) {
        return null;
    }

    @Override
    public void deleteUser(long id) {
        Session session = getSession();
        session.delete(session.get(User.class, id));
    }

    @Override
    public User getUser(String login) {
        Query query = getSession().createSQLQuery("from users where login = :login");
        query.setString("login", login);
        User u = (User) query.uniqueResult();
        return u;
    }

    @Override
    public User get(long id) {
        Session session = getSession();
        return session.get(User.class, id);
    }

    private Session getSession() {
        return sessionFactory.openSession();
    }
}
