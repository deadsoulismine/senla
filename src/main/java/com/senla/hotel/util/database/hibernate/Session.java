package com.senla.hotel.util.database.hibernate;

import com.senla.hotel.backend.domain.Guest;
import com.senla.hotel.backend.domain.Room;
import com.senla.hotel.backend.domain.Service;
import com.senla.hotel.util.dependency.stereotype.Component;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

@Component
public class Session implements ISession {
    public SessionFactory getSessionFactory() {
        SessionFactory sessionFactory = null;
        try {
            Configuration configuration = new Configuration().configure();
            configuration.addAnnotatedClass(Guest.class);
            configuration.addAnnotatedClass(Service.class);
            configuration.addAnnotatedClass(Room.class);
            StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
            sessionFactory = configuration.buildSessionFactory(builder.build());
        } catch (Exception e) {
            System.out.println("Исключение!" + e);
        }
        return sessionFactory;
    }
}
