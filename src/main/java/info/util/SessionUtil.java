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

        public Session getSession() {
            return session;
        }

        public Transaction getTransaction() {
            return transaction;
        }

        public Session openSession() {
            return sessionFactory.openSession();
        }

        public Session openTransactionSession() {
            session = openSession();
            transaction = session.beginTransaction();
            return session;
        }

        public void closeSession() {
            session.close();
        }

        public void closeTransactionSession() {
            transaction.commit();
            closeSession();
        }
    }

