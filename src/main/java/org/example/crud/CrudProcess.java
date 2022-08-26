package org.example.crud;

import org.example.config.HibernateUtils;
import org.example.entity.onetoone.Person;
import org.example.entity.onetoone.Vehicle;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class CrudProcess {

    private final SessionFactory sessionFactory = HibernateUtils.getSessionFactory();


    public <T> void insert(Object object, Class<T> clazz) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        try {
            T record = clazz.cast(object);
            session.save(record);
            session.getTransaction().commit();
        } catch (HibernateException hibernateException) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }


    public Person findPersonById(int personId){
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

    public Vehicle findVehicleById(int vehicleId){
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Vehicle vehicle = null;

        try{
            vehicle = (Vehicle) sessionFactory
                    .getCurrentSession()
                    .createQuery("from Vehicle where id=:vehicleId")
                    .setParameter("vehicleId", vehicleId)
                    .uniqueResult();

        }catch (HibernateException hibernateException){
            session.getTransaction().rollback();
        }finally {
            session.close();
        }

        return vehicle;
    }

    public List students(int studentId){
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        try{
            return session
                    .createQuery("from Student where id = :student_id")
                    .setParameter("student_id",studentId)
                    .getResultList();


        }catch (HibernateException hibernateException){
            session.getTransaction().rollback();
        }finally {
            session.close();
        }

        return null;
    }





}
