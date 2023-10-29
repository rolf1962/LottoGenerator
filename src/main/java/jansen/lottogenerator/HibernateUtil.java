/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jansen.lottogenerator;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import jansen.lottogenerator.model.SixOfFortyNinePojo;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author Rolf
 */
public class HibernateUtil {

    //XML based configuration
    private static SessionFactory sessionFactory;

    public HibernateUtil() {
        if (null == sessionFactory) {
            sessionFactory = buildSessionFactory();
        }
    }

    //Annotation based configuration
    private SessionFactory buildSessionFactory() {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
            Configuration configuration = new Configuration();
            configuration.configure("hibernate.cfg.xml");
            configuration.addAnnotatedClass(SixOfFortyNinePojo.class);

            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
            SessionFactory factory = configuration.buildSessionFactory(serviceRegistry);

            return factory;
        } catch (HibernateException ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public void save(SixOfFortyNinePojo sixOfFortyNineRow) {
        Session session = sessionFactory.getCurrentSession();
        // Zahlenreihe in einer Transaktion in die Datenbank schreiben
        session.beginTransaction();
        session.save(sixOfFortyNineRow);
        session.getTransaction().commit();

    }
}
