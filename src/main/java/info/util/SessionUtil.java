package info.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

public class SessionUtil {

    private final SessionFactory sessionFactory;

    @Autowired
    public SessionUtil(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session session;
    private Transaction transaction;

    public Session openSession() {
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        return session;
    }

    public void closeSession() {
        transaction.commit();
        session.close();
    }
}

