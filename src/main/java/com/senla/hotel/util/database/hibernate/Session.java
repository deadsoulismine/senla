package com.senla.hotel.util.database.hibernate;

import com.senla.hotel.backend.domain.Guest;
import com.senla.hotel.backend.domain.Room;
import com.senla.hotel.backend.domain.Service;
import com.senla.hotel.util.dependency.stereotype.Component;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.List;

@Component
public class Session implements ISession {
    private SessionFactory sessionFactory = null;

    public SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration().configure();
                configuration.addAnnotatedClass(Guest.class);
                configuration.addAnnotatedClass(Room.class);
                configuration.addAnnotatedClass(Service.class);
                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());

            } catch (Exception e) {
                System.out.println("Исключение!" + e);
            }
        }
        return sessionFactory;
    }

    public void updateObject(Object object) {
        org.hibernate.Session tempSession = getSessionFactory().openSession();
        Transaction transaction = tempSession.beginTransaction();
        tempSession.merge(object);
        transaction.commit();
        tempSession.close();
    }

    public void updateList(List list) {
        org.hibernate.Session tempSession = getSessionFactory().openSession();
        Transaction transaction = tempSession.beginTransaction();
        for (Object object : list) {
            tempSession.merge(object);
        }
        transaction.commit();
        tempSession.close();
    }
}
