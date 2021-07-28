package info.repository;

import info.model.Group;
import info.model.Role;
import info.model.User;
import info.util.SessionUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.Calendar;

@Repository
public class UserDaoHibernateImpl extends SessionUtil implements UserDao {

    public UserDaoHibernateImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public User addUser(User user) {
        openTransactionSession();
        Session session = getSession();
        Role role = session.get(Role.class, 1L);
        user.setRole(role);
        Group group = session.get(Group.class, 1L);
        user.setGroup(group);
        user.setDate(new Date(Calendar.getInstance().getTime().getTime()));
        System.out.println("addUser after: " + user);
        session.save(user);
        closeTransactionSession();
        System.out.println("addUser before: " + user);
        return user;
    }

    @Override
    public User update(User user) {
        return null;
    }

    @Override
    public void deleteUser(long id) {
        openTransactionSession();
        Session session = getSession();
        session.delete(session.get(User.class, id));
        closeTransactionSession();
    }

    @Override
    public User getUserByLogin(String login) {
        openTransactionSession();

        Session session = getSession();
        String sql = "SELECT * FROM users WHERE login = :login";
        Query query = session.createNativeQuery(sql).addEntity(User.class);
        query.setParameter("login", login);
        User user = (User) query.getSingleResult();

        closeTransactionSession();
        return user;
    }

    @Override
    public User getUserById(long id) {
        openTransactionSession();

        String sql = "SELECT * FROM users WHERE id = :id";
        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(User.class);
        query.setParameter("id", id);
        User user = (User) query.getSingleResult();

        closeTransactionSession();

        return user;
    }

}