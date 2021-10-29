package fa.training.dao.Imp;

import fa.training.dao.InterViewDao;
import fa.training.enity.InterView;
import fa.training.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.Serializable;
import java.util.List;

/**
 * @author san vui
 * @create 20/10/2021 - 10:55 PM
 * @sanvankhanh@gmail.com
 */
public class InterViewDaoImp implements InterViewDao {
    @Override
    public List<InterView> findAll(List<InterView> interViewList) {
        try (Session session = HibernateUtils.getSession()) {
            return session.createQuery("FROM InterView ").list();
        }
    }

    @Override
    public boolean insertInterView(InterView interView) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtils.getSession();
            transaction = session.beginTransaction();
            Serializable serializable = session.save(interView);
            transaction.commit();
            System.out.println(serializable);
            return (Integer) serializable > 0;
        } catch (Exception e) {
            assert transaction != null;
            transaction.rollback();
            return false;
        } finally {
            session.close();
        }
    }

    @Override
    public boolean updateInterView(InterView interView) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtils.getSession();
            transaction = session.beginTransaction();
            session.update(interView);
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
            InterView interView = session.get(InterView.class, id);
            if (interView != null) {
                transaction = session.beginTransaction();
                session.delete(interView);
                transaction.commit();
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            assert transaction != null;
            transaction.rollback();
            return false;
        } finally {
            assert session != null;
            session.close();
        }
    }
}
