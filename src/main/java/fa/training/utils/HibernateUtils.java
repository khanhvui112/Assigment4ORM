package fa.training.utils;

import fa.training.enity.Candidate;
import fa.training.enity.EntryTest;
import fa.training.enity.InterView;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * @author san vui
 * @create 19/10/2021 - 4:43 PM
 * @sanvankhanh@gmail.com
 */
public class HibernateUtils {
    private static final SessionFactory sessionFactory;

    static {
        Configuration configuration = new Configuration();

        ServiceRegistry registry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties()).build();
        configuration.addAnnotatedClass(Candidate.class);
        configuration.addAnnotatedClass(EntryTest.class);
        configuration.addAnnotatedClass(InterView.class);

        sessionFactory = configuration.buildSessionFactory(registry);
    }

    public static Session getSession() {
        return sessionFactory.openSession();
    }

    public static void closerSession() {
        sessionFactory.close();
    }
}
