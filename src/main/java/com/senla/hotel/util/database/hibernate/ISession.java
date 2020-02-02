package com.senla.hotel.util.database.hibernate;

import org.hibernate.SessionFactory;

import java.util.List;

public interface ISession {
    SessionFactory getSessionFactory();

    void updateObject(Object object);

    void updateList(List list);

}
