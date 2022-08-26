package org.example.dao;

import org.example.config.HibernateUtils;
import org.example.entity.onetoone.Person;
import org.example.entity.onetoone.Vehicle;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class VehicleRepository {

    private final SessionFactory sessionFactory = HibernateUtils.getSessionFactory();


    public void insert(Vehicle vehicle) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        try {
            session.save(vehicle);
            session.getTransaction().commit();
        } catch (HibernateException hibernateException) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }


    public Vehicle findById(int vehicleId){
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        Vehicle vehicle = session.get(Vehicle.class, vehicleId);
        session.close();


        return vehicle;
    }


}
