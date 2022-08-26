package org.example.crud;

import org.example.config.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class TestConnection {

    private final SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
    private final Session session = sessionFactory.getCurrentSession();
    public void test(){
        System.out.println("SessionFactory >> "+sessionFactory);
        System.out.println("Session >> "+ session);
    }
}
