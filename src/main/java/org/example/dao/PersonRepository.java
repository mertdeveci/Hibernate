package org.example.dao;

import org.example.config.HibernateUtils;
import org.example.entity.onetomany.Intructor;
import org.example.entity.onetoone.Person;
import org.example.entity.onetoone.Vehicle;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class PersonRepository {


    private final SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
    VehicleRepository vehicleRepository = new VehicleRepository();


    public void insert(Person person) {
        Session session = sessionFactory.getCurrentSession();

        Vehicle vehicle = vehicleRepository.findById(23);

        person.setVehicle(vehicle);

        try {
            session.save(person);
            session.getTransaction().commit();
        } catch (HibernateException hibernateException) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }

    public Person findById(int personId){
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Person person = null;

        try{
            person = (Person) sessionFactory
                    .getCurrentSession()
                    .createQuery("from Person where id=:personId")
                    .setParameter("personId", personId)
                    .uniqueResult();

        }catch (HibernateException hibernateException){
            session.getTransaction().rollback();
        }finally {
            session.close();
        }

        return person;
    }


    public Person findById2(int personId){
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        return session.get(Person.class, personId);
    }





}
