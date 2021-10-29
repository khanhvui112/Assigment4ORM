package fa.training.dao.Imp;

import fa.training.dao.EntryTestDao;
import fa.training.enity.EntryTest;
import fa.training.utils.HibernateUtils;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.Serializable;
import java.util.List;

/**
 * @author san vui
 * @create 20/10/2021 - 10:55 PM
 * @sanvankhanh@gmail.com
 */
public class EntryTestDaoImp implements EntryTestDao {
    @Override
    public List<EntryTest> findAll(List<EntryTest> entryTestList) {
        try (Session session = HibernateUtils.getSession()) {
            return session.createQuery("FROM EntryTest").list();
        }
    }

    @Override
    public boolean insertInterView(EntryTest entryTest) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtils.getSession();
            transaction = session.beginTransaction();
            Serializable serializable = session.save(entryTest);
            return (Integer) serializable > 0;
        } catch (Exception e) {
            assert transaction != null;
            transaction.rollback();
            return false;
        } finally {
            assert session != null;
            session.close();
        }
    }

    @Override
    public boolean updateInterView(EntryTest entryTest) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtils.getSession();
            transaction = session.beginTransaction();
            session.update(entryTest);
            transaction.commit();
            return true;
        } catch (Exception e) {
            assert transaction != null;
            transaction.rollback();
            return false;
        } finally {
            assert session != null;
            session.close();
        }
    }

    @Override
    public boolean deleteInterView(int id) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtils.getSession();
            EntryTest entryTest = session.get(EntryTest.class, id);
            if (entryTest != null) {
                transaction = session.beginTransaction();
                session.delete(entryTest);
                transaction.commit();
                return true;
            } else {
                return false;
            }
        } finally {
            assert session != null;
            session.close();
        }
    }
}
